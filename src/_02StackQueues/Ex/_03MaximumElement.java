package _02StackQueues.Ex;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Collections;

public class _03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> st = new ArrayDeque<>();

        int N = Integer.parseInt(scanner.nextLine());

        for (int pos = 1; pos <= N; pos++) {
            String cmd = scanner.nextLine();

            if (cmd.equals("2")) {
                st.pop();
            }
            else if (cmd.equals("3")) {

                if (!st.isEmpty()) {
                    System.out.println(Collections.max(st));
                }
            }
            else {
                int num = Integer.parseInt(cmd.split("\\s+")[1]);
                st.push(num);
            }
        }
    }
}
