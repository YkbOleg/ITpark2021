package lesson24;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class BookAndAuthor {

    @CsvBindByName(column = "ISBN")
    private String isbn;
    @CsvBindByName(column = "Автор")
    private String authorName;
    @CsvBindByName(column = "Название")
    private String title;
    @CsvBindByName(column = "Количество страниц")
    private int numberPages;
    @CsvBindByName(column = "Год выпуска")
    private int yearOFIssue;
    @CsvBindByName(column = "Издательство")
    private String publishingHouse;

}
