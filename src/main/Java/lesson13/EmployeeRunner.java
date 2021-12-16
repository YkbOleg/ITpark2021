package lesson13;

import java.util.*;

public class EmployeeRunner {

    public static void main(String[] args) {
        //списки имён, фамилий, отчеств для автоматической генерации ФИО сотрудников
        ArrayList<String> name = new ArrayList<>(Arrays.asList("Иван", "Максим", "Евгений", "Семён", "Пётр", "Юрий"));
        ArrayList<String> firstName = new ArrayList<>(Arrays.asList("Петров", "Иванов", "Сидоров", "Бобров", "Булкин"));
        ArrayList<String> secondName = new ArrayList<>(Arrays.asList("Иванович", "Петрович", "Николаевич", "Максимович"));
        System.out.println(name.size());

        //Заведение сотрудников из массива people в коллекцию employee
        Employee[] people = new Employee[31];
        ArrayList<Employee> employee = new ArrayList<>();

        for(int i = 0; i < people.length; i++){
            people[i] = new Employee(name.get((int)(Math.random()*(name.size()))),
                                    firstName.get((int)(Math.random()*(firstName.size()))),
                                    secondName.get((int)(Math.random()*(secondName.size()))),
                                    (10000 + i),
                                    ((int)(Math.random()*5000)));
            employee.add(people[i]);
        }

        //работа с коллекцией employee
        Employee.printEmployeeNext(employee, 3000);
        System.out.println("\n--------------------------");
        Employee.printEmployeePrevious(employee, 3000);

        Employee.deleteEmployeeN(employee);
        //Employee.deleteEmployee(employee);

        //проверка элементов коллекции удаления
        for (Employee emp : employee){
            System.out.print(emp.getPersonnelNumber());
            System.out.print(" : ");
        }

    }
}
