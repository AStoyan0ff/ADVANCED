package _00DemoTest;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _05PrinterQu_Lec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> qu = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {

                if (qu.isEmpty()) {
                    System.out.println("Printer is on standby");
                }
                else {
                    System.out.println("Canceled " + qu.poll());
                }
            }
            else {
                qu.offer(input);
            }

            input = scanner.nextLine();
        }
        while (!qu.isEmpty()) {
            System.out.println(qu.poll());
        }
    }
}
