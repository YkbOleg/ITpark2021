package lesson6;

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

    public static int minValue(int[] array) {
        int minV = array[0];
        for (int i : array){
            if (minV > i){
                minV = i;
            }
        }
        return minV;
    }

    public static int maxValue(int[] array) {
        int maxV = array[1];
        for (int i : array) {
            if (maxV < i) {
                maxV = i;
            }
        }
        return maxV;
    }

    public static double averageValue(int[] array) {
        double averageV = 0;
        for (int i : array){
            averageV += i;
        }
        return averageV/array.length;
    }
}
