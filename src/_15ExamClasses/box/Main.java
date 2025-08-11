package _15ExamClasses.box;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int pos = 1; pos < N; pos++) {

            String input = scanner.nextLine();
            box.add(input);
        }
    }
}
