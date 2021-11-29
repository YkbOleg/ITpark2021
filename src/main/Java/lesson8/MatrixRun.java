package lesson8;

import java.util.Arrays;

public class MatrixRun {

    public static void main(String[] args) {
        int m, n;       //Введённое количество строк и столбцов пользователем

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

        //заполнение матрицы случайными значениями
        Matrix.initializationMatrix(matrixOne.getMatrix());
        Matrix.initializationMatrix(matrixTwo.getMatrix());

        System.out.println(Arrays.deepToString(matrixOne.getMatrix()));
        System.out.println(Arrays.deepToString(matrixTwo.getMatrix()));

        if (Matrix.compareMatrix(matrixOne.getMatrix(), matrixTwo.getMatrix())){
            //выполнение операций над матрицами
            int[][] sum = Matrix.sumMatrix(matrixOne.getMatrix(), matrixTwo.getMatrix());
            int[][] difference = Matrix.differenceMatrix(matrixOne.getMatrix(), matrixTwo.getMatrix());
            int[][] multiplicationOne = Matrix.multiplicationByNumber(matrixOne.getMatrix(), 3);
            int[][] multiplicationTwo = Matrix.multiplicationByNumber(matrixTwo.getMatrix(), 5);

            System.out.println("Сумма матриц: " + Arrays.deepToString(sum));
            System.out.println("Разность матриц: " + Arrays.deepToString(difference));
            System.out.println("Умножение матрицы на число 3: " + Arrays.deepToString(multiplicationOne));
            System.out.println("Умножение матрицы на число 5: " + Arrays.deepToString(multiplicationTwo));
        }
        else{
            System.out.println("Разная размерность матриц, вычисление не возможно!");
        }

        int[][] multiplicationMatrix = Matrix.multiplicationMatrix(matrixOne.getMatrix(), matrixTwo.getMatrix());
        System.out.println("Умножение матриц: " + Arrays.deepToString(multiplicationMatrix));
    }

}
