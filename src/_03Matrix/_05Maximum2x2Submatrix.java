package _03Matrix;
import java.util.Scanner;

public class _05Maximum2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(",\\s*");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] mat = new int[rows][cols];


        for (int r = 0; r < rows; r++) {
            String[] line = scanner.nextLine().split(",\\s*");

            for (int c = 0; c < cols; c++) {
                mat[r][c] = Integer.parseInt(line[c]);
            }
        }
        int maxSum = Integer.MIN_VALUE;

        int bRow = 0;
        int bCol = 0;

        for (int r = 0; r < rows - 1; r++) {
            for (int c = 0; c < cols - 1; c++) {

                int currentSum =
                        mat[r][c] + mat[r][c + 1] +
                        mat[r + 1][c] + mat[r + 1][c + 1];

                if (currentSum > maxSum) {

                    maxSum = currentSum;
                    bRow = r;
                    bCol = c;
                }
            }
        }
        System.out.println(mat[bRow][bCol] + " " + mat[bRow][bCol + 1]);
        System.out.println(mat[bRow + 1][bCol] + " " + mat[bRow + 1][bCol + 1]);
        System.out.println(maxSum);
    }
}
