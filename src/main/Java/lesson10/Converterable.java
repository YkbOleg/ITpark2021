package lesson10;

public interface Converterable{

    default double convertCK(double temperature) {
        return temperature;
    }

    default double convertKC(double temperature) {
        return temperature;
    }

    default double convertFC(double temperature) {
        return temperature;
    }

    default double convertCF(double temperature) {
        return temperature;
    }

    default double convertFK(double temperature) {
        return temperature;
    }

    default double convertKF(double temperature) {
        return temperature;
    }

}
