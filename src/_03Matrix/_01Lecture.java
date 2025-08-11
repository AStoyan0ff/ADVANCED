package _03Matrix;
import java.util.Arrays;
import java.util.Scanner;

public class _01Lecture {
    public static void main(String[] args) {   // 50/50
        Scanner scanner = new Scanner(System.in);

        String firstMatrixResult = scanner.nextLine();

        int rows = Integer.parseInt(firstMatrixResult.split(" ")[0]);
        int cols = Integer.parseInt(firstMatrixResult.split(" ")[1]);

        int[][] matA = new int[rows][cols];
        fillMatrix(matA, scanner);

        String secondMatrixResult = scanner.nextLine();

        rows = Integer.parseInt(secondMatrixResult.split(" ")[0]);
        cols = Integer.parseInt(secondMatrixResult.split(" ")[1]);

        int[][] matB = new int[rows][cols];
        fillMatrix(matB, scanner);

        if (isEqual(matA, matB)) {
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }
    }
    // Пълнене на матрица от конзолата
    private static void fillMatrix(int[][] matrix, Scanner scanner) {

        for (int r = 0; r < matrix.length; r++) {

            matrix[r] = Arrays
                    .stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
    }

    private static boolean isEqual(int[][] matrix1, int[][] matrix2) {

        if (matrix1.length != matrix2.length) { // брой редове (съвпадения)
            return false;
        }

        if (matrix1[0].length != matrix2[0].length) { // брой колони (съвпадения)
            return false;
        }

        for (int r = 0; r < matrix1.length; r++) {
            for (int c = 0; c < matrix2.length; c++) {

                if (matrix1[r][c] != matrix2[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}