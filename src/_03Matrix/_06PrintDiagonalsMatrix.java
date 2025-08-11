package _03Matrix;
import java.util.Scanner;

public class _06PrintDiagonalsMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int [][] matrix = readMatrix(scanner, size);

        firstDiagonal(matrix);
        secondDiagonal(matrix);

        scanner.close();
    }

    public static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] element = scanner.nextLine().split("\\s+");

            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(element[col]);
            }
        }
        return matrix;
    }

    public static void firstDiagonal(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
    }

    public static void secondDiagonal(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            int r = matrix.length - 1 - row;
            int c =row;

            System.out.print(matrix[r][c] + " ");
        }
        System.out.println();
    }
}
