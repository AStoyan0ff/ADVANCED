package _04Matrix.Ex;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class _00DemoMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //int [][] matrix = new int[3][3];

        //int cnt = 1;

        /*for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {

                matrix[r][c] = cnt++;

            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }*/

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        printMatrix(matrix);
        checkMatrix(matrix, rows, cols);
    }
        //----------------------------------------------------------------------
        // Обхождане на матрица без да достъпваме индексите на елементите в нея
        //----------------------------------------------------------------------
    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
        // Обхождане и отпечатване на матрица
    private static void checkMatrix(int[][] matrix, int rows, int cols) {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
