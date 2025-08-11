package _10FunctionalProgramming.Ex;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrix = Arrays
                .stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Integer[] numberArr = Arrays.stream(matrix).boxed().toArray(Integer[]::new);

        Comparator<Integer> custom = (a, s) -> {

            boolean aEven = a % 2 == 0;
            boolean bEven = s % 2 == 0;

            if (aEven && !bEven) return -1;
            if (!aEven && bEven) return 1;

            return Integer.compare(a, s);
        };

        Arrays.sort(numberArr, custom);

        System.out.println(Arrays
                    .stream(numberArr)
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
    }
}
