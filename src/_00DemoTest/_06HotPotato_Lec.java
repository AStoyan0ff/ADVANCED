package _00DemoTest;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06HotPotato_Lec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = Arrays
                            .stream(scanner.nextLine().split("\\s+"))
                            .collect(Collectors.toCollection(ArrayDeque::new));

        int cnt = Integer.parseInt(scanner.nextLine());

        while (queue.size() > 1) {
            for (int pos = 1; pos < cnt; pos++) {

                String rotated = queue.poll();
                queue.offer(rotated);
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.peek());
    }
}
