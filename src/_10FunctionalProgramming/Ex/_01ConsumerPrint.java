package _10FunctionalProgramming.Ex;
import java.util.Scanner;
import java.util.function.Consumer;

public class _01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Consumer<String> print = System.out::println;

        for (String curr : input) {
            print.accept(curr);
        }
    }
}
