package _03Matrix;
import java.util.Scanner;

public class _04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cmd = scanner.nextLine().split(",\\s*");

        int rows = Integer.parseInt(cmd[0]);
        int cols = Integer.parseInt(cmd[1]);

        int sum = 0;

        for (int r = 0; r < rows; r++) {
            String [] line = scanner.nextLine().split(",\\s*");

            for (int c = 0; c < cols; c++) {
                sum += Integer.parseInt(line[c]);
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
