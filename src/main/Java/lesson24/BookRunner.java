package lesson24;

import lesson24.jdbc.BookDb;
import org.apache.commons.lang3.tuple.Pair;

public class BookRunner {

    public static void main(String[] args) {
        System.out.println("Удалим таблицы");
        BookDb.dropIfExists();
        System.out.println("Создадим таблицы");
        BookDb.createBooksAndAuthors();

        System.out.println("Заполним таблици из файла");
        CsvMapper.getBook().stream().map( bookAndAuthor -> Pair.of(
                new Author(bookAndAuthor.getAuthorName()),
                new Book(bookAndAuthor.getIsbn(),
                        bookAndAuthor.getTitle(),
                        bookAndAuthor.getNumberPages(),
                        bookAndAuthor.getYearOFIssue(),
                        bookAndAuthor.getPublishingHouse()))).forEach( pair ->
                BookDb.insertAuthor(pair.getLeft()).ifPresent(authorId ->
                        BookDb.insertBook(authorId, pair.getRight()))
        );
    }
}