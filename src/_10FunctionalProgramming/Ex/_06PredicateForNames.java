package _10FunctionalProgramming.Ex;
import java.util.*;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        List <String> nameList = Arrays
                            .asList(scanner.nextLine()
                            .split("\\s+"));

        Predicate<String> bShort = name -> name.length() <= N;
        nameList.stream().filter(bShort).forEach(System.out::println);
    }
}
