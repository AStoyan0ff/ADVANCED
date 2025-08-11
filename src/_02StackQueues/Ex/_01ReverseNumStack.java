package _02StackQueues.Ex;

import java.util.Scanner;
import java.util.Stack;

public class _01ReverseNumStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] data = input.split("\\s+");

        Stack<String> st = new Stack<>(); // Old style
        //ArrayDeque<String> st = new ArrayDeque<>(); // -> New style

        for (String n : data) {
            st.push(n);
        }
        // !st.size()
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}


