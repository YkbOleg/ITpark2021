package lesson24.jdbc;

import lesson24.Author;
import lesson24.Book;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;
import java.util.Properties;

@UtilityClass
public class BookDb {

    private final Properties DB_SETTINGS = new Properties();

    static {
        try{
            DB_SETTINGS.load(BookDb.class.getResourceAsStream("/db.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_SETTINGS.getProperty("jdbc.url"),
                DB_SETTINGS.getProperty("db.login"),
                DB_SETTINGS.getProperty("db.password"));
    }

    @SneakyThrows(SQLException.class)
    public void dropIfExists() {
        try(final Connection connection = getConnection();
            final PreparedStatement dropIfExistsBooks = connection.prepareStatement("DROP TABLE if EXISTS books");
            final PreparedStatement dropIfExistsAuthors = connection.prepareStatement("DROP TABLE if EXISTS authors")){
            dropIfExistsBooks.execute();
            dropIfExistsAuthors.execute();
        }
    }

    @SneakyThrows(SQLException.class)
    public void createBooksAndAuthors() {
        try(final Connection connection = getConnection();
            final PreparedStatement dropIfExistsBooks = connection.prepareStatement(
                        """
                               create table authors
                               (
                                   id   int auto_increment,
                                   name varchar(100) not null unique,
                                   constraint authors_pk
                                       primary key (id)
                               );
                               """);
            final PreparedStatement dropIfExistsAuthors = connection.prepareStatement(
                        """
                               create table books
                               (
                                   id               int auto_increment,
                                   isbn             varchar(17)  not null unique,
                                   title            varchar(100) not null,
                                   pages            int          null,
                                   year_of_issue    int          null,
                                   publishing_house varchar(50)  null,
                                   author_id        int          null,
                                   constraint books_pk
                                       primary key (id),
                                   constraint books_authors_id_fk
                                       foreign key (author_id) references authors (id)
                               );
                               """)){
            dropIfExistsBooks.execute();
            dropIfExistsAuthors.execute();
        }
    }

    @SneakyThrows(SQLException.class)
    public Optional<Integer> insertAuthor (Author author) {
        final String authorName = author.getAuthorName();
        if (StringUtils.isBlank(authorName)) {
            return Optional.empty();
        }
        try(final Connection connection = getConnection();
            final PreparedStatement authorStatement = connection.prepareStatement(
                    "INSERT INTO authors(name) VALUES (?)");
            final PreparedStatement searchAuthorStatement = connection.prepareStatement(
                    "SELECT id FROM authors WHERE name = ?") ) {
            authorStatement.setString(1, authorName);
            authorStatement.execute();
            searchAuthorStatement.setString(1, authorName);
            final ResultSet resultSet = searchAuthorStatement.executeQuery();
            while (resultSet.next()){
                return Optional.of(resultSet.getInt("id"));
            }
        }
        return Optional.empty();
    }

    @SneakyThrows(SQLException.class)
    public void insertBook (Integer authorId, Book book) {
        try(final Connection connection = getConnection();
            final PreparedStatement bookStatement = connection.prepareStatement(
                    """
                          INSERT INTO books(isbn, title, pages, year_of_issue, publishing_house, author_id)
                          VALUES (?, ?, ?, ?, ?, ?)
                          """)
            ) {
            bookStatement.setString(1, book.getIsbn());
            bookStatement.setString(2, book.getTitle());
            bookStatement.setInt(3, book.getNumberPages());
            bookStatement.setInt(4, book.getYearOFIssue());
            bookStatement.setString(5, book.getPublishingHouse());
            bookStatement.setInt(6, authorId);
            bookStatement.execute();
        }
    }
}
