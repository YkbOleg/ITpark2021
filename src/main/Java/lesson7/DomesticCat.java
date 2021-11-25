package lesson7;

public class DomesticCat {

    String name;
    final double run = 200;
    String swim = "Так получилось, что кот не умеет плавать)";

    public DomesticCat(String name){
        this.name = name;
    }

    public void run(double Distance) {
        if (this.run >= Distance){
            System.out.println(" пробежал " + Distance + " метров");
        }
        else {
            System.out.println(" не смог пробежать " + Distance + " метров");
        }
    }

    public void swimming(double Distance) {
            System.out.println(" " + Distance + " метров не проплыл." + swim);
    }
}
