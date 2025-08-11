package _21RegularExam; // 25 June 2022
import java.util.Scanner;

public class _07StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] cmd = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];
        int rows = 0;
        int cols = 0;

        for (int r = 0; r < size; r++) {
            String[] input = scanner.nextLine().split(" ");

            for (int c = 0; c < size; c++) {
                matrix[r][c] = input[c].charAt(0);

                if(matrix[r][c] == 'D') {
                    rows = r;
                    cols = c;
                }
            }
        }

        int stolenMoney = 0;

        for (String c : cmd) {

            int newRow = rows;
            int newCol = cols;

            switch (c.trim()) {

                case "up" -> newRow--;
                case "down" -> newRow++;
                case "left" -> newCol--;
                case "right" -> newCol++;
            }

            if (newRow < 0 || newRow >= size || newCol < 0 || newCol >= size) {

                System.out.println("You cannot leave the town, there is police outside!");
                continue;
            }

            char nextPos = matrix[newRow][newCol];
            matrix[rows][cols] = '+';

            if(nextPos == '$') {

                int stolen = newRow * newCol;
                stolenMoney += stolen;
                matrix[newRow][newCol] = 'D';

                System.out.printf("You successfully stole %s$.\n", stolen);
            }
            else if (nextPos == 'P') {
                matrix[newRow][newCol] = '#';

                System.out.printf("You got caught with %s$, and you are going to jail.\n", stolenMoney);

                printMatrix(matrix);
                return;
            }
            else {
                matrix[newRow][newCol] = 'D';
            }

            rows = newRow;
            cols = newCol;
        }

        System.out.printf("Your last theft has finished successfully with %s$ in your pocket.\n", stolenMoney);

        printMatrix(matrix);
        scanner.close();
    }
    private static void printMatrix(char[][] mat) {

        for (char[] r : mat) {
            for(int c = 0; c < r.length; c++) {

                System.out.print(r[c]);

                if (c != r.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
