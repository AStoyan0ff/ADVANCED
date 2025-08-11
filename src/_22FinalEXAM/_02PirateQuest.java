package _22FinalEXAM;
import java.util.Scanner;

public class _02PirateQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int R = 0, C = 0;
        int bStability = 100;
        boolean bFirst = false;

        int treasures = 0;

        for (int r = 0; r < size; r++) {
            String input = scanner.nextLine();

            for (int c = 0; c < size; c++) {
                matrix[r][c] = input.charAt(c);

                if (matrix[r][c] == 'S') {
                    R = r;
                    C = c;
                }
                else if (matrix[r][c] == '*') {
                    treasures++;
                }
            }
        }

        while (true) {
            String cmd = scanner.nextLine();
            if (cmd.equals("stop")) break;

            matrix[R][C] = '.';

            switch (cmd) {

                case "up":    R = (R - 1 + size) % size; break;
                case "down":  R = (R + 1) % size; break;
                case "left":  C = (C - 1 + size) % size; break;
                case "right": C = (C + 1) % size; break;
            }

            char cell = matrix[R][C];

            switch (cell) {
                case 'M':

                    bStability -= 25;
                    break;

                case 'C':

                    if (!bFirst) {

                        bStability = Math.min(100, bStability + 25);
                        bFirst = true;
                    }
                    break;

                case '*':

                    treasures--;
                    break;
            }

            matrix[R][C] = 'S';

            if (bStability <= 0) {
                System.out.printf("Shipwreck! Last known coordinates (%d, %d)%n", R, C);

                status(bStability, treasures);
                printMatrix(matrix);
                return;
            }

            if (treasures == 0) {
                System.out.println("Yo-ho-ho! All treasure chests collected!");

                status(bStability, 0);
                printMatrix(matrix);
                return;
            }
        }

        if (treasures > 0) {
            System.out.println("Retreat! Some treasures remain unclaimed.");
        }
        else {
            System.out.println("Yo-ho-ho! All treasure chests collected!");
        }
        status(bStability, treasures);
        printMatrix(matrix);
    }

    private static void status(int power, int remaining) {
        System.out.println("Ship Durability: " + power);

        if (remaining > 0) {
            System.out.println("Unclaimed chests: " + remaining);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {

            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
