package _09FunctionalProgramming;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays
                            .stream(scanner.nextLine()
                            .split(", "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

        int cnt = numberList.size();

        Function<List<Integer>, Integer> sumDigit = T -> {

            int sum = 0;

            for (Integer number : T) {
                sum += number;
            }
            return sum;
        };

        //sumDigit.apply(numberList);

        System.out.println("Count = " + cnt);
        System.out.println("Sum = " + sumDigit.apply(numberList));

        scanner.close();
    }
}
