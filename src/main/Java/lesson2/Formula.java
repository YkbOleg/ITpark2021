package lesson2;

import java.util.Arrays;
import java.util.Scanner;

public class Formula {

    public static void main(String[] args) {

        System.out.println("Вычисление площади плоских фигур");

        System.out.print("Введите основание треугольника: ");
        double base = input();
        System.out.print("Введите высоту треугольника: ");
        double height = input();
        System.out.println("Площадь треугольника: " + triangle(base, height));

        System.out.print("Введите длинну стороны квадрата: ");
        double side = input();
        System.out.println("Площадь квадрата: " + square(side));

        System.out.print("Введите радиус круга: ");
        double radius = input();
        System.out.println("Площадь круга: " + circle(radius));
    }

    public static double input() {

        Scanner in = new Scanner(System.in);
        return in.nextDouble();
    }

    /**
     * Вычисление площади треугольника
     * @param base Основание треугольника
     * @param height Высота треугольника
     * @return area - Площадь треугольника
     */
    public static double triangle(double base, double height) {

        double area;
        area = (base * height) / 2;
        return area;
    }

    /**
     * Вычисление площади квадрата
     * @param side Длинна стороны квадрата
     * @return area - Площадь квадрата
     */
    public static double square(double side) {

        double area;
        area = side * side;
        return area;
    }

    /**
     * Вычисление площади круга
     * @param radius Радиус круга
     * @return area - Площадь круга
     */
    public static double circle(double radius) {

        double area;
        final double pi = 3.14;
        area = pi * square(radius);
        return area;
    }
}