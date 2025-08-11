package _01StackQueues;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> st = Arrays
                            .stream(scanner.nextLine().split("\\s+"))
                            .collect(Collectors.toCollection(ArrayDeque::new));

        while (st.size() > 1) {

            int firstNum = Integer.parseInt(st.pop());
            String operator = st.pop();
            int secondNum = Integer.parseInt(st.pop());

            int sum = 0;

            if (operator.equals("+")) {
                sum = firstNum + secondNum;
            }
            else if (operator.equals("-")) {
                sum = firstNum - secondNum;
            }

            st.push(String.valueOf(sum));
        }

        System.out.println(st.peek());
    }
}
