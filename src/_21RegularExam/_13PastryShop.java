package _21RegularExam;
import java.util.*;
import java.util.stream.Collectors;

public class _13PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> qu = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(qu::offer);

        ArrayDeque<Integer> st = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(st::push);

        Map<Integer, String> foodMap = Map.of(

                25, "Biscuit",
                50, "Cake",
                75, "Pastry",
                100, "Pie"
        );

        Map<String, Integer> foodCnt = new TreeMap<>();
        foodMap.values().forEach(f -> foodCnt.put(f, 0));

        while (!qu.isEmpty() && !st.isEmpty()) {

            int liquid = qu.poll();
            int ingredient = st.pop();
            int result = liquid + ingredient;

            if (foodMap.containsKey(result)) {

                String food = foodMap.get(result);
                foodCnt.put(food, foodCnt.get(food) + 1);
            }
            else {
                st.push(ingredient + 3);
            }
        }

        boolean bLucky = foodCnt.values().stream().allMatch(c -> c > 0);

        System.out.println(bLucky
                ? "Great! You succeeded in cooking all the food!"
                : "What a pity! You didn't have enough materials to cook everything.");

        // format output
        System.out.println(formatOut("Liquids left", qu));
        System.out.println(formatOut("Ingredients left", st));

        // No Map ....
        List<String> orderList = Arrays.asList("Biscuit", "Cake", "Pie", "Pastry");

        for (String food : orderList) {
            int qty = foodCnt.getOrDefault(food, 0);

            System.out.println(food + ": " + qty);
        }
    }

    public static String formatOut(String temp, Collection<Integer> list) {
        if (list.isEmpty()) {

            return temp + ": none";
        }
        else {
            String add = list
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));

            return temp + ": " + add;
        }
    }
}
