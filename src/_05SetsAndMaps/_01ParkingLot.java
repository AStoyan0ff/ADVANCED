package _05SetsAndMaps;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingSet = new LinkedHashSet<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }

            String [] data = input.split(",\\s*");
            String dir = data[0];
            String car = data[1];

            if (dir.equals("IN")) {
                parkingSet.add(car);
            }
            else if (dir.equals("OUT")) {
                parkingSet.remove(car);
            }
        }

        isEmpty(parkingSet);
    }

    public static void isEmpty(Set<String> set) {

        if (set.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        else {

            for (String cars : set) {
                System.out.println(cars);
            }
            // parkingSet.forEach(System.out::println);
        }
    }
}
