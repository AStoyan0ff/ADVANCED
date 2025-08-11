package _04Matrix.Ex;
import java.util.Scanner;

public class _02MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        print(rows, cols);
    }
    public static void print(int row, int col) {

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {

                char firstLast = (char) ('a' + r);
                char middle = (char) ('a' + r + c);

                String palindrome = "" + firstLast + middle + firstLast;
                System.out.print(palindrome + " ");
            }
            System.out.println();
        }
    }

}
