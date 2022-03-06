package lesson26;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lesson26.service.ExchangeRateable;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan("lesson26")
public class ExchangeRateRunner {

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ExchangeRateRunner.class);
        final ExchangeRateable er = annotationConfigApplicationContext.getBean(ExchangeRateable.class);

        for (String valute : er.jsonMappingValute()) {
            System.out.println(valute);
        }
        System.out.print("Введите валюту из списка: ");
        String valute = er.input();

        System.out.println(er.jsonMappingValutes(valute));
    }

}
