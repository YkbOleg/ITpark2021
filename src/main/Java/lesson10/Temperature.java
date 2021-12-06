package lesson10;

public class Temperature implements Converterable {

    private double t;
    private final double K = 273.15;

    public Temperature() {
    }

    /**
     * Преобразовать из градус Цельсия в кельвин
     * @param temperature введёное значение градус Цельсия
     * @return кельвин
     */
    public double convertCK(double temperature) {
        this.t = temperature + this.K;
        return this.t;
    }

    /**
     * Преобразовать из кельвин в градус Цельсия
     * @param temperature введёное значение кельвин
     * @return градус Цельсия
     */
    public double convertKC(double temperature) {
        this.t = temperature - this.K;
        return  this.t;
    }

    /**
     * Преобразовать из градус Фаренгейта в градус Цельсия
     * @param temperature введёное значение градус Фаренгейта
     * @return градус Цельсия
     */
    public double convertFC(double temperature) {
        this.t = (temperature - 32)*5/9;
        return  this.t;
    }

    /**
     * Преобразовать из градус Цельсия в градус Фаренгейта
     * @param temperature введёное значение градус Цельсия
     * @return градус Фаренгейта
     */
    public double convertCF(double temperature) {
        this.t = temperature/5*9 + 32;
        return  this.t;
    }

    /**
     * Преобразовать из градус Фаренгейта в кельвин
     * @param temperature введёное значение градус Фаренгейта
     * @return кельвин
     */
    public double convertFK(double temperature) {
        this.t = convertCK(convertFC(temperature));
        return  this.t;
    }

    /**
     * реобразовать из кельвин в градус Фаренгейта
     * @param temperature введёное значение кельвин
     * @return градус Фаренгейта
     */
    public double convertKF(double temperature) {
        this.t = convertCF(convertKC(temperature));
        return  this.t;
    }
}
