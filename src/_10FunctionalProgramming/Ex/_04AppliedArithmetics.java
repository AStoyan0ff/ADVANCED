package _10FunctionalProgramming.Ex;
import java.util.Scanner;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays
                        .stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        UnaryOperator<List<Integer>> addList = list -> list
                                        .stream().map(n -> n + 1)
                                        .collect(Collectors.toList());

        UnaryOperator<List<Integer>> mlpList = list -> list
                                        .stream().map(n -> n * 2)
                                        .collect(Collectors.toList());

        UnaryOperator<List<Integer>> subList = list -> list
                                        .stream().map(n -> n - 1)
                                        .collect(Collectors.toList());

        Consumer<List<Integer>> printList = list -> System.out.println(list
                                        .stream()
                                        .map(String::valueOf)
                                        .collect(Collectors.joining(" "))
        );

        while (true) {
            String cmd = scanner.nextLine();

            if (cmd.equals("end")) {
                break;
            }

            switch (cmd) {

                case "add" -> numList = addList.apply(numList);
                case "multiply" -> numList = mlpList.apply(numList);
                case "subtract" -> numList = subList.apply(numList);
                case "print" -> printList.accept(numList);
            }
        }
    }
}
