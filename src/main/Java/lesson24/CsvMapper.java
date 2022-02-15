package lesson24;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CsvMapper {

    public static List<BookAndAuthor> getBook () {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CsvMapper.class.getResourceAsStream("/book.csv")))){
            CsvToBean<BookAndAuthor> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(BookAndAuthor.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.stream().collect(Collectors.toList());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
