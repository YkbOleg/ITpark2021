package lesson5;

import java.util.Scanner;

public class FibonacciSequence {

    public static void main(String[] args) {
        System.out.print("Введите n-ый член последовательности Фибоначчи: ");
        int n = input();
        System.out.println(sequenceFibonacci(n));
    }

    /**
     * Ввод данных
     * @return Возврат введённого значения
     */
    public static int input() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()){
            System.out.print("Вы ввели строку, введите целое число: ");
            in.next();
        }
        return in.nextInt();
    }

    /**
     * Вычисление числа Фибоначчи
     * @param n - порядковый номер числа Фибонначи
     * @return Число Фибоначи
     */
    public static int sequenceFibonacci(int n) {
        int fibonacciNumber = 0;
        while (n < 1){
            System.out.print("Введите целое число больше 0: ");
            n = FibonacciSequence.input();
        }

        if (n != 2){
            for(int i = 2, c = 0, j = 1; i < n; i++){
                fibonacciNumber = c + j;
                c = j;
                j = fibonacciNumber;
            }
        }
        else {
            return 1;
        }
        return fibonacciNumber;
    }
}
