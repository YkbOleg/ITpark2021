package lesson16;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Logger {

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Logger.txt");
        final LoggerLevel[] levels = LoggerLevel.values();

        //Удаление файла Logger.txt(если есть) перед запуском потоков
        if(file.delete()){
            System.out.println("Logger.txt файл был удален с корневой папки проекта");
        }else System.out.println("Файл file.txt не был найден в корневой папке проекта");

        List<Thread> threads = new ArrayList<>();

        //Запуск потоков
        for (int i = 1; i < 4; i++){
            String name = "Поток №" + i + " ";
            LoggerThread loggerThread = new LoggerThread(name, levels[new Random().nextInt(levels.length)]);
            threads.add(loggerThread);
            loggerThread.start();
        }

        //Ожидание завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        //Вывод содержания файла Logger.txt в консоль
        try (InputStream input = new BufferedInputStream(new FileInputStream("C:\\Logger.txt"))) {
            byte[] buffer = new byte[8192];
            for (int length; (length = input.read(buffer)) != -1; ) {
                System.out.write(buffer, 0, length);
            }
        }
    }
}
