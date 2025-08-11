package _10FunctionalProgramming.Ex;
import java.util.Scanner;
import java.util.function.Function;

public class _03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Integer[] N = new Integer[input.length];

        for (int pos = 0; pos < input.length; pos++) {
            N[pos] = Integer.parseInt(input[pos]);
        }

        Function<Integer[], Integer> buff = arr -> {
            int min = arr[0];

            for (int num : arr) {

                if (num < min) {
                    min = num;
                }
            }
            return min;
        };
        System.out.println(buff.apply(N));
    }
}
