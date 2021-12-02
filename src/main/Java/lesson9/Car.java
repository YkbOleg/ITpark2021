package lesson9;

public class Car extends Automobile{

    public Car() {
        this.setDistance(500);
    }

    public void move(double distance) {
        if(distance <= this.getDistance() && distance > 0){
            System.out.println("Легковой автомобиль проехал " + distance + " метров");
        }
        else if(distance <= 0){
            System.out.println("Для начала движения легкового автомобиля должна быть введена дистанция больше 0");
        }
        else {
            System.out.println("Легковой автомобиль не смог проехать " + distance + " метров");
        }
    }
}
