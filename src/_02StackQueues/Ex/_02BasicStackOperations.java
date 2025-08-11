package _02StackQueues.Ex;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Collections;

public class _02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int Y = scanner.nextInt();

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int as = 1; as <= N; as++) {
            st.push(scanner.nextInt());
        }

        for (int as = 1; as <= S; as++) {
            st.pop();
        }

        if (st.contains(Y)) {
            System.out.println("true");
        }
        else {

            if (st.isEmpty()) {
                System.out.println(0);
            }
            else {
                System.out.println(Collections.min(st));
            }
        }
    }
}
