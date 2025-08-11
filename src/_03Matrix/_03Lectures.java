package _03Matrix;
import java.util.Scanner;

public class _03Lectures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String [][] matrixOne = new String[rows][cols];
        String [][] matrixTwo = new String[rows][cols];

        enterMatrix(matrixOne, scanner);
        enterMatrix(matrixTwo, scanner);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (matrixOne[row][col].equals(matrixTwo[row][col])) {
                    System.out.print(matrixOne[row][col] + " ");
                }
                else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    } // Запълваме матрицата с входните данни --> String
    public static void enterMatrix(String [][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
           matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
