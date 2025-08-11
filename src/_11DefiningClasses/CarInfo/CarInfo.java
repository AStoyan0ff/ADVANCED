package _11DefiningClasses.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarInfo { // _16Generics.Ex._19ExamPreparation.cafe.CustomList._19ExamPreparation.cafe.CustomListSorted.Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            String[] data = scanner.nextLine().split(" ");

            String brand = data[0];
            String model = data[1];
            int horsepower = Integer.parseInt(data[2]);

            Car car = new Car(brand, model, horsepower);
            carsList.add(car);
        }

        for (Car car : carsList) {
            System.out.println(car.carInfo());
        }
    }
}

class Car {

    private String brand;
    private String model;
    private int hp;

    public Car(String brand, String model, int horsepower) {

        this.brand = brand;
        this.model = model;
        this.hp = horsepower;
    }
    // принт метод
    public String carInfo() {
        return "The car is: " + brand + " " + model + " - " + hp + " HP.";
    }
}