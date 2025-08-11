// Regular Exam - 20 October 2024
package _21RegularExam;
import java.util.Scanner;
import java.util.*;

public class _01BallGame {
    public static void main(String[] args) {  // 88/100
        Scanner scanner = new Scanner(System.in);

        int[] strInput = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] accInput = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> quS = new ArrayDeque<>();

        for (int s : strInput) {
            quS.offer(s);
        }

        ArrayDeque<Integer> quA = new ArrayDeque<>();

        for (int a : accInput) {
            quA.offer(a);
        }

        int goals = 0;

        while (!quS.isEmpty() && !quA.isEmpty()) {

            int strength = quS.pollLast();
            int accuracy = quA.peek();

            int sum = strength + accuracy;

            if (sum == 100) {

                quA.poll();
                goals++;
            }
            else if (sum < 100) {

                if (strength < accuracy) {
                    continue;
                }
                else if (strength > accuracy) {
                    quA.poll();
                    quS.offerLast(strength);
                }
                else {

                    quA.poll();
                    quS.offerFirst(strength + accuracy);
                }
            } else {
                strength -= 10;

                if (strength >= 10) {
                    quS.offerFirst(strength);
                }
                int moved = quA.poll();
                quA.offer(moved);
            }
        }


        if (goals == 0)
            System.out.println("Paul failed to score a single goal.");

        else if (goals == 3)
            System.out.println("Paul scored a hat-trick!");

        else if (goals > 3)
            System.out.println("Paul performed remarkably well!");

        else {
            System.out.println("Paul failed to make a hat-trick.");
        }

        if (goals > 0) {
            System.out.println("Goals scored: " + goals);
        }

        if (!quS.isEmpty()) {
            System.out.print("Strength values left: ");

            System.out.println(String.join(", ",
                    quS
                            .stream()
                            .map(String::valueOf)
                            .toArray(String[]::new)));
        }

        if (!quA.isEmpty()) {

            System.out.print("Accuracy values left: ");

            System.out.println(String.join(", ",
                    quA.stream()
                            .map(String::valueOf)
                            .toArray(String[]::new)));
        }
    }
}
