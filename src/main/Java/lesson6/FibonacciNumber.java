package lesson6;

import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n;          //Введённое значение(Порядковый номер числа Фибоначчи)
        int temp = 2;   //Размер первичного массива

        int[] arrayFibonacci = new int[temp];
        arrayFibonacci[0] = 0;
        arrayFibonacci[1] = 1;

        do {
            System.out.print("Порядковый номер числа Фибоначчи (0 - завершение программы): ");
            n = input();
            while (n < 0) {
                System.out.println("Размер массива не может быть отицательным числом!");
                System.out.print("Введите размер массива(0 - завершение программы): ");
                n = input();
            }

            if (n != 0 && n > temp) {
                arrayFibonacci = sequenceFibonacci(arrayFibonacci, n);
                System.out.println(arrayFibonacci[n - 1]);
                temp = n;
            }else if(n != 0){
                System.out.println(arrayFibonacci[n - 1]);
            }
        }
        while (n != 0);
    }

    /**
     * Обновление массива последовательности Фибоначчи (увеличение длинны массива)
     * @param arrayF Устаревший массив последовательности Фибоначчи
     * @param temp Требуемое количество значений последовательности Фибоначчи
     * @return Обновлённый массив Фибоначчи
     */
    public static int[] sequenceFibonacci(int[] arrayF, int temp) {
        int[] tempArrayFibonacci = new int[temp];      //Новый массив последовательности Фибоначчи
        System.arraycopy(arrayF, 0, tempArrayFibonacci, 0, arrayF.length);
        for (int i = arrayF.length; i < temp; i++) {
            tempArrayFibonacci[i] = tempArrayFibonacci[i - 1] + tempArrayFibonacci[i - 2];
        }
        System.out.println("Массив последовательности Фибоначчи увеличен до " + temp);
        return tempArrayFibonacci;
    }

    /**
     * Ввод данных
     * @return Возврат введённого значения
     */
    public static int input() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()){
            System.out.print("Вы ввели строку или дробное число, введите целое число: ");
            in.next();
        }
        return in.nextInt();
    }
}
