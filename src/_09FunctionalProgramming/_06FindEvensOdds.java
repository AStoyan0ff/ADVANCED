package _09FunctionalProgramming;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06FindEvensOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int low = Integer.parseInt(input[0]);
        int high = Integer.parseInt(input[1]);

        String state = scanner.nextLine().trim();
        Predicate<Integer> filter;

        if ("even".equals(state)) {
            filter = x -> x % 2 == 0;
        }
        else {
            filter = x -> x % 2 != 0;
        }

        print(low, high, filter);
    }

    public static void print(int low, int high, Predicate<Integer> filter) {

        for (int pos = low; pos <= high; pos++) {

            if (filter.test(pos)) {
                System.out.print(pos + " ");
            }
        }
    }
}
