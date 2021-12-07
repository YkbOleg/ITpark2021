package lesson11;

import java.util.Random;

public class RoadTransport{

    private static final String CHARACTERS = "ABEKMHOPCTYX";
    private static final String NUMBERS = "0123456789";
    private String TYPE;

    public String getTYPE() {
        return TYPE;
    }


    private String numberCar;               //номер авто
    private int speedCar;                   //скорость авто (км\ч)
    private double weightCar;               //вес авто (т)
    private double widthCar;                //ширина авто (м)
    private double heightCar;               //высота авто (м)
    private double longCar;                 //длинна авто (м)

    public RoadTransport() {
    }

    public static String getCharacters(){
        return CHARACTERS;
    }

    public static String getNumbers(){
        return NUMBERS;
    }

    public void setNumberCar() {
        generateNumber();
    }

    public String getNumberCar() {
        return numberCar;
    }

    public int getSpeedCar() {
        return speedCar;
    }

    public void setSpeedCar(int speedCar) {
        this.speedCar = speedCar;
    }

    public double getWeightCar() {
        return weightCar;
    }

    public void setWeightCar(double weightCar) {
        this.weightCar = weightCar;
    }

    public double getWidthCar() {
        return widthCar;
    }

    public void setWidthCar(double widthCar) {
        this.widthCar = widthCar;
    }

    public double getHeightCar() {
        return heightCar;
    }

    public void setHeightCar(double heightCar) {
        this.heightCar = heightCar;
    }

    public double getLongCar() {
        return longCar;
    }

    public void setLongCar(double longCar) {
        this.longCar = longCar;
    }

    /**
     * Генерация гос. номера транспортного средства
     */
    private void generateNumber() {
        Random random = new Random();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < 1; i++){
            //возврат случайного значения из списка Characters в диапозоне от 0 до Characters.length
            num.append(getCharacters().charAt(random.nextInt(getCharacters().length())));
        }
        num.append(" ");
        for (int i = 0; i < 3; i++){
            num.append(getNumbers().charAt(random.nextInt(getNumbers().length())));
        }
        num.append(" ");
        for (int i = 0; i < 2; i++){
            num.append(getCharacters().charAt(random.nextInt(getCharacters().length())));
        }
        this.numberCar = String.valueOf(num);
    }
}
