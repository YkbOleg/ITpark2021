package lesson28;

import lesson28.service.Zipable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Configuration
@ComponentScan("lesson28")
public class ZipRunner {

    private static final String EXIT_PHRASE = "0";
    private static String action = "";
    private static List<String> programList = Arrays.asList("1", "2");
    private static String pathToFile = "";
    private static String nameFile = "";

    public static void main(String[] args) {
        final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ZipRunner.class);
        final Zipable zipable = annotationConfigApplicationContext.getBean(Zipable.class);

        while (!EXIT_PHRASE.equalsIgnoreCase(action)) {
            System.out.println("Выберите действие:");
            System.out.println("0 - завершение программы");
            System.out.println("1 - архивация файла");
            System.out.println("2 - разархивация файла");
            action = zipable.input();


            if (programList.contains(action) && !Objects.equals(action, "0")) {
                switch (action) {
                    case "1": {
                        System.out.print("Введите расположение файла: ");
                        pathToFile = zipable.input();
                        System.out.print("Введите имя файла: ");
                        nameFile = zipable.input();
                        zipable.zip(pathToFile + "\\" + nameFile, pathToFile + "\\" + nameFile.replaceAll("[.].*", ".zip"));
                        break;
                    }
                    case "2": {
                        System.out.print("Введите расположение файла: ");
                        pathToFile = zipable.input();
                        System.out.print("Введите имя файла: ");
                        nameFile = zipable.input();
                        //zipable.zip(pathToFile + "/" + nameFile, nameFile);
                        zipable.unzip(pathToFile + "\\" + nameFile, pathToFile);
                        break;
                    }
                }
            } else if(!Objects.equals(action, "0")) {
                System.out.println("Выбранного действия нет в прогамме, введите ещё раз!");
            }
        }
    }
}
