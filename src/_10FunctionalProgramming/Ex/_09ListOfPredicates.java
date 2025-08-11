package _10FunctionalProgramming.Ex;
import java.util.*;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        List<Integer> sortList = Arrays
                        .stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .toList();

        Predicate<Integer> divisibleYaa = num -> sortList.stream().allMatch(as -> num % as == 0);

        List<Integer> resultList = IntStream.rangeClosed(1, N)
                        .boxed()
                        .filter(divisibleYaa)
                        .toList();

        System.out.println(resultList
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" ")));
    }
}
