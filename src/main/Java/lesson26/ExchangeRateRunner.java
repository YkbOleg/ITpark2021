package lesson26;

import lesson26.service.ExchangeRateable;
import org.json.JSONObject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Configuration
@ComponentScan("lesson26")
public class ExchangeRateRunner {

    private static final String EXIT_PHRASE = "-1";
    private static boolean haveOrNot = false;
    private static String valute = "";

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ExchangeRateRunner.class);
        final ExchangeRateable exchangeRateable = annotationConfigApplicationContext.getBean(ExchangeRateable.class);

        JSONObject json = exchangeRateable.getJsonFromUrl();
        List<String> valutesCode = Arrays.stream(JSONObject.getNames((JSONObject) json.get("Valute"))).toList();
        List<String> dictionaryValutes = exchangeRateable.jsonMappingValutes();

        for (String valuteName : dictionaryValutes) {
            System.out.println(valuteName);
        }

        while (!EXIT_PHRASE.equalsIgnoreCase(valute)) {
            System.out.printf("Введите валюту из списка (для завершения введите %s): ", EXIT_PHRASE);
            valute = exchangeRateable.input();

                for (String stringValute : valutesCode) {
                    if (Objects.equals(valute.toUpperCase(), stringValute)) {
                        haveOrNot = true;
                        break;
                    }
                }
                if (!haveOrNot && !Objects.equals(valute, "-1")) {
                    System.out.println("Введённого кода валюты нет в списке. Попробуйте еще!");
                } else if(!Objects.equals(valute, "-1")) {
                    System.out.printf("Курс %s на %s : %s \n", valute, json.getString("Date"),
                            exchangeRateable.jsonMappingValute(valute.toUpperCase()));
                    haveOrNot = false;
                }
        }
    }

}
