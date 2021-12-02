package lesson9;

public abstract class Automobile {

    private double distance;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public abstract void move(double distance);
}
