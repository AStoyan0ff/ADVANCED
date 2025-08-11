package _12DefiningClassesEX.SpeedRacing;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();

        for (int pos = 0; pos < N; pos++) {
            String[] data = scanner.nextLine().split(" ");

            String model = data[0];
            double fuel = Double.parseDouble(data[1]);
            double fuelKm = Double.parseDouble(data[2]);

            carsMap.put(model, new Car(model, fuel, fuelKm));
        }

        String cmd;
        while (!(cmd = scanner.nextLine()).equals("End")) {
            String[] data = cmd.split(" ");

            String carModel = data[1];
            int distance = Integer.parseInt(data[2]);

            Car car = carsMap.get(carModel);

            if (!car.isDrive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }

        for (Car car : carsMap.values()) {
            car.printCar();
        }
    }
}


