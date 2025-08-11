package _02StackQueues.Ex;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        int [] plants = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> st = new ArrayDeque<>();

        int[] days = new int[plants.length];
        st.push(0);

        for (int pos = 1; pos < plants.length; pos++) {
            int maxDays = 0;

            while (!st.isEmpty() && plants[st.peek()] >= plants[pos]) {

                maxDays = Integer.max(days[st.pop()], maxDays);
            }

            if (!st.isEmpty()) {
                days[pos] = maxDays + 1;
            }

            st.push(pos);
        }

        System.out.printf("%d", Arrays
                                .stream(days)
                                .max()
                                .getAsInt());
    }
}
