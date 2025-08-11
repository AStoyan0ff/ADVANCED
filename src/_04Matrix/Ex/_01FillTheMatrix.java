package _04Matrix.Ex;
import java.util.Scanner;

public class _01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);

        int [][] mat = new int[size][size];

        if (type == 'A') {
            typeA(mat);
        }
        else if (type == 'B') {
            typeB(mat);
        }

        print(mat);
    }

    public static void typeA(int [][] mat) {
        int val = 1;

        for (int c = 0; c < mat.length; c++) {

            for (int r = 0; r < mat.length; r++) {
                mat[r][c] = val++;
            }
        }
    }

    public static void typeB(int [][] mat) {
        int val = 1;

        for (int c = 0; c < mat.length; c++) {
            if (c % 2 == 0) {

                for (int r = 0; r < mat.length; r++) {
                    mat[r][c] = val++;
                }
            }
            else {
                for (int r = mat.length - 1; r >= 0; r--) {
                    mat[r][c] = val++;
                }
            }
        }
    }

    public static void print(int [][] mat) {
        for (int [] r : mat) {

            for (int element : r) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
} // I'm good "SoftUni"... I'm very good... see U later =)
