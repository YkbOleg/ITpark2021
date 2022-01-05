package lesson15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamAPI {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. " +
                "Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. " +
                "Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. " +
                "Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Integer vel odio nec mi tempor dignissim.");

        list.stream()
                //удаление небуквенных символов, привидение к нижнему регистру
                .map(word -> word.replaceAll("[^A-Za-zА-Яа-яЁё]+", " ").toLowerCase())
                //получение слов из текста (пробел - разделитель)
                .flatMap(line -> Stream.of(line.split("\\s+")))
                //количество вхождений
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                // сортировка в порядке убывания вхождений
                .entrySet().stream().sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()) * -1)
                // результат
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
}
