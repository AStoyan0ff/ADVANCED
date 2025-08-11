package _12DefiningClassesEX.CarSalesman;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engineMap = new HashMap<>();

        for (int pos = 0; pos < N; pos++) {
            String[] data = scanner.nextLine().split("\\s+");

            String model = data[0];
            int pow = Integer.parseInt(data[1]);

            Engine engine;

            if (data.length == 2) {
                engine = new Engine(model, pow);
            }
            else if (data.length == 3) {
                engine = new Engine(model, pow, data[2]);
            }
            else {
                engine = new Engine(model, pow, data[2], data[3]);
            }
            engineMap.put(model, engine);
        }

        int M = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();

        for (int pos = 0; pos < M; pos++) {
            String [] data = scanner.nextLine().split("\\s+");

            String carModel = data[0];
            String engineModel = data[1];

            Engine engine = engineMap.get(engineModel);

            Car car;

            if (data.length == 2) {
                car = new Car(carModel, engine);
            }
            else if (data.length == 3) {
                car = new Car(carModel, engine, data[2]);
            }
            else {
                car = new Car(carModel, engine, data[2], data[3]);
            }

            carList.add(car);
        }

        for (Car car : carList ) {
            System.out.println(car);
        }
    }
}
