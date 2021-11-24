package lesson7;

public class DomesticCat {

    String name;
    double run = 200;
    double swim = -1;

    public DomesticCat(String name){
        this.name = name;
    }

    public void race(double Distance) {
        if (this.run >= Distance){
            System.out.println(" пробежал " + Distance + " метров");
        }
        else {
            System.out.println(" не смог пробежать " + Distance + " метров");
        }
    }

    public void swimming(double Distance) {
        System.out.println(" не умеет плавать");
    }
}
