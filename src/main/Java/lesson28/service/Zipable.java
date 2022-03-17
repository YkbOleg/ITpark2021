package lesson28.service;

import java.util.Scanner;

public interface Zipable {

    void zip(String filename, String archiveName);
    void unzip(String archiveName, String catalogName);

    /***
     * Ввод информации с консоли
     * @return - Информация введённая пользователем
     */
    default String input() {
        Scanner scannerIn = new Scanner(System.in);
        return scannerIn.next();
    }
}
