package _12DefiningClassesEX.SpeedRacing;

public class Car {

    private String model;
    private double fuel;
    private double fuelKm;
    private int distance;

    public Car(String model, double fuel, double fuelKm) {

        this.model = model;
        this.fuel = fuel;
        this.fuelKm = fuelKm;
        this.distance = 0;
    }

    public boolean isDrive(int km) {
        double needFuel = km * fuelKm;

        if (needFuel <= fuel) {

            fuel -= needFuel;
            distance += km;
            return true;
        }
        else {
            return false;
        }
    }

    public void printCar() {
        System.out.printf("%s %.2f %d%n", model, fuel, distance);

    }
}