package _10FunctionalProgramming.Ex;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class _05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> numberList = Arrays
                            .stream(scanner.nextLine()
                            .split("\\s+"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

        int N = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numberList);

        List <Integer> filterList = numberList
                            .stream()
                            .filter(n -> n % N != 0)
                            .toList();

        System.out.println(filterList
                            .stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" ")));
    }
}
