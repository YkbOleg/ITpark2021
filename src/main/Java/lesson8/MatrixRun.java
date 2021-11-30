package lesson8;

import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class MatrixRun {

    public static void main(String[] args) {
        int m, n;       //Введённое количество строк и столбцов пользователем
        String run;
        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println("Выберите действие:");
            System.out.println("0 - Завершить работу программы");
            System.out.println("1 - Ввод одной матрицы");
            System.out.println("2 - Ввод двух матриц");
            run = scanner.next();
        }
        while (!Objects.equals(run, "0") && !Objects.equals(run, "1") && !Objects.equals(run, "2"));

        if(Objects.equals(run, "1")){
            System.out.println("Введите размер m x n матрицы.");
            System.out.print("Кол-во строк m: ");
            m = Matrix.input();
            System.out.print("Кол-во столбцов n: ");
            n = Matrix.input();
            Matrix matrixOne = new Matrix(m, n);
            Matrix matrixTwo = new Matrix();
            Matrix.initializationMatrix(matrixOne.getMatrix());
            Matrix.initializationMatrix(matrixTwo.getMatrix());
            System.out.println(Arrays.deepToString(matrixOne.getMatrix()));
            System.out.println(Arrays.deepToString(matrixTwo.getMatrix()));
            Matrix.operationsMatrix(matrixOne.getMatrix(), matrixTwo.getMatrix());
        }

        if(Objects.equals(run, "2")){
            System.out.println("Введите размер m x n первой матрицы.");
            System.out.print("Кол-во строк m: ");
            m = Matrix.input();
            System.out.print("Кол-во столбцов n: ");
            n = Matrix.input();
            Matrix matrixOne = new Matrix(m, n);

            System.out.println("Введите размер m x n второй матрицы.");
            System.out.print("Кол-во строк m: ");
            m = Matrix.input();
            System.out.print("Кол-во столбцов n: ");
            n = Matrix.input();
            Matrix matrixTwo = new Matrix(m, n);

            Matrix.initializationMatrix(matrixOne.getMatrix());
            Matrix.initializationMatrix(matrixTwo.getMatrix());
            System.out.println(Arrays.deepToString(matrixOne.getMatrix()));
            System.out.println(Arrays.deepToString(matrixTwo.getMatrix()));
            Matrix.operationsMatrix(matrixOne.getMatrix(), matrixTwo.getMatrix());
        }
    }
}
