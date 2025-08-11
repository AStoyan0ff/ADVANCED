package _10FunctionalProgramming.Ex;
import java.util.Scanner;
import java.util.function.Consumer;

public class _02KnightsHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Consumer<String> sir = names -> System.out.println("Sir " + names);

        for (String name : input) {
            sir.accept(name);
        }
    }
}
