package _21RegularExam; // 19 February 2022
import java.util.Scanner;

public class _10PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // const -> final
        int size = 8; // може да е константа =)

        char[][] matrix = new char[size][size];

        int wRows = -1, wCols = -1; // C++ style =)
        int bRows = -1, bCols = -1; // '0' -> може да е валидна позция на дъската =)

        for (int r = 0; r < size; r++) {
            String input = scanner.nextLine();

            for (int c = 0; c < size; c++) {
                matrix[r][c] = input.charAt(c);

                if (matrix[r][c] == 'w') {
                    wRows = r;
                    wCols = c;
                }
                else if (matrix[r][c] == 'b') {
                    bRows = r;
                    bCols = c;
                }
            }
        }

        boolean endGame = false;
        while (!endGame) {

            if (getIt(wRows, wCols, bRows, bCols, -1)) {
                String pos = getChessPos(bRows, bCols);

                System.out.printf("Game over! White capture on %s.%n", pos);
                break;
            }

            matrix[wRows][wCols] = '-';
            wRows -= 1;
            matrix[wRows][wCols] = 'w';

            if (wRows == 0) {
                String pos = getChessPos(wRows, wCols);

                System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", pos);
                break;
            }

            if (getIt(bRows, bCols, wRows, wCols, +1)) {
                String pos = getChessPos(wRows, wCols);

                System.out.printf("Game over! Black capture on %s.%n", pos);
                break;
            }

            matrix[bRows][bCols] = '-';
            bRows += 1;
            matrix[bRows][bCols] = 'b';

            if (bRows == 7) {
                String pos = getChessPos(bRows, bCols);

                System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", pos);
                break;
            }
        }
    }

    private static boolean getIt(int attackR, int attackerC, int targetR, int targetC, int coordinates) {

        return     (attackR + coordinates == targetR)
                && (attackerC - 1 == targetC
                ||  attackerC + 1 == targetC);
    }

    private static String getChessPos(int r, int c) {

        char file = (char) ('a' + c); // форсиране =)
        int ranked = 8 - r;

        return "" + file + ranked;
    }
}
