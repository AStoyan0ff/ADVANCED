package _03Matrix;
import java.util.Arrays;
import java.util.Scanner;

public class _02Lect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);

        int [][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        int num = Integer.parseInt(scanner.nextLine());
        boolean bFound = false;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {

                int curr = matrix[r][c];

                if (curr == num) {
                    System.out.println(r + " " + c);

                    bFound = true;
                }
            }
        }

        if (!bFound) {
            System.out.println("not found");
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {

        for (int r = 0; r < matrix.length; r++) {

            matrix[r] = Arrays
                    .stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
    }
}
