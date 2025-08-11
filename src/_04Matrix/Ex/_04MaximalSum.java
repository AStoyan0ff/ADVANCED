package _04Matrix.Ex;
import java.util.Scanner;

public class _04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            String[] val = scanner.nextLine().split(" ");

            for (int c = 0; c < cols; c++) {
                matrix[r][c] = Integer.parseInt(val[c]);
            }
        }


        int result = Integer.MIN_VALUE;
        int bRow = 0;
        int bCol = 0;

        for (int r = 0; r <= rows - 3; r++) {

            for (int c = 0; c <= cols - 3; c++) {
                int currRes = getRes(matrix, r, c);

                if (currRes > result) {

                    result = currRes;
                    bRow = r;
                    bCol = c;
                }
            }
        }
        System.out.println("Sum = " + result);

        for (int r = bRow; r < bRow + 3; r++) {
            for (int c = bCol; c < bCol + 3; c++) {

                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }


    public static int getRes(int[][] matrix, int startR, int startC) {
        int res = 0;

        for (int r = startR; r < startR + 3; r++) {
            for (int c = startC; c < startC + 3; c++) {

                res += matrix[r][c];
            }
        }
        return res;
    }
}
