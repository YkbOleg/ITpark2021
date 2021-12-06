package lesson10;

import java.util.Objects;
import java.util.Scanner;

public class ConverterRun {

    public static void main(String[] args) {
        String run;         //Режим работы конвертора
        Scanner scanner = new Scanner(System.in);
        Converterable converterable = new Temperature();

        do {
            System.out.println("Выберите конвертер температур:");
            System.out.println("0 - Завершить работу программы");
            System.out.println("1 - Преобразовать из градус Цельсия в градус Фаренгейта");
            System.out.println("2 - Преобразовать из градус Фаренгейта в градус Цельсия");
            System.out.println("3 - Преобразовать из градус Цельсия в кельвин");
            System.out.println("4 - Преобразовать из кельвин в градус Цельсия");
            System.out.println("5 - Преобразовать из градус Фаренгейта в кельвин");
            System.out.println("6 - Преобразовать из кельвин в градус Фаренгейта");
            run = scanner.next();
        }
        while (!Objects.equals(run, "0")
                && !Objects.equals(run, "1")
                && !Objects.equals(run, "2")
                && !Objects.equals(run, "3")
                && !Objects.equals(run, "4")
                && !Objects.equals(run, "5")
                && !Objects.equals(run, "6"));

        if (!Objects.equals(run, "0")) {
            System.out.print("Введите температуру для конвертирования: ");
            double t = input();

            switch (run) {
                case "1" -> {
                    System.out.print("C -> F: ");
                    System.out.printf("%.2f%n", converterable.convertCF(t));
                }
                case "2" -> {
                    System.out.print("F -> C: ");
                    System.out.printf("%.2f%n", converterable.convertFC(t));
                }
                case "3" -> {
                    System.out.print("C -> K: ");
                    System.out.printf("%.2f%n", converterable.convertCK(t));
                }
                case "4" -> {
                    System.out.print("K -> C: ");
                    System.out.printf("%.2f%n", converterable.convertKC(t));
                }
                case "5" -> {
                    System.out.print("F -> K: ");
                    System.out.printf("%.2f%n", converterable.convertFK(t));
                }
                case "6" -> {
                    System.out.print("K -> F: ");
                    System.out.printf("%.2f%n", converterable.convertKF(t));
                }
            }
        }
    }

    /**
     * Проверка введённог значения на строку
     * @return Число введёное пользователем
     */
    private static double input() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextDouble()){
            System.out.print("Вы ввели строку, введите число: ");
            in.next();
        }
        return in.nextDouble();
    }
}
