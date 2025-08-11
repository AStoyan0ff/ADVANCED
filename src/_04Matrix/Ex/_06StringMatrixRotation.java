package _04Matrix.Ex;

import java.util.*;

public class _06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int degrees = Integer.parseInt(input
                .replace("Rotate(", "")
                .replace(")", ""));

        int normalRotation = degrees % 360;


        List<String> lineList = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("END")) {

            lineList.add(line);
            line = scanner.nextLine();
        }

        int rows = lineList.size();
        int cols = lineList
                .stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            String current = lineList.get(r);

            for (int c = 0; c < cols; c++) {

                if (c < current.length()) {
                    matrix[r][c] = current.charAt(c);
                }
                else {
                    matrix[r][c] = ' ';
                }
            }
        }

        switch (normalRotation) {

            case 0:
                printMatrix(matrix);
                break;

            case 90:
                printMatrix(rotate90(matrix));
                break;

            case 180:
                printMatrix(rotate180(matrix));
                break;

            case 270:
                printMatrix(rotate270(matrix));
                break;
        }
    }


    private static char[][] rotate90(char[][] matrix) {

        int newRows = matrix[0].length;
        int newCols = matrix.length;

        char[][] rotated = new char[newRows][newCols];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {

                rotated[c][newCols - 1 - r] = matrix[r][c];
            }
        }
        return rotated;
    }

    private static char[][] rotate180(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        char[][] rotated = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                rotated[rows - 1 - r][cols - 1 - c] = matrix[r][c];
            }
        }
        return rotated;
    }

    private static char[][] rotate270(char[][] matrix) {

        int newRows = matrix[0].length;
        int newCols = matrix.length;

        char[][] rotated = new char[newRows][newCols];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {

                rotated[newRows - 1 - c][r] = matrix[r][c];
            }
        }
        return rotated;
    }

    private static void printMatrix(char[][] matrix) {

        for (char[] row : matrix) {
            System.out.println(new String(row));
        }
    }
}
