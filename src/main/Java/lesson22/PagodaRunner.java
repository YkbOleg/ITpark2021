package lesson22;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;

import java.net.URISyntaxException;

import java.util.Scanner;

public class PagodaRunner {

    public static void main(String[] args) throws URISyntaxException, IOException {
        String apiKey;

        if(new File("./src/main/resources/apiKey.txt").exists()) {
            try (BufferedReader buffReader = new BufferedReader(new FileReader("./src/main/resources/apiKey.txt"))){
                apiKey = buffReader.readLine();
            }
        }else {
            System.out.println("Отсутствует файл с apiKey для получения данных о погоде с ресурса https://api.openweathermap.org");
            System.out.print("Введите свой apiKey если есть: ");
            apiKey = input();
        }

        System.out.print("Введите название города: ");
        String city = input();

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //поддержка имен XML
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc;
        try {
            builder = builderFactory.newDocumentBuilder();
            doc = builder.parse("https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apiKey+"&units=metric&mode=xml");

            // Создаем объект XPathFactory
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Получаем экзмепляр XPath для создания XPathExpression выражений
            XPath xpath = xpathFactory.newXPath();

            String temperature = temperatureCity(doc, xpath);
            System.out.println("Температура в городе "+ city +": "
                    + temperature);
            String time = lastUpdate(doc, xpath);
            System.out.println("Последнее обновление температуры: "
                    + time);

        }
        catch (FileNotFoundException e){
            System.out.println("Введённого вами города нет");
        }
        catch (ParserConfigurationException | SAXException | IOException e){
            System.out.println("Не верный apiKey");
        }

    }

    public static String input() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    private static String temperatureCity (Document doc, XPath xpath) {
        String temperature = "";
        try {
            temperature = (String) xpath.compile(
                            "/current/temperature/attribute::value").evaluate(doc, XPathConstants.STRING);
        }
        catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return temperature;
    }

    private static String lastUpdate (Document doc, XPath xpath) {
        String time = "";
        Double timeZone = 0.00;
        try {
            time = (String) xpath.compile(
                    "/current/lastupdate/attribute::value").evaluate(doc, XPathConstants.STRING);
            timeZone = (Double) xpath.compile(
                    "/current/city/timezone/text() div 3600").evaluate(doc, XPathConstants.NUMBER);
        }
        catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return time.replace("T", " ") + " : +" + timeZone;
    }

}
