package lesson28.service.impl;

import lesson28.service.Zipable;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Service
public class Zipimpl implements Zipable {

    //-------------------Чтение объекта--------------------------------------------------------------
    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    @SneakyThrows
    private byte[] readUsingFiles(String fileName) {
        Path path = Paths.get(fileName);
        //считываем содержимое файла в массив байт
        byte[] bytes = Files.readAllBytes(path);
        return bytes;
    }

    //---------------Архивация файла--------------------
    public void zip(String fileName, String archiveName){
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(archiveName));
            FileInputStream fis = new FileInputStream(fileName))
        {
            ZipEntry entry=new ZipEntry("NewText.txt");
            zout.putNextEntry(entry);
            // считываем содержимое файла в массив byte
            zout.write(readUsingFiles(fileName));
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //-----------------Разархивирование------------
    public void unzip(String archiveName, String catalogName){
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(archiveName)))
        {
            ZipEntry entry;
            String name;
            long size;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName(); // получим название файла

                // распаковка
                FileOutputStream fout = new FileOutputStream(catalogName + "\\" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}
