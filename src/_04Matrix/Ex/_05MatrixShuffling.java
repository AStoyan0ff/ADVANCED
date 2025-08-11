package _04Matrix.Ex;
import java.util.Scanner;

public class _05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();

            String[] elements = line.split(" ");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = elements[j];
            }
        }


        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();

            if (command.equals("END")) {
                break;
            }

            String[] parts = command.split(" ");

            if (parts.length != 5 || !parts[0].equals("swap")) {

                System.out.println("Invalid input!");
                continue;
            }

            try {
                int row1 = Integer.parseInt(parts[1]);
                int col1 = Integer.parseInt(parts[2]);
                int row2 = Integer.parseInt(parts[3]);
                int col2 = Integer.parseInt(parts[4]);

                if (row1 >= 0 && row1 < rows && col1 >= 0 && col1 < cols &&
                    row2 >= 0 && row2 < rows && col2 >= 0 && col2 < cols) {

                    String temp = matrix[row1][col1];

                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {

                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
                else {
                    System.out.println("Invalid input!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
