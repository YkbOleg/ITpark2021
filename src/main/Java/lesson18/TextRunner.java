package lesson18;

import lombok.SneakyThrows;

import java.io.*;

public class TextRunner {

    @SneakyThrows({IOException.class})
    public static void main(String[] args) {
        //Генерация файла
        try (FileOutputStream writerNewFile = new FileOutputStream("C:\\TestJavaFiles\\NewText.txt")){
            for(int i = 1; i < 5; i++){
                String bl = "Hello World!!!_" + i + "\n";
                byte[] bytes = bl.getBytes();
                writerNewFile.write(bytes);
                System.out.println(i);
            }
        }

        if(new File("C:\\TestJavaFiles\\NewText.txt").exists()) {
            try (BufferedReader buffReader = new BufferedReader(new FileReader("C:\\TestJavaFiles\\NewText.txt")
                    /*new InputStreamReader(InputStreamRunner.class.getResourceAsStream("C:\\TestJavaFiles\\NewText.txt"))*/)) {
                String line = "";
                int i = 1;
                //Запись в файлы
                while (line != null) {
                    line = buffReader.readLine();
                    if (line != null) {
                        String nameFile = "C:\\TestJavaFiles\\test_" + i + ".txt"; //генерация имени нового файла
                        try (FileWriter fileWriter = new FileWriter(nameFile)) {
                            fileWriter.write(line);
                            i++;
                        }
                    }
                    System.out.println(line);
                }
            }
        }
        else{
            System.out.println("Нет файла NewText.txt");
        }
    }
}
