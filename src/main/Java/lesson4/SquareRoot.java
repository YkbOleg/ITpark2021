package lesson4;

import java.util.Scanner;

public class SquareRoot {

    public static void main(String[] args) {

        int squareNumber;
        System.out.print("Найти корень числа: ");
        squareNumber = input();
        squareRoot(squareNumber);

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
     * Вычисление квадратного корня числа
     * @param a найти квадратный корень из числа a
     */
    public static void squareRoot(int a) {

        int twoSquared;
        if (a < 0){
            System.out.println("Нет корня");
        }
        else {
            for (int i = 0; i*i <= a; i++) {
                twoSquared = i*i;
                if (twoSquared == a){
                    System.out.println("корень квадратный из числа: " + i + " и " + -i);
                    break;
                }
                else if ((i+1)*(i+1) > a){
                    System.out.println("Нет решения с целыми числами");
                }
            }
        }
    }

}
