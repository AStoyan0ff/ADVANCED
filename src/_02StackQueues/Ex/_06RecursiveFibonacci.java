package _02StackQueues.Ex;
import java.util.Scanner;

public class _06RecursiveFibonacci {

    public static long [] fibonacciResult;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        fibonacciResult = new long [N + 1];

        System.out.println(fibonacci(N));

    }
    public static long fibonacci (int num) {

        if (num <= 1) {
            return 1;
        }
        if (fibonacciResult[num] != 0) {
            return fibonacciResult[num];
        }
        return fibonacciResult[num] = fibonacci(num - 1) + fibonacci (num - 2);
    }
}
