package _02StackQueues.Ex;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> st = new ArrayDeque<>();

        for (int pos = 0; pos < input.length; pos++) {
            String prevOperator = input[pos];

            if (prevOperator.equals("+")
                    || prevOperator.equals("-")
                    || prevOperator.equals("*")
                    || prevOperator.equals("/")
                    || prevOperator.equals("^")
                    || prevOperator.equals("(")) {

                if (st.isEmpty() || lower(st.peek(), prevOperator)) {
                    st.push(prevOperator);
                }
                else {
                    while (!lower(st.peek(), prevOperator)) {
                        System.out.print(st.pop() + " ");

                        if (st.isEmpty()) break;
                    }

                    st.push(prevOperator);
                }
            } else if (prevOperator.equals(")")) {

                while (!st.peek().equals("(")) {
                    System.out.print(st.pop() + " ");
                }
                st.pop();
            }
            else {
                System.out.print(prevOperator + " ");
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    private static boolean lower(String curr, String next) {

        int currOp = priority(curr);
        int nextOperatorPrecedence = priority(next);

        if (currOp < nextOperatorPrecedence) {
            return true;
        }
        else if (currOp == nextOperatorPrecedence) {

            if (currOp == 3 || currOp == 4) {
                return true;
            }
            else {
                return false;
            }
        }
        else {

            if (currOp == 4) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    private static int priority(String operator) {
        int advantage = 0;

        if (operator.equals("+") || operator.equals("-")) {
            advantage = 1;
        }
        else if (operator.equals("*") || operator.equals("/")) {
            advantage = 2;
        }
        else if (operator.equals("^")) {
            advantage = 3;
        }
        else if (operator.equals("(")) {
            advantage = 4;
        }

        return advantage;
    }
}
