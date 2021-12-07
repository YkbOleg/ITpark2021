package lesson11;

public class CarRunner {

    public static void main(String[] args) {
        RoadTransport[] auto = new RoadTransport[60];
        Kpp kppOne = new Kpp();

        for (int i = 0; i < auto.length; i++){
            if(i < auto.length/2) {
                auto[i] = new PassengerCar();
            }
            else{
                auto[i] = new Truck();
            }
        }

        for (RoadTransport car : auto) {
            if (car.getSpeedCar() > 80 && car.getSpeedCar() <= 100) {
                System.out.println("Автотранспорт " + car.getNumberCar() + " превысил разрешённую скорость 80 км/ч");
                System.out.println("скорость: " + car.getSpeedCar());
            }
            if (car.getSpeedCar() > 100) {
                System.out.println("Автотранспорт " + car.getNumberCar() + " превысил скорость 100 км/ч");
                System.out.println("скорость: " + car.getSpeedCar() + " Вызван СОБР для перехвата!!!");
            }
        }

        for (RoadTransport car : auto) {
            kppOne.accessCar(car.getWeightCar(), car.getHeightCar(), car.getWidthCar(), car.getNumberCar(), car.getTYPE());
        }

    }
}
