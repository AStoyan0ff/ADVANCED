package _03Matrix;
import java.util.Scanner;

public class _01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] firstNeo = readMatrix(scanner);
        int [][] secondNeo = readMatrix(scanner);

        if (neoIsHere(firstNeo, secondNeo)) {
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }
    }
    private static int[][] readMatrix(Scanner scanner) {

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(" ");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        return matrix;
    }
    private static boolean neoIsHere(int[][] matrix1, int[][] matrix2) {

        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int row = 0; row < matrix1.length; row++) {

            if (matrix1[row].length != matrix2[row].length) {
                return false;
            }

            for (int col = 0; col < matrix1[row].length; col++) {

                if (matrix1[row][col] != matrix2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
