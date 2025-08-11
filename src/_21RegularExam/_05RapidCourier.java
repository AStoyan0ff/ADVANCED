package _21RegularExam; // 22 June 2024
import java.util.*;
import java.util.stream.Collectors;

public class _05RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> packageQu = new ArrayDeque<>();
        ArrayDeque<Integer> courierQu = new ArrayDeque<>();

        Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(packageQu::addLast);

        Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(courierQu::addLast);

        int totalDelivery = 0;

        while (!packageQu.isEmpty() && !courierQu.isEmpty()) {
            int currPack = packageQu.pollLast();
            int currCourier = courierQu.pollFirst();

            if (currCourier >= currPack) {
                totalDelivery += currPack;

                int capacity = currCourier - 2 * currPack;

                if (capacity > 0) {
                    courierQu.addLast(capacity);
                }

            }
            else {
                totalDelivery += currCourier;
                currPack -= currCourier;

                packageQu.addLast(currPack);
            }
        }

        System.out.println("Total weight: " + totalDelivery + " kg");

        if (packageQu.isEmpty() && courierQu.isEmpty()) {

            System.out.println
                    ("Congratulations, all packages were delivered successfully by the couriers today.");
        }
        else if (!packageQu.isEmpty()) {

            System.out.print
                    ("Unfortunately, there are no more available couriers to deliver the following packages: ");

            System.out.println(packageQu
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        else {
            System.out.print("Couriers are still on duty: ");

            System.out.println(courierQu.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")) +
                    " but there are no more packages to deliver.");
        }
    }
}
