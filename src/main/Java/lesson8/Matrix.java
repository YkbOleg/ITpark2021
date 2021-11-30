package lesson8;

import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Matrix {

    private int rows;
    private int column;
    private final int[][] matrix;

    //геттеры
    public int[][] getMatrix() {
        return matrix;
    }
    public int getRows() { return rows; }
    public int getColumn() { return column; }

    //Конструктор по умолчанию
    public Matrix() {
        this.rows = 2;
        this.column = 2;
        this.matrix = new int[rows][column];
    }

    //Конструктор (int, int)
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
    private static boolean compareMatrix(int[][] oneMatrix, int[][] twoMatrix){
        return oneMatrix.length == twoMatrix.length && oneMatrix[0].length == twoMatrix[0].length;
    }

    /**
     * Сложение двух матриц
     * @param matrixOne первая матрица
     * @param matrixTwo вторая матрица
     * @return Матрица являющаяся суммой двух матриц
     */
    private static int[][] sumMatrix(int[][] matrixOne, int[][] matrixTwo) {
        Matrix matrixSum = new Matrix(matrixOne.length, matrixOne[0].length);
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
    private static int[][] differenceMatrix(int[][] matrixOne, int[][] matrixTwo) {
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
    private static int[][] multiplicationByNumber(int[][] matrix, int multiplier){
        Matrix multiplicationMatrix = new Matrix(matrix.length, matrix[0].length);
        for(int i = 0; i < multiplicationMatrix.matrix.length; i++){
            for(int j = 0; j < multiplicationMatrix.matrix[0].length; j++){
                multiplicationMatrix.matrix[i][j] = matrix[i][j] * multiplier;
            }
        }
        return multiplicationMatrix.matrix;
    }

    /**
     * Умножение матриц
     * @param matrixOne первая матрица
     * @param matrixTwo вторая матрица
     * @return матрица - результат умножения двух матриц
     */
    private static int[][] multiplicationMatrix(int[][] matrixOne, int[][] matrixTwo){
        Matrix matrixMultiplication = new Matrix(matrixOne.length, matrixTwo[0].length);
        for(int i = 0; i < matrixOne.length; i++) {
            for(int j = 0; j < matrixTwo[0].length; j++) {
                for(int k = 0; k < matrixOne[0].length; k++) {
                    matrixMultiplication.matrix[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }
        return matrixMultiplication.matrix;
    }

    /**
     * Метод деиствия над матрицами
     * @param matrixOne первая матрица
     * @param matrixTwo вторая матрица
     */
    public static void operationsMatrix(int[][] matrixOne, int[][] matrixTwo){
        String run;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Выберите операцию на матрицами:");
            System.out.println("0 - Завершить работу программы");
            System.out.println("1 - сложение матриц");
            System.out.println("2 - вычитание матриц");
            System.out.println("3 - умножение матриц");
            System.out.println("4 - умножение матрицы на число");
            run = scanner.next();
        }
        while (!Objects.equals(run, "0")
                && !Objects.equals(run, "1")
                && !Objects.equals(run, "2")
                && !Objects.equals(run, "3")
                && !Objects.equals(run, "4"));

        switch (run){
            case "0": break;
            case "1":
                if(compareMatrix(matrixOne, matrixTwo)){
                    System.out.println("Сумма матриц: " + Arrays.deepToString(sumMatrix(matrixOne, matrixTwo)));
                }
                else System.out.println("Разная размерность матриц, вычисление не возможно!");
                break;
            case "2":
                if(compareMatrix(matrixOne, matrixTwo)) {
                    System.out.println("Разность матриц: " + Arrays.deepToString(differenceMatrix(matrixOne, matrixTwo)));
                }
                else System.out.println("Разная размерность матриц, вычисление не возможно!");
                break;
            case "3":
                System.out.println("Умножение матриц: " + Arrays.deepToString(multiplicationMatrix(matrixOne, matrixTwo)));
                break;
            case "4":
                System.out.println("Введите целое число для умножения");
                int n = checkForString();
                System.out.println("Умножение матриц на число: " + Arrays.deepToString(multiplicationByNumber(matrixOne, n)));
                System.out.println("Умножение матриц на число: " + Arrays.deepToString(multiplicationByNumber(matrixTwo, n)));
                break;
        }
    }
}
