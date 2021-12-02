package lesson9;

public abstract class Automobile {

    private double distance;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move(double distance){
        if(distance <= this.distance && distance > 0){
            System.out.println("Автомобиль проехал " + distance + " метров");
        }
        else if(distance <= 0){
            System.out.println("Для начала движения автомобиля должна быть введена дистанция больше 0");
        }
        else {
            System.out.println("Автомобиль не смог проехать " + distance + " метров");
        }
    }
}
