package lesson8;

public class Dog extends Animal{

    public Dog(String name) {
        this.name = name;
    }

    public void voice() {
        System.out.println("Гав-гав!");
    }
}
