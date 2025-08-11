package _01StackQueues;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<String> printerQueue = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("print")) {
                break;
            }
            else if (input.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                }
                else {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            }
            else {
                printerQueue.offer(input);
            }
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
