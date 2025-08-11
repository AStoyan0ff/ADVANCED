package _09FunctionalProgramming;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] words = input.split("\\s+");

        Predicate<String> bUpCase = word ->
                !word.isEmpty() && Character.isUpperCase(word.charAt(0));

        List<String> wordsList = Arrays
                        .stream(words)
                        .filter(bUpCase)
                        .toList();

        System.out.println(wordsList.size());
        wordsList.forEach(System.out::println);
    }
}
