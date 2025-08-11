package _09FunctionalProgramming;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays
                            .stream(scanner.nextLine()
                            .split(", "))
                            .map(Integer::parseInt)
                            .filter(n -> n % 2 == 0)
                            .collect(Collectors.toList());

        print(numberList);
        Collections.sort(numberList);
        print(numberList);
    }
    public static void print(List<Integer> numberList) {
        System.out.println(numberList.toString()
                            .replace("[", "")
                            .replace("]", ""));
    }
}
