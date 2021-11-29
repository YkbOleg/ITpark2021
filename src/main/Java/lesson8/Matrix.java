package lesson8;

import java.util.Scanner;

public class Matrix {

    private int rows;
    private int column;
    private final int[][] matrix;

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix() {
        this.matrix = new int[rows][column];
        this.rows = 2;
        this.column = 2;
        initializationMatrix(this.matrix);
    }

    protected Matrix(int m, int n) {
        this.matrix = new int[m][n];
    }

    /**
     * Наполнение матрицы случайными значениями
     * @param matrix Матрица
     */
    public static void initializationMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = (int)(Math.random()*100);
            }
        }
    }

    /**
     * Ввод данных
     * @return Возврат введённого значения
     */
    public static int input() {
        //Scanner scanner = new Scanner(System.in);
        int val = checkForString();
        while (val <= 0) {
            if (val < 0) {
                System.out.println("Кол-во строк/столбцов не может быть отицательным числом!");
            } else {
                System.out.println("Вы ввели нулевое кол-во строк/столбцов!");
            }
            System.out.print("Введите целое число больше 0: ");
            val = input();
        }

        return val;
    }

    /**
     * Проверка введённог значения на строку
     * @return Число введёное пользователем
     */
    private static int checkForString() {
        Scanner in = new Scanner(System.in);
        while (!in.hasNextInt()){
            System.out.print("Вы ввели строку или дробное число, введите целое число: ");
            in.next();
        }
        return in.nextInt();
    }

    /**
     * Сравнение размерности двух матриц
     * @param oneMatrix Первая матрица
     * @param twoMatrix Вторая матрица
     * @return Результат сравнения
     */
    public static boolean compareMatrix(int[][] oneMatrix, int[][] twoMatrix){
        return oneMatrix.length == twoMatrix.length && oneMatrix[0].length == twoMatrix[0].length;
    }

    /**
     * Сложение двух матриц
     * @param matrixOne первая матрица
     * @param matrixTwo вторая матрица
     * @return Матрица являющаяся суммой двух матриц
     */
    public static int[][] sumMatrix(int[][] matrixOne, int[][] matrixTwo) {
        Matrix matrixSum = new Matrix(matrixOne.length, matrixOne[0].length);
        //int[][] matrixSum = new int[matrixOne.length][matrixOne[0].length];
        for(int i = 0; i < matrixSum.matrix.length; i++){
            for(int j = 0; j < matrixSum.matrix[0].length; j++){
                matrixSum.matrix[i][j] = matrixTwo[i][j] + matrixOne[i][j];
            }
        }
        return matrixSum.matrix;
    }

    /**
     * Вычитание двух матриц
     * @param matrixOne первая матрица
     * @param matrixTwo вторая матрица
     * @return Матрица являющаяся разностью двух матриц
     */
    public static int[][] differenceMatrix(int[][] matrixOne, int[][] matrixTwo) {
        Matrix matrixDifference = new Matrix(matrixOne.length, matrixOne[0].length);
        for(int i = 0; i < matrixDifference.matrix.length; i++){
            for(int j = 0; j < matrixDifference.matrix[0].length; j++){
                matrixDifference.matrix[i][j] = matrixOne[i][j] - matrixTwo[i][j];
            }
        }
        return matrixDifference.matrix;
    }

    /**
     * Умножение матрицы на число
     * @param matrix матрица
     * @param multiplier множетель
     * @return Матрица - результат умножения матрицы на число
     */
    public static int[][] multiplicationByNumber(int[][] matrix, int multiplier){
        Matrix multiplicationMatrix = new Matrix(matrix.length, matrix[0].length);
        for(int i = 0; i < multiplicationMatrix.matrix.length; i++){
            for(int j = 0; j < multiplicationMatrix.matrix[0].length; j++){
                multiplicationMatrix.matrix[i][j] = matrix[i][j] * multiplier;
            }
        }
        return multiplicationMatrix.matrix;
    }

    public static int[][] multiplicationMatrix(int[][] matrixOne, int[][] matrixTwo){
        Matrix matrixMultiplication = new Matrix(matrixOne.length, matrixTwo[0].length);
        for(int i = 0; i < matrixOne.length; i++) {         // rows from m1
            for(int j = 0; j < matrixTwo[0].length; j++) {     // columns from m2
                for(int k = 0; k < matrixOne[0].length; k++) { // columns from m1
                    matrixMultiplication.matrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }

        return matrixMultiplication.matrix;
    }
}