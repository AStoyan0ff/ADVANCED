package _11DefiningClasses.Constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {

    private String brand;
    private String model;
    private int horsepower;

    public Car(String brand) {

        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }

    public Car(String brand, String model, int horsepower) {

        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public void printCar() {
        System.out.printf("The car is: %s %s - %d HP.%n", brand, model, horsepower);
    }
}

public class Constructors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            String[] data = scanner.nextLine().split(" ");

            if (data.length == 1) {
                cars.add(new Car(data[0]));
            }
            else if (data.length == 3) {

                String brand = data[0];
                String model = data[1];
                int horsepower = Integer.parseInt(data[2]);

                cars.add(new Car(brand, model, horsepower));
            }
        }

        for (Car car : cars) {
            car.printCar();
        }
    }
}
