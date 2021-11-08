package lesson3;

import java.util.Scanner;

public class Equation {

    public static void main(String[] args) {

        System.out.println("Введите коэффициенты квадратного уравнения вида ax² + bx + c = 0");
        System.out.print("Введите коэффициент a: ");
        int a = input();
        System.out.print("Введите коэффициент b: ");
        int b = input();
        System.out.print("Введите коэффициент c: ");
        int c = input();
        quadraticEquation(a, b, c);

        System.out.print("Факториал числа: ");
        int n = input();
        System.out.println(Factorial(n));
    }

    /**
     * Ввад данных
     * @return Возврат введённого значения
     */
    public static int input() {

        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    /**
     * Вычисление корней квадратного уравнения
     * @param a коэффициент a
     * @param b коэффициент b
     * @param c коэффициент c
     */
    public static void quadraticEquation(int a, int b, int c) {

        double d;       //дискриминант
        double x1, x2;  //корни квадратного уровнения

        if (a != 0) {
            d = (b * b) - (4 * a * c);
            System.out.println("Дискриминант = " + d);
            if (d < 0) {
                System.out.println("Нет действительных решений уравнения");
            }
            else {
                x1 = (-b + Math.sqrt(d)) / (2 * a);
                x2 = (-b - Math.sqrt(d)) / (2 * a);
                if (d == 0) {
                    System.out.println("Уравнение имеет 1 корнь");
                    System.out.println("x = " + x1);
                }
                else {
                    System.out.println("Уравнение имеет 2 корня");
                    System.out.println("x1= " + x1 + " x2= " + x2);
                }
            }
        }
        else {
            System.out.println("Первый коэффициент не может быть 0");
        }
    }

    /**
     * Вычисление факториала числа
     * @param n - основание факториала
     * @return результат нахождения факториала числа
     */
    public static int Factorial(int n){

        if (n == 0 || n == 1) {
            return 1;
        }
        if (n > 2){
            return n * Factorial(n - 1);
        }
        else {
            return n * ( n - 1);
        }
    }
}
