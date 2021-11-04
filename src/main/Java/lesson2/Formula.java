package lesson2;

import java.util.Arrays;

public class Formula {

    public static void main(String[] args) {
        System.out.println("Вычисление площади плоских фигур");
        System.out.println("Площадь треугольника: " + triangle(9, 5));
        System.out.println("Площадь квадрата: " + square(8));
        System.out.println("Площадь круга: " + circle(10));
    }

    public static double triangle(double base, double height) {
        double area;
        area = (base * height) / 2;
        return area;
    }

    public static double square(double side) {
        double area;
        area = side * side;
        return area;
    }

    public static double circle(double radius) {
        double area;
        final double pi = 3.14;
        area = pi * square(radius);
        return area;
    }
}