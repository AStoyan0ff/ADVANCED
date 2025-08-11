package _01StackQueues;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] data = scanner.nextLine().split(" ");
        int N = Integer.parseInt(scanner.nextLine());

        Queue<String> queue = new ArrayDeque<>();

        for (String child : data) {
            queue.offer(child);
        }

        while (queue.size() > 1) {

            for (int pos = 1; pos < N; pos++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
