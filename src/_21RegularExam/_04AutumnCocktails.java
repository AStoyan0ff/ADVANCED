package _21RegularExam; // 23 October 2021
import java.util.*;
import java.util.stream.Collectors;

public class _04AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> elementsQu = Arrays
                                    .stream(scanner.nextLine()
                                    .split("\\s+"))
                                    .map(Integer::parseInt)
                                    // Filter out 0 values
                                    .filter(x -> x != 0)
                                    .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshQu = Arrays
                                    .stream(scanner.nextLine()
                                    .split("\\s+"))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toCollection(ArrayDeque::new));


        Map<String, Integer> cocktailsMap = new TreeMap<>();

        cocktailsMap.put("Pear Sour", 0);
        cocktailsMap.put("The Harvest", 0);
        cocktailsMap.put("Apple Hinny", 0);
        cocktailsMap.put("High Fashion", 0);

        while (!elementsQu.isEmpty() && !freshQu.isEmpty()) {

            int currElement = elementsQu.pollFirst();
            int currFresh = freshQu.pollLast(); // NullPointerException ???
            int totalFresh = currElement * currFresh;

            switch (totalFresh) {

                case 150:
                    cocktailsMap.put("Pear Sour", cocktailsMap.get("Pear Sour") + 1);
                    break;

                case 250:
                    cocktailsMap.put("The Harvest", cocktailsMap.get("The Harvest") + 1);
                    break;

                case 300:
                    cocktailsMap.put("Apple Hinny", cocktailsMap.get("Apple Hinny") + 1);
                    break;

                case 400:
                    cocktailsMap.put("High Fashion", cocktailsMap.get("High Fashion") + 1);
                    break;

                default:
                    currElement += 5;
                    elementsQu.addLast(currElement);
                    break;
            }
        }


        boolean isMade = cocktailsMap
                        .values()
                        .stream()
                        .allMatch(cnt -> cnt > 0);


        if (isMade) {
            System.out.println("It's party time! The cocktails are ready!");
        }
        else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }


        if (!elementsQu.isEmpty()) {

            int res = elementsQu.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Ingredients left: " + res);
        }


        cocktailsMap // print forEach API Stream
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > 0)
                .forEach(p ->
                        System.out.println("# " + p.getKey() + " --> " + p.getValue()));
    }
}
