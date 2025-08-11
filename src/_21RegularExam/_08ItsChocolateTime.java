package _21RegularExam;
import java.util.*;

public class _08ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQu = new ArrayDeque<>();
        ArrayDeque<Double> cacaoSt = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(milkQu::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoSt::push);

        Map<String, Integer> chokoMap = new TreeMap<>();

        while (!milkQu.isEmpty() && !cacaoSt.isEmpty()) {

            double milk = milkQu.poll();
            double cacao = cacaoSt.pop();

            double total = milk + cacao;
            double percent = (cacao / total) * 100;

            if (percent == 30) {
                chokoMap.put("Milk Chocolate", chokoMap.getOrDefault("Milk Chocolate", 0) + 1);
            }
            else if (percent == 50) {
                chokoMap.put("Dark Chocolate", chokoMap.getOrDefault("Dark Chocolate", 0) + 1);
            }
            else if (percent == 100) {
                chokoMap.put("Baking Chocolate", chokoMap.getOrDefault("Baking Chocolate", 0) + 1);
            }
            else {
                milk += 10;
                milkQu.offer(milk);
            }
        }

        if (chokoMap.keySet().containsAll(Arrays.asList("Milk Chocolate", "Dark Chocolate", "Baking Chocolate"))) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }       // 42 / 100 заради апострофа....
        else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chokoMap.forEach((T, cnt) -> {

            if (cnt > 0) {
                System.out.printf("# %s --> %s%n", T, cnt);
            }
        });
    }
}
