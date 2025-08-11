package _02StackQueues.Ex;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _04BasicQueueOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> qu = new ArrayDeque<>();

        for (int pos = 1; pos <= n; pos++) {
            qu.offer(scanner.nextInt());
        }

        for (int idx = 1; idx <= s; idx++) {
            qu.poll();
        }

        if (qu.contains(x)) {
            System.out.println("true");
        }
        else {

            if (qu.isEmpty()) {
                System.out.println(0);
            }
            else {
                System.out.println(Collections.min(qu));
            }
        }
    }
}
