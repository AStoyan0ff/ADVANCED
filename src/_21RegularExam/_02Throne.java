package _21RegularExam; // 15 December 2021
import java.util.Scanner;

public class _02Throne {

    static char[][] matrix;
    static int playerRow;
    static int playerCol;
    static int energy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        energy = Integer.parseInt(scanner.nextLine());
        int N = Integer.parseInt(scanner.nextLine());
        matrix = new char[N][];

        for (int row = 0; row < N; row++) {
            matrix[row] = scanner.nextLine().toCharArray(); // без аргументи '0'

            for (int col = 0; col < matrix[row].length; col++) {

                if (matrix[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean bFirst = false;

        while (!bFirst) {
            String[] data = scanner.nextLine().split("\\s+");

            String dir = data[0];
            int rows = Integer.parseInt(data[1]);
            int cols = Integer.parseInt(data[2]);

            matrix[rows][cols] = 'S';
            matrix[playerRow][playerCol] = '-';

            int[] newPos = moved(dir, playerRow, playerCol);

            playerRow = newPos[0];
            playerCol = newPos[1];
            energy--;

            if (bLimit(playerRow, playerCol)) {
                char cell = matrix[playerRow][playerCol];

                if (cell == 'S') {
                    energy -= 2;
                }

                if (energy <= 0) {

                    if (cell == 'H') {
                        matrix[playerRow][playerCol] = '-';

                        System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                    }
                    else {
                        matrix[playerRow][playerCol] = 'X';

                        System.out.printf("Paris died at %d;%d.%n", playerRow, playerCol);
                    }
                    bFirst = true;
                }
                else {

                    if (cell == 'H') {
                        matrix[playerRow][playerCol] = '-';

                        System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                        bFirst = true;
                    }
                    else {
                        matrix[playerRow][playerCol] = 'P';
                    }
                }
            }
            else {
                playerRow = newPos[2];
                playerCol = newPos[3];

                if (energy <= 0) {
                    matrix[playerRow][playerCol] = 'X';

                    System.out.printf("Paris died at %d;%d.%n", playerRow, playerCol);
                    bFirst = true;
                }
                else {
                    matrix[playerRow][playerCol] = 'P';
                }
            }
        }

        for (char[] row : matrix) {
            System.out.println(String.valueOf(row));
        }
    }

    private static int[] moved(String dir, int row, int col) {

        int newRow = row;
        int newCol = col;

        switch (dir) {

            case "up"    -> newRow--;
            case "down"  -> newRow++;
            case "left"  -> newCol--;
            case "right" -> newCol++;
        }

        if (bLimit(newRow, newCol)) {
            return new int[] {newRow, newCol, row, col};
        }
        else {
            return new int[] {row, col, row, col};
        }
    }

    private static boolean bLimit(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
