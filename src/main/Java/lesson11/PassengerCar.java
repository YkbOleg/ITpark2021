package lesson11;

public class PassengerCar extends RoadTransport {

    public String getTYPE() {
        return "Passenger Car";
    }

    public PassengerCar() {
        super.setNumberCar();                                           //номер
        super.setSpeedCar(10 + (int) (Math.random() * 150));            //скорость
        super.setWeightCar((0.5 + (Math.random() * (4-0.5))));          //вес
        super.setWidthCar(1.5 + (Math.random() * (2-1.5)));             //ширина
        super.setHeightCar(1.35 + (Math.random() * (2-1.35)));          //высота
        super.setLongCar(3 + (Math.random() * (5-3)));                  //длинна
    }
}
