package lesson7;

public class Tiger {

    String name;
    double run = 1000;
    double swim = 20;

    public Tiger(String name){
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
        if (this.swim >= Distance){
            System.out.println(" проплыл " + Distance + " метров");
        }
        else {
            System.out.println(" не смог проплыть " + Distance + " метров");
        }
    }
}
