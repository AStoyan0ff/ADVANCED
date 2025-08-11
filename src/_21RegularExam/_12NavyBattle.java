package _21RegularExam;
import java.util.*;

public class _12NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine()); // matrix size

        // Reading and finding the starting pos in matrix
        char[][] matrix = new char[size][size];
        int R = -1; // Start pos matrix '0'
        int C = -1;

        for (int r = 0; r < size; r++) {
            String input = scanner.nextLine();

            for (int c = 0; c < size; c++) {
                matrix[r][c] = input.charAt(c);

                if (matrix[r][c] == 'S') {
                    R = r;
                    C = c;
                }
            }
        }

        int mine = 0;
        int explosion = 0;

        while (mine < 3 && explosion < 3) {
            String cmd = scanner.nextLine();
            // Curr pos -> '-'
            matrix[R][C] = '-';

            switch (cmd) {
                // New position
                case "up" -> R--;
                case "down" -> R++;
                case "left" -> C--;
                case "right" -> C++;
            }
            // Check new pos
            char currCell = matrix[R][C];

            if (currCell == '*') {
                mine++;
            }
            else if (currCell == 'C') {
                explosion++;
            }
            //Clear pos
            matrix[R][C] = 'S';
        }

        if(explosion == 3) {
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }
        else {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%s, %s]!%n", R, C);
        }

        for (char[] r : matrix) {
            System.out.println(String.valueOf(r));
        }
    }
}
