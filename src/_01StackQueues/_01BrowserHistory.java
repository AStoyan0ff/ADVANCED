package _01StackQueues;
import java.util.Scanner;
import java.util.ArrayDeque;

public class _01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> st = new ArrayDeque<>();
        String currURL = "";

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Home")) {
                break;
            }

            if (input.equals("back")) {
                if (!st.isEmpty()) {
                    currURL = st.pop();
                }
                else {
                    System.out.println("no previous URLs");
                    continue;
                }
            }
            else {
                if (!currURL.isEmpty()) {
                    st.push(currURL);
                }
                currURL = input;
            }

            System.out.println(currURL);
        }
    }
}
