package lesson13;

import java.util.ArrayList;
import java.util.ListIterator;

public class Employee {

    private String name;
    private String firstName;
    private String secondName;
    private final int personnelNumber;
    private int workAge;


    public Employee(String name, String firstName, String secondName, int personnelNumber, int workAge) {
        this.name = name;
        this.firstName = firstName;
        this.secondName = secondName;
        this.personnelNumber = personnelNumber;
        this.workAge = workAge;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getPersonnelNumber() {
        return personnelNumber;
    }

    public int getWorkAge() {
        return workAge;
    }

    /**
     * Вывод сотрудников со стажем работы больше или равного введёному
     * (печать с конца списка)
     * @param list список сотрудников
     * @param workAge стаж работы
     */
    public static void printEmployeePrevious(ArrayList<Employee> list, int workAge){
        ListIterator<Employee> iterate = list.listIterator(list.size());
        while (iterate.hasPrevious()){
            if(list.get(iterate.previousIndex()).getWorkAge() >= workAge){
                System.out.print(list.get(iterate.previousIndex()).getPersonnelNumber() + ": ");
                System.out.print(list.get(iterate.previousIndex()).getFirstName() + " ");
                System.out.print(list.get(iterate.previousIndex()).getName() + " ");
                System.out.print(list.get(iterate.previousIndex()).getSecondName() + " ");
                System.out.print(list.get(iterate.previousIndex()).getWorkAge() + "\n");
            }
            iterate.previous();
        }
    }

    /**
     * Вывод сотрудников со стажем работы больше или равного введёному
     * (печать с начала списка)
     * @param list список сотрудников
     * @param workAge стаж работы
     */
    public static void printEmployeeNext(ArrayList<Employee> list, int workAge){
        ListIterator <Employee> iterate = list.listIterator();
        while(iterate.hasNext()){
            if(list.get(iterate.nextIndex()).getWorkAge() >= workAge){
                System.out.print(list.get(iterate.nextIndex()).getPersonnelNumber());
                System.out.print(", ");
            }
            iterate.next();
        }
    }

    /**
     * удаление элементов коллекции, стоящих на нечетных позициях
     * @param list элементы коллекции
     */
    public static void deleteEmployeeN(ArrayList<Employee> list){
        for(ListIterator<Employee> iterate = list.listIterator(list.size()); iterate.hasPrevious(); iterate.previous()){
            if(iterate.nextIndex()%2 > 0 && iterate.hasNext()){
                iterate.remove();
            }
        }
    }

    /**
     * удаление элементов коллекции, стоящих на четных позициях
     * @param list элементы коллекции
     */
    public static void deleteEmployee(ArrayList<Employee> list){
        ListIterator<Employee> iterate;
        for(iterate = list.listIterator(list.size()); iterate.hasPrevious(); iterate.previous()){
            if(iterate.nextIndex()%2 == 0 && iterate.hasNext()){
                iterate.remove();
            }
        }
        iterate.next();
        iterate.remove();
    }
}
