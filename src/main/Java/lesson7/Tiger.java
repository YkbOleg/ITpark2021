package lesson7;

public class Tiger {

    String name;
    final double run = 1000;
    final double swim = 20;

    public Tiger(String name){
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
        if (this.swim >= Distance){
            System.out.println(" проплыл " + Distance + " метров");
        }
        else {
            System.out.println(" не смог проплыть " + Distance + " метров");
        }
    }
}
