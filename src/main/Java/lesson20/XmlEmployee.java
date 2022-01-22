package lesson20;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.SneakyThrows;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class XmlEmployee {

    public static void main(String[] args) throws Exception {
        Employee employeeOne = new Employee();
        employeeOne.setFio("Иванов Иван Иванович");
        employeeOne.setLogin("ИИИ");
        employeeOne.setPersonnelNumber(1);
        employeeOne.setDepartment(new Department("Первый отдел", "Москва"));
        employeeOne.setPosition(new Position("Специалист", 60000));

        Employee employeeTwo = new Employee();
        employeeTwo.setFio("Петров Пётр Петрович");
        employeeTwo.setLogin("ППП");
        employeeTwo.setPersonnelNumber(2);
        employeeTwo.setDepartment(new Department("Второй отдел", "Пермь"));
        employeeTwo.setPosition(new Position("Ведущий специалист", 80000));

        Employee employeeThree = new Employee();
        employeeThree.setFio("Сидоров Сергей Сергеевич");
        employeeThree.setLogin("ССС");
        employeeThree.setPersonnelNumber(3);
        employeeThree.setDepartment(new Department("Третий отдел", "Екатеринбург"));
        employeeThree.setPosition(new Position("Главный специалист", 100000));

        Employee employeeFour = new Employee();
        employeeFour.setFio("Михайлов Михаил Михайлович");
        employeeFour.setLogin("МММ");
        employeeFour.setPersonnelNumber(4);
        employeeFour.setDepartment(new Department("Третий отдел", "Екатеринбург"));
        employeeFour.setPosition(new Position("Главный специалист", 110000));

        ListEmployee listEmployee = new ListEmployee();
        listEmployee.setEmployees(Arrays.asList(employeeOne, employeeTwo, employeeThree, employeeFour));

        writeToXML(listEmployee);
        //writeToXML(employeeOne);
        System.out.println(getEmployees("""
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <listEmployee>
                    <employees>
                        <department>
                            <city>Москва</city>
                            <subdivision>Первый отдел</subdivision>
                        </department>
                        <fio>Иванов Иван Иванович</fio>
                        <login>ИИИ</login>
                        <personnelNumber>1</personnelNumber>
                        <position>
                            <position>Специалист</position>
                            <salary>60000</salary>
                        </position>
                    </employees>
                    <employees>
                        <department>
                            <city>Пермь</city>
                            <subdivision>Второй отдел</subdivision>
                        </department>
                        <fio>Петров Пётр Петрович</fio>
                        <login>ППП</login>
                        <personnelNumber>2</personnelNumber>
                        <position>
                            <position>Ведущий специалист</position>
                            <salary>80000</salary>
                        </position>
                    </employees>
                    <employees>
                        <department>
                            <city>Екатеринбург</city>
                            <subdivision>Третий отдел</subdivision>
                        </department>
                        <fio>Сидоров Сергей Сергеевич</fio>
                        <login>ССС</login>
                        <personnelNumber>3</personnelNumber>
                        <position>
                            <position>Главный специалист</position>
                            <salary>100000</salary>
                        </position>
                    </employees>
                    <employees>
                            <department>
                                <city>Екатеринбург</city>
                                <subdivision>Третий отдел</subdivision>
                            </department>
                            <fio>Михайлов Михаил Михайлович</fio>
                            <login>МММ</login>
                            <personnelNumber>4</personnelNumber>
                            <position>
                                <position>Главный специалист</position>
                                <salary>110000</salary>
                            </position>
                        </employees>
                </listEmployee>
                """));
    }


    @SneakyThrows
    //процедуру маршалинга
    private static void writeToXML(ListEmployee listEmployee) {
        JAXBContext context = JAXBContext.newInstance(ListEmployee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(listEmployee, stringWriter);

        //Запись в файлы
        String line;
        line = stringWriter.toString();
        try (FileWriter fileWriter = new FileWriter("C:\\TestJavaFiles\\XmlEmployee.xml")) {
            fileWriter.write(line);
        }
        System.out.println("XML: " + stringWriter);
    }

    //процедуру демаршалинга
    public static List<Employee> getEmployees(String xmlContent) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ListEmployee.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ListEmployee result = (ListEmployee) unmarshaller.unmarshal(new StringReader(xmlContent));
        return result == null ? null : result.getEmployees();
    }

}
