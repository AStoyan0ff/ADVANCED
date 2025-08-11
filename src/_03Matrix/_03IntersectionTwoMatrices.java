package _03Matrix;
import java.util.Scanner;

public class _03IntersectionTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());


        char[][] matrixOne = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                matrixOne[row][col] = line[col].charAt(0);
            }
        }
        char[][] matrixTwo = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(" ");

            for (int col = 0; col < cols; col++) {
                matrixTwo[row][col] = line[col].charAt(0);
            }
        }


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (matrixOne[row][col] == matrixTwo[row][col]) {
                    System.out.print(matrixOne[row][col] + " ");
                }
                else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
