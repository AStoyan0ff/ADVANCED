package _01StackQueues;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int pos = 0; pos <= input.length() - 1; pos++) {
            char currCh = input.charAt(pos);

            if (currCh == '(') {
                st.push(pos);
            }
            else if (currCh == ')') {
                int startPos = st.pop();

                System.out.println(input.substring(startPos, pos + 1));
            }
        }
    }
}
