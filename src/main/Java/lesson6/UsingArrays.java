package lesson6;

import lesson5.FibonacciSequence;

import java.util.Arrays;
import java.util.Scanner;

public class UsingArrays {

    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        int sizeArray = input();

        while (sizeArray <= 0){
            if (sizeArray < 0) {
                System.out.println("Размер массива не может быть отицательным числом!");
            }
            else{
                System.out.println("Вы ввели нулевой размер массива!");
            }
            System.out.print("Введите размер массива: ");
            sizeArray = input();
        }

        int[] randomNumberArray = new int[sizeArray];
        for (int i = 0; i < randomNumberArray.length; i++){
            randomNumberArray[i] = (int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(randomNumberArray));
        System.out.println("Минимальное значение в массиве: " + minValue(randomNumberArray));
        System.out.println("Максимальное значение в массиве: " + maxValue(randomNumberArray));
        System.out.println("Среднее значение массива: " + averageValue(randomNumberArray));

        System.out.print("Введите n-ый член последовательности Фибоначчи: ");
        int n = input();
        System.out.print(n + " член последовательности Фибоначчи: ");
        System.out.println(sequenceFibonacci(n));
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

    /**
     * Нахождение минимального числа в массиве
     * @param array массив целых чисел
     * @return минимальное число в массиве
     */
    public static int minValue(int[] array) {
        int minV = array[0];
        for (int i : array){
            if (minV > i){
                minV = i;
            }
        }
        return minV;
    }

    /**
     * Нахождение максимального числа в массиве
     * @param array массив целых чисел
     * @return максимальное число в массиве
     */
    public static int maxValue(int[] array) {
        int maxV = array[0];
        for (int i : array) {
            if (maxV < i) {
                maxV = i;
            }
        }
        return maxV;
    }

    /**
     * Нахождение средненго значения по массиву
     * @param array массив целых чисел
     * @return среднее значение по массиву
     */
    public static double averageValue(int[] array) {
        double averageV = 0;
        for (int i : array){
            averageV += i;
        }
        return averageV/array.length;
    }

    /**
     * Расчёт числа Фибоначчи
     * @param n порядковый номер числа Фибоначчи
     * @return Число Фибоначчи в позиции n
     */
    public static int sequenceFibonacci(int n) {
        int temp = 20;   //количество текущих значений в массиве arrayFibonacci
        while (n <= 0){
            System.out.print("Введите целое число больше 0: ");
            n = FibonacciSequence.input();
        }

        int[] arrayFibonacci = new int[temp];
        arrayFibonacci[0] = 0;
        arrayFibonacci[1] = 1;
        for (int i = 2; i < arrayFibonacci.length; i++) {
            arrayFibonacci[i] = arrayFibonacci[i - 1] + arrayFibonacci[i - 2];
        }

        if (n > temp){
            int[] tempArrayFibonacci = new int[n];  //Новый массив последовательности Фибоначчи
            System.arraycopy(arrayFibonacci, 0, tempArrayFibonacci, 0,arrayFibonacci.length);
            for (int i = temp; i < n; i++) {
                tempArrayFibonacci[i] = tempArrayFibonacci[i - 1] + tempArrayFibonacci[i - 2];
            }
            return tempArrayFibonacci[n-1];
        }
        return arrayFibonacci[n-1];
    }
}
