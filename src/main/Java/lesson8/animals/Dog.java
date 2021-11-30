package lesson8.animals;

public class Dog extends Animal{

    public Dog(String name) {
        this.name = name;
    }

    public void voice() {
        System.out.println("Гав-гав!");
    }
}
