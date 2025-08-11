package _01StackQueues;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _02SimpleCalculators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] data = input.split(" ");
        ArrayDeque<Integer> st = new ArrayDeque<>();

        st.push(Integer.parseInt(data[0]));

        for (int pos = 1; pos < data.length; pos += 2) {

            String operator = data[pos];
            int number = Integer.parseInt(data[pos + 1]);

            if (operator.equals("+")) {
                st.push(number);
            }
            else if (operator.equals("-")) {
                st.push(-number);
            }
        }
        int result = 0;

        while (!st.isEmpty()) {
            result += st.pop();
        }
        System.out.println("" + result);
    }
}
