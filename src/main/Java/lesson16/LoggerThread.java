package lesson16;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class LoggerThread extends Thread{
    private final LoggerLevel level;
    private int count = 1;

    public LoggerThread(String name, LoggerLevel level) {
        super(name);
        this.level = level;
    }

    public void run(){
        long period = 60_000;
        long t = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - t < period) {
                FileWriter fileWriter = new FileWriter("C:\\Logger.txt", true);
                fileWriter.write(getName() + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                        .format(Calendar.getInstance().getTime()) + " " + level + printText(count) + "\n");
                fileWriter.flush();
                Thread.sleep(new Random().nextInt(5_000));
                count++;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String printText(int count){
        return " Текст №" + count;
    }
}