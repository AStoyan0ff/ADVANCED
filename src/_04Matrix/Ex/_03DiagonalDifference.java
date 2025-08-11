package _04Matrix.Ex;
import java.util.Scanner;

public class _03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];


        for (int r = 0; r < size; r++) {
            String[] input = scanner.nextLine().split(" ");

            for (int c = 0; c < size; c++) {
                matrix[r][c] = Integer.parseInt(input[c]);
            }
        }

        int bFirst = 0;
        int bSecond = 0;

        for (int pos = 0; pos < size; pos++) {

            bFirst += matrix[pos][pos];
            bSecond += matrix[pos][size - 1 - pos];
        }

        int diff = Math.abs(bFirst - bSecond);
        System.out.println(diff);
    }
}
