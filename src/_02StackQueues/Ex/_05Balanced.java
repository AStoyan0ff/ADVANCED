package _02StackQueues.Ex;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _05Balanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        ArrayDeque<Character> st = new ArrayDeque<>();

        boolean bFirst = false;

        for (char c : data.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            }
            else if (c == ')' || c == ']' || c == '}') {

                if (st.isEmpty()) {

                    bFirst = false;
                    break;
                }
                char lastBracket = st.pop();

                if (lastBracket == '(' && c == ')') {
                    bFirst = true;
                }

                else if (lastBracket == '[' && c == ']') {
                    bFirst = true;
                }

                else if (lastBracket == '{' && c == '}') {
                    bFirst = true;
                }
                else {
                    bFirst = false;
                    break;
                }
            }
        }
        if (bFirst) {
            System.out.println("YES");
        }

        else {
            System.out.println("NO");
        }
    }
}
