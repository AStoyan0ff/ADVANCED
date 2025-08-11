package _03Matrix;
import java.util.Scanner;

public class _02PositionOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
                String[] line = scanner.nextLine().split(" ");

            for (int c = 0; c < cols; c++) {
                matrix[r][c] = Integer.parseInt(line[c]);
            }
        }

        int number = Integer.parseInt(scanner.nextLine());
        boolean bFirst = false;

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == number) {

                    System.out.println(r + " " + c);
                    bFirst = true;
                }
            }
        }

        if (!bFirst) {
            System.out.println("not found");
        }
    }
}
//AStoyanoff