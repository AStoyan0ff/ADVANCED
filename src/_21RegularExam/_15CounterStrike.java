package _21RegularExam;
import java.util.Scanner;

public class _15CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(", ");
        int R = Integer.parseInt(size[0]);
        int C = Integer.parseInt(size[1]);

        char[][] matrix = new char[R][C];
        char[][] result = new char[R][C];

        int currR = -1, currC = -1;
        int bombR = -1, bombC = -1;
        int startR = -1, startC = -1;

        for (int r = 0; r < R; r++) {
            String input = scanner.nextLine();

            matrix[r] = input.toCharArray();
            System.arraycopy(matrix[r], 0, result[r], 0, C);

            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 'C') {

                    currR = r;
                    currC = c;
                    startR = r;
                    startC = c;
                }
                else if (matrix[r][c] == 'B') {

                    bombR = r;
                    bombC = c;
                }
            }
        }

        int time = 16;
        boolean bombDefuse = false;
        boolean killed = false;
        boolean bombExplode = false;
        int needTime = 0;

        while (scanner.hasNextLine()) { // true-false
            String cmd = scanner.nextLine();

            if (cmd.equals("defuse")) {
                if (currR == bombR && currC == bombC) {

                    if (time >= 4) {

                        time -= 4;
                        result[bombR][bombC] = 'D';
                        bombDefuse = true;
                    }
                    else {

                        needTime = time - 4;
                        time = 0;
                        bombExplode = true;
                        result[currR][currC] = 'X';
                    }
                    break;
                }
                else {
                    time -= 2;

                    if (time <= 0) {

                        bombExplode = true;
                        break;
                    }
                }
            }
            else {

                int newRow = currR;
                int newCol = currC;

                switch (cmd) {

                    case "up" -> newRow--;
                    case "down" -> newRow++;
                    case "left" -> newCol--;
                    case "right" -> newCol++;
                }

                time--;

                if (time < 0) {

                    bombExplode = true;
                    break;
                }

                if (newRow < 0 || newRow >= R || newCol < 0 || newCol >= C) {
                    continue;
                }

                if (matrix[newRow][newCol] == 'T') {

                    result[currR][currC] = '*';
                    result[newRow][newCol] = '*';
                    killed = true;
                    break;
                }


                matrix[currR][currC] = '*';
                currR = newRow;
                currC = newCol;
            }

            if (time == 0) {
                bombExplode = true;
                break;
            }
        }


        if (!killed && !bombDefuse) {
            result[startR][startC] = 'C';
        }

        if (bombDefuse) {

            System.out.println("Counter-terrorist wins!");
            System.out.println("Bomb has been defused: " + time + " second/s remaining.");
        }
        else if (killed) {
            System.out.println("Terrorists win!");
        }
        else if (bombExplode) {

            System.out.println("Terrorists win!");
            System.out.println("Bomb was not defused successfully!");
            System.out.println("Time needed: " + needTime + " second/s.");
        }

        printMatrix(result);
    }

    public static void printMatrix(char[][] matrix) {

        for (char[] r : matrix) {
            System.out.println(new String(r));
        }
    }
}







