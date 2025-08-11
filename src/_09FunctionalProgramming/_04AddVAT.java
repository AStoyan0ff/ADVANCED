package _09FunctionalProgramming;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class _04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        // UnaryOperator
        Function<Double, Double> addVAT = price -> price * 1.20;

        List<Double> priceList = Arrays
                            .stream(input.split(", "))
                            .map(Double::parseDouble)
                            .map(addVAT)
                            .toList();

        System.out.println("Prices with VAT:");

        priceList.forEach(price ->
                System.out.printf("%.2f%n", price));
    }
}
