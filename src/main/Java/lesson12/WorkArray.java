package lesson12;

import lesson12.exception.MyArrayDataException;
import lesson12.exception.MyArraySizeException;

public class WorkArray {

    private String[][] yourArray;

    public WorkArray(){
        this.yourArray = new String[4][4];
    }

    public WorkArray(String[][] yourArray) throws MyArraySizeException {
            if (yourArray.length != 4 || yourArray[0].length != 4) {
                throw new MyArraySizeException("Неправильный размер массива "
                                                + yourArray.length + ":" + yourArray[0].length);
        }
        this.yourArray = yourArray;
    }

    public String[][] getYourArray() {
        return yourArray;
    }

    public void setYourArray(String[][] yourArray) {
        this.yourArray = yourArray;
    }

    /**
     * Определение суммы всех элементов массива
     * @param array массив значение
     * @return Сумма элементов массива
     * @throws MyArrayDataException выброс исключения
     * если строковое значение массива не удалось конвертировать в число
     */
    public int sumArray(String[][] array) throws MyArrayDataException {
        int sum = 0;
        int i = 0, j = 0;
        try {
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[0].length; j++) {
                    sum += (Integer.parseInt(array[i][j]));
                }
            }
        }
        catch (Exception e){
        throw new MyArrayDataException("В ячейке массива " + i + ":" + j + " лежит что-то не то (" + e + " )");
        }
        return sum;
    }
}
