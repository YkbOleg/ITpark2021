package lesson20;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XPathRunner {

    public static void main(String[] args) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //поддержка имен XML
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc;
        try {
            builder = builderFactory.newDocumentBuilder();
            doc = builder.parse("C:/TestJavaFiles/XmlEmployee.xml");

            // Создаем объект XPathFactory
            XPathFactory xpathFactory = XPathFactory.newInstance();

            // Получаем экзмепляр XPath для создания XPathExpression выражений
            XPath xpath = xpathFactory.newXPath();

            List<String> names = employeeSalary(doc, xpath);
            System.out.println("Зарплата выше средней у сотрудников: "
                    + names);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String> employeeSalary(Document doc, XPath xpath) {
        List<String> list = new ArrayList<>();
        try {
            //расчёт средней з/п
            double avgSalary = (double) xpath.compile(
                    "sum(/listEmployee/employees/position/salary/text()) div count(//salary) ")
                    .evaluate(doc, XPathConstants.NUMBER);
            System.out.println("Средняя зарплата сотрудников: " + avgSalary);

            XPathExpression xPathExpressionSalary = xpath.compile(
                    "/listEmployee/employees[position/salary > " + avgSalary + "]/fio/text()");
            NodeList nodeListSalary = (NodeList) xPathExpressionSalary.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeListSalary.getLength(); i++){
                list.add(nodeListSalary.item(i).getNodeValue());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }

}
