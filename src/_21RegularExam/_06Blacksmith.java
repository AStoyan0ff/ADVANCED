package _21RegularExam; // 13 April 2022

import java.util.*;
import java.util.stream.Collectors;

public class _06Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> steelQu = Arrays
                        .stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayDeque::new));


        Stack<Integer> carbonSt = Arrays
                        .stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(Stack::new));

        Map<Integer, String> swordMap = new HashMap<>();

        swordMap.put(70, "Gladius");
        swordMap.put(80, "Shamshir");
        swordMap.put(90, "Katana");
        swordMap.put(110, "Sabre");

        Map<String, Integer> forgetSwordMap = new TreeMap<>();

        while (!steelQu.isEmpty() && !carbonSt.isEmpty()) {

            int steel = steelQu.poll();
            int carbon = carbonSt.pop();
            int result = steel + carbon;

            if (swordMap.containsKey(result)) {

                String sword = swordMap.get(result);
                forgetSwordMap.put(sword, forgetSwordMap.getOrDefault(sword, 0) + 1);
            }
            else {
                //carbon += 5;
                carbonSt.push(carbon + 5);
            }
        }

        int allSwords = forgetSwordMap
                    .values()
                    .stream()
                    .mapToInt(a -> a)
                    .sum();

        if (allSwords > 0) {
            System.out.printf("You have forged %d swords.%n", allSwords);
        }
        else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQu.isEmpty()) {
            System.out.println("Steel left: none");
        }
        else {
            System.out.print("Steel left: ");

            System.out.println(String.join(", ",
                    steelQu
                            .stream()
                            .map(String::valueOf)
                            .toArray(String[]::new)));
        }

        if (carbonSt.isEmpty()) {
            System.out.println("Carbon left: none");
        }
        else {
            List<Integer> carbonList = new ArrayList<>(carbonSt);
            Collections.reverse(carbonList);

            System.out.println("Carbon left: " + String.join(", ",
                    carbonList
                              .stream()
                              .map(String::valueOf)
                              .toArray(String[]::new)));
        }

        for (Map.Entry<String, Integer> pair : forgetSwordMap.entrySet()) {
            System.out.printf("%s: %s%n", pair.getKey(), pair.getValue());
        }
        scanner.close();
    }
}
