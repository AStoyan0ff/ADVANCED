package _04Matrix.Ex;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _09RadioActiveMutantVampire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        scanner.nextLine();

        char[][] matrix = new char[rows][cols];
        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i < rows; i++) {

            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();

            if (line.contains("P")) {

                playerRow = i;
                playerCol = line.indexOf('P');
            }
        }
        String cmd = scanner.nextLine();
        Map<Character, int[]> dirMap = new HashMap<>();

        dirMap.put('U', new int[]{-1, 0});
        dirMap.put('D', new int[]{1, 0});
        dirMap.put('L', new int[]{0, -1});
        dirMap.put('R', new int[]{0, 1});

        boolean won = false;
        boolean died = false;
        int finalRow = playerRow;
        int finalCol = playerCol;

        for (char c : cmd.toCharArray()) {
            int[] move = dirMap.get(c);

            int newRow = playerRow + move[0];
            int newCol = playerCol + move[1];

            matrix[playerRow][playerCol] = '.';

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                won = true;

                finalRow = playerRow;
                finalCol = playerCol;
            }
            else if (matrix[newRow][newCol] == 'B') {
                died = true;

                finalRow = newRow;
                finalCol = newCol;
                playerRow = newRow;
                playerCol = newCol;
            }
            else {

                matrix[newRow][newCol] = 'P';
                playerRow = newRow;
                playerCol = newCol;
            }
            matrix = bunny(matrix);

            if (!won && matrix[playerRow][playerCol] == 'B') {
                died = true;

                finalRow = playerRow;
                finalCol = playerCol;
            }

            if (won || died) {
                break;
            }
        }

        for (char[] row : matrix) {
            System.out.println(new String(row));
        }

        if (won) {
            System.out.printf("won: %d %d%n", finalRow, finalCol);
        }
        else if (died) {
            System.out.printf("dead: %d %d%n", finalRow, finalCol);
        }
    }
    private static char[][] bunny(char[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        char[][] newMat = new char[rows][cols];

        // Copy current status
        for (int i = 0; i < rows; i++) {
            newMat[i] = mat[i].clone();
        }

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (mat[r][c] == 'B') {
                    for (int s = 0; s < 4; s++) {

                        int newRow = r + dRow[s];
                        int newCol = c + dCol[s];

                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                            newMat[newRow][newCol] = 'B';
                        }
                    }
                }
            }
        }
        return newMat;
    }
}
