package _21RegularExam; // 19 February 2022
import java.util.*;

public class _09FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Character> vowelsQu = new ArrayDeque<>();

        for (String v : scanner.nextLine().split(" ")) {
            vowelsQu.offer(v.charAt(0));
        }

        Deque<Character> consonantDeque = new ArrayDeque<>(); // може и Stack

        for (String c : scanner.nextLine().split(" ")) {
            consonantDeque.push(c.charAt(0));
        }

        List<String> findWords = Arrays.asList("pear", "flour", "pork", "olive");
        Map<String, Set<Character>> lettersMap = new HashMap<>();

        for (String w : findWords) {
            Set<Character> charSet = new HashSet<>();

            for (char ch : w.toCharArray()) {
                charSet.add(ch);
            }
            lettersMap.put(w, charSet);
        }

        while (!consonantDeque.isEmpty()) {
            char vowel = vowelsQu.poll(); // NullPointerException !!!
            char consonant = consonantDeque.pop();

            for (String word : findWords) {

                Set<Character> letterSet = lettersMap.get(word);
                letterSet.remove(vowel);
                letterSet.remove(consonant);
            }

            vowelsQu.offer(vowel);
        }

        List<String> isFoundList = new ArrayList<>();
        for (String word : findWords) {

            if (lettersMap.get(word).isEmpty()) {
                isFoundList.add(word);
            }
        }

        System.out.println("Words found: " + isFoundList.size());
        isFoundList.forEach(System.out::println);
    }
}
