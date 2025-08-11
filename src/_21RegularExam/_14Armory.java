package _21RegularExam; // 13 April 2022
import java.util.*;

public class _14Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrixChar = new char[size][size];
        int R = -1, C = -1;

        int[][] matrixInt = new int[2][2];
        int temp = 0;

        // Read the matrixChar and locate 'A'... and matrixInt
        for (int r = 0; r < size; r++) {

            String input = scanner.nextLine();
            matrixChar[r] = input.toCharArray();

            for (int c = 0; c < size; c++) {

                if (matrixChar[r][c] == 'A') {
                    R = r;
                    C = c;
                }
                else if (matrixChar[r][c] == 'M') {
                    if (temp < 2) {

                        matrixInt[temp][0] = r;
                        matrixInt[temp][1] = c;
                        temp++;
                    }
                }
            }
        }

        int goldCost = 0;
        boolean isDeal = false;

        while (scanner.hasNextLine()) {
            String cmd = scanner.nextLine().trim();

            if (cmd.isEmpty()) {
                continue;
            }

            int newR = R;
            int newC = C;

            switch (cmd) {

                case "up" -> newR--;
                case "down" -> newR++;
                case "left" -> newC--;
                case "right" -> newC++;
            }

            if (newR < 0 || newR >= size || newC < 0 || newC >= size) {

                matrixChar[R][C] = '-';
                break;
            }

            char cell = matrixChar[newR][newC];
            matrixChar[R][C] = '-';

            R = newR;
            C = newC;

            if (Character.isDigit(cell)) {
                int swordValue = Character.getNumericValue(cell);

                goldCost += swordValue;
                matrixChar[R][C] = 'A';

                if (goldCost >= 65) {
                    isDeal = true;
                    break;
                }
            }
            else if (cell == 'M') {
                matrixChar[R][C] = '-';

                if (R == matrixInt[0][0] && C == matrixInt[0][1]) {

                    R = matrixInt[1][0];
                    C = matrixInt[1][1];
                }
                else {
                    R = matrixInt[0][0];
                    C = matrixInt[0][1];
                }
                // Delete pos of the TWO mirrors in the Matrix
                matrixChar[matrixInt[0][0]][matrixInt[0][1]] = '-';
                matrixChar[matrixInt[1][0]][matrixInt[1][1]] = '-';

                matrixChar[R][C] = 'A';
            }
            else {
                matrixChar[R][C] = 'A';
            }
        }

        if (isDeal) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        else {
            System.out.println("I do not need more swords!");
        }

        System.out.println("The king paid " + goldCost + " gold coins.");

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {

                System.out.print(matrixChar[r][c]);
            }
            System.out.println();
        }
    }
}
