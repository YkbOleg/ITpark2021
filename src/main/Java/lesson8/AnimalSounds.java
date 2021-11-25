package lesson8;

public class AnimalSounds {

    public static void main(String[] args) {

        Cow cowOne = new Cow("Burenka");
        Cat catOne = new Cat("Barsik");
        Dog dogOne = new Dog("Bobik");

        System.out.print(cowOne.name + " ");
        cowOne.voice();
        System.out.print(catOne.name + " ");
        catOne.voice();
        System.out.print(dogOne.name + " ");
        dogOne.voice();
    }
}
