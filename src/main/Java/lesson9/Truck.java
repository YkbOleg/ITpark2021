package lesson9;

public class Truck extends Automobile{

    public Truck() {
        this.setDistance(1200);
    }

    public void move(double distance) {
        if(distance <= this.getDistance() && distance > 0){
            System.out.println("Грузовой автомобиль проехал " + distance + " метров");
        }
        else if(distance <= 0){
            System.out.println("Для начала движения Грузового автомобиля должна быть введена дистанция больше 0");
        }
        else {
            System.out.println("Грузовой автомобиль не смог проехать " + distance + " метров");
        }
    }
}
