package lesson8.animals;

public class AnimalSounds {

    public static void main(String[] args) {

        Cow cowOne = new Cow("Burenka");
        Cat catOne = new Cat("Barsik");
        Dog dogOne = new Dog("Bobik");

        Animal[] animals = new Animal[3];
        animals[0] = cowOne;
        animals[1] = catOne;
        animals[2] = dogOne;

        for (Animal array: animals){
            System.out.print(array.name + " ");
            array.voice();
        }
    }
}
