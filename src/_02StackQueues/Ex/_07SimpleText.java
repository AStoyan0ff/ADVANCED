package _02StackQueues.Ex;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _07SimpleText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        StringBuilder buffer = new StringBuilder();

        ArrayDeque<String> st = new ArrayDeque<>();

        for (int as = 1; as <= N; as++) {

            String cmd = scanner.nextLine();
            if (cmd.startsWith("1")) {

                st.push(buffer.toString());

                String text = cmd.split("\\s+")[1];
                buffer.append(text);
            }
            else if (cmd.startsWith("2")) {

                st.push(buffer.toString());

                int count = Integer.parseInt(cmd.split("\\s+")[1]);

                int deleted = buffer.length() - count;
                buffer.delete(deleted, buffer.length());
            }
            else if (cmd.startsWith("3")) {

                int idx = Integer.parseInt(cmd.split("\\s+")[1]);
                System.out.println(buffer.charAt(idx - 1));
            }
            else if (cmd.equals("4")) {

                if (!st.isEmpty()) {

                    String last = st.pop();
                    buffer = new StringBuilder(last);
                }
            }
        }
    }
}
