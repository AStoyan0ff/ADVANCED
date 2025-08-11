package _01StackQueues;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _03Decimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> st = new ArrayDeque<>();

        while (input != 0) {
            st.push(input % 2);
            input /= 2;
        }

        if (st.isEmpty()) {
            System.out.println(0);
        }
        else {
            while (!st.isEmpty()) {
                System.out.print(st.pop());
            }
        }
    }
}
