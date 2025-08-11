package _12DefiningClassesEX.RawData;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            String[] data = scanner.nextLine().split(" ");

            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Tire[] tires = new Tire[4];

            int tireIndex = 0;

            for (int idx = 5; idx < data.length; idx += 2) {

                double pressure = Double.parseDouble(data[idx]);
                int age = Integer.parseInt(data[idx + 1]);

                tires[tireIndex++] = new Tire(pressure, age);
            }

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Car car = new Car(model, engine, cargo, tires);

            carsList.add(car);
        }

        String cmd = scanner.nextLine();

        if (cmd.equals("fragile")) {
            for (Car car : carsList) {

                if (car.bFragTire()) {
                    System.out.println(car.model);
                }
            }
        }
        else if (cmd.equals("flamable")) {
            for (Car car : carsList) {

                if (car.bFlamPower()) {
                    System.out.println(car.model);
                }
            }
        }
    }
}
