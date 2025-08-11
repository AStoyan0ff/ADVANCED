package _04Matrix.Ex;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                matrix[r][c] = scanner.nextInt();
            }
        }

        List<List<Integer>> resultList = getDiagonals(matrix, cols, rows);

        for (List<Integer> diag : resultList) {
            for (int num : diag) {

                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    private static List<List<Integer>> getDiagonals(int[][] matrix, int cols, int rows) {
        List<List<Integer>> resultList = new ArrayList<>();

        for (int d = rows + cols - 2; d >= 0; d--) { // Обединение на цикли =|

            List<Integer> diagonalList = new ArrayList<>();
            int r = Math.min(rows - 1, d);
            int c = d - r;

            while (r >= 0 && c < cols) {

                diagonalList.add(matrix[r][c]);
                r--;
                c++;
            }
            resultList.add(diagonalList);
        }
        return resultList;
    }
}
