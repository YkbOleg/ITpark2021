package lesson11;

public class Truck extends RoadTransport {

    public String getTYPE() {
        return "Truck";
    }

    public Truck() {
        super.setNumberCar();                                           //номер
        super.setSpeedCar(10 + (int) (Math.random() * (100-10)));       //скорость
        super.setWeightCar(1.5 + (Math.random() * (10-1.5)));           //вес
        super.setWidthCar(1.5 + (Math.random() * (2.6-1.5)));           //ширина
        super.setHeightCar(1.5 + (Math.random() * (4.5-1.5)));          //высота
        super.setLongCar(3.8 + (Math.random() * (10-3.8)));             //длинна
    }
}
