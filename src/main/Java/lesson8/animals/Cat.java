package lesson8.animals;

public class Cat extends Animal{

    public Cat(String name) {
        this.name = name;
    }

    public void voice() {
        System.out.println("Мяу-мяу!");
    }
}
