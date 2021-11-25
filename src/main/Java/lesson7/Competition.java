package lesson7;

import java.util.Scanner;

public class Competition {

    public static void main(String[] args) {
        double distanceRun;             //дистанция в беге
        double distanceSwim;            //дистанция в плаваньи
        Dog dogOne = new Dog("Bobik");
        Tiger tigerOne = new Tiger("Tig");
        DomesticCat catOne = new DomesticCat("Murzik");

        System.out.print("Введите дистанцию в беге: ");
        distanceRun = input();
        while (distanceRun <= 0) {
            System.out.println("Дистанция не может быть отрицательной или нулевой!");
            System.out.print("Введите дистанцию в беге: ");
            distanceRun = input();
        }

        System.out.print("Введите дистанцию в плаваньи: ");
        distanceSwim = input();
        while (distanceSwim <= 0) {
            System.out.println("Дистанция не может быть отрицательной или нулевой!");
            System.out.print("Введите дистанцию в плаваньи: ");
            distanceSwim = input();
        }

        System.out.print(dogOne.name);
        dogOne.run(distanceRun);
        System.out.print(dogOne.name);
        dogOne.swimming(distanceSwim);

        System.out.print(tigerOne.name);
        tigerOne.run(distanceRun);
        System.out.print(tigerOne.name);
        tigerOne.swimming(distanceSwim);

        System.out.print(catOne.name);
        catOne.run(distanceRun);
        System.out.print(catOne.name);
        catOne.swimming(distanceSwim);
    }

    /**
     * Ввод данных
     * @return Возврат введённого значения
     */
    public static double input() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextDouble()){
            System.out.print("Вы ввели строку, введите число: ");
            in.next();
        }
        return in.nextDouble();
    }
}
