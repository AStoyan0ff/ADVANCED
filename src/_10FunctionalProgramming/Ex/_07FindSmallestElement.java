package _10FunctionalProgramming.Ex;
import java.util.*;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07FindSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> numList = Arrays
                            .stream(scanner.nextLine()
                            .split("\\s+"))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

        Function<List<Integer>, Integer> findList = list -> {

            int minDigit = Collections.min(list);
            return list.lastIndexOf(minDigit);
        };

        System.out.println(findList.apply(numList));
    }
}
