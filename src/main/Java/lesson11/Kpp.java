package lesson11;

import java.util.Objects;

public class Kpp {
    private final double WEIGHT = 8;
    private final double HEIGHT = 4;
    private final double WIDTH = 2.5;

    public double getWEIGHT() {
        return WEIGHT;
    }

    public double getHeight() {
        return HEIGHT;
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public void accessCar(double weight, double height, double width, String numberCar, String TYPE){
        String type;    //тип транспорта
        if(weight <= this.WEIGHT && height <= this.HEIGHT && width <= this.WIDTH){
            System.out.println("Транспорт может проехать");
        }
        else {
            if(Objects.equals(TYPE, "Truck")){
                type = "грузового автомобиля";
            }
            else {
                type = "легкового автомобиля";
            }
            System.out.println("Проезд для " + type + " " + numberCar + " запрещён");
        }
    }

}
