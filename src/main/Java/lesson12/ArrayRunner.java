package lesson12;

import lesson12.exception.MyArrayDataException;
import lesson12.exception.MyArraySizeException;

public class ArrayRunner {

    public static void main(String[] args) throws MyArraySizeException {
        int error = 0;  //оценка работы программы 0:без ошибок, -1: с ошибками
        int a = (int)(4 + Math.random() * 3);
        System.out.println(a);
        String[][] myArray = new String[a][4];

        //инициализация массива
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                if(i == 2 && j == 2){
                    if(Math.random() < 0.5){
                        myArray[i][j] = "One";
                    }
                    else{
                        myArray[i][j] = String.valueOf((int)(Math.random() * 100));
                    }
                }
                else{
                    myArray[i][j] = String.valueOf((int)(Math.random() * 100));
                }
            }
        }

        //вывод массива, вывод суммы значений массива
        try{
        WorkArray oneArray = new WorkArray(myArray);
        for (int i = 0; i < oneArray.getYourArray().length; i++) {
            for (int j = 0; j < oneArray.getYourArray()[0].length; j++) {
                System.out.print(oneArray.getYourArray()[i][j] + " : ");
            }
            System.out.println();
        }
            System.out.println("Сумма: " + oneArray.sumArray(oneArray.getYourArray()));
        }
        catch (MyArrayDataException | MyArraySizeException e){
            System.out.println(e.getMessage());
            error = -1;
        }
        finally {
            if(error == -1){
                System.out.println("Работа программы завершина с ошибками");
            }
            else {
                System.out.println("Работа программы завершина без ошибок");
            }
        }

    }
    
}
