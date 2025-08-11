package _05SetsAndMaps;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _07LargestTreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                        .stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .sorted(Comparator.reverseOrder())
                        .toList();

        numbers
            .stream()
            .limit(3)
            .forEach(n -> System.out.print(n + " "));
    }
}
