package _21RegularExam; // 23 October 2021
import java.util.Scanner;

public class _03MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        char[][] mat = new char[N][N];

        int rows = 0;
        int cols = 0;

        for (int pos = 0; pos < N; pos++) {

            String input = scanner.nextLine();
            mat[pos] = input.toCharArray();

            if (input.contains("M")) {

                rows = pos;
                cols = input.indexOf("M");
            }
        }

        int cheeseEat = 0;
        boolean isMouseOut = false;

        String cmd;
        while (!(cmd = scanner.nextLine()).equals("end")) {
            mat[rows][cols] = '-';

            int[] move = getMove(cmd);

            int nextRow = rows + move[0];
            int nextCol = cols + move[1];

            if (!isLimit(nextRow, nextCol, N)) {

                isMouseOut = true;
                break;
            }

            char nextChar = mat[nextRow][nextCol];

            if (nextChar == 'c') {
                cheeseEat++;
            }
            else if (nextChar == 'B') {

                mat[nextRow][nextCol] = '-';
                rows = nextRow;
                cols = nextCol;

                nextRow += move[0];
                nextCol += move[1];

                if (!isLimit(nextRow, nextCol, N)) {
                    isMouseOut = true;
                    break;
                }

                nextChar = mat[nextRow][nextCol];

                if (nextChar == 'c') {
                    cheeseEat++;
                }

                rows = nextRow;
                cols = nextCol;
                mat[rows][cols] = 'M';

                continue;
            }

            rows = nextRow;
            cols = nextCol;
            mat[rows][cols] = 'M';
        }

        if (isMouseOut) {
            System.out.println("Where is the mouse?");
        }
        else {
            mat[rows][cols] = 'M';
        }

        if (cheeseEat >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEat);
        }
        else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEat);
        }

        print(mat);
    }

    public static int[] getMove(String cmd) {
        return switch (cmd) {

            case "up" ->    new int[] {-1, 0};
            case "down" ->  new int[] {1, 0};
            case "left" ->  new int[] {0, -1};
            case "right" -> new int[] {0, 1};
            default ->      new int[] {0, 0};
        };
    }

    public static boolean isLimit(int r, int c, int size) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }

    public static void print(char[][] mat) {

        for (char[] row : mat) {
            for (char c : row) {

                System.out.print(c);
            }
            System.out.println();
        }
    }
}
