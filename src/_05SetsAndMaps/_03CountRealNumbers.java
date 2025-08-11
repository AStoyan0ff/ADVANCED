package _05SetsAndMaps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> realMap = new LinkedHashMap<>();

        String [] input = scanner.nextLine().split("\\s+");

        for (String N : input) {

            double curr = Double.parseDouble(N);
            realMap.put(curr, realMap.getOrDefault(curr, 0) + 1);
        }

        realMap.forEach((key, value) ->
                System.out.printf("%.1f -> %d%n", key, value)
        );

        /*for (Map.Entry<Double, Integer> pair : realMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", pair.getKey(), pair.getValue());
        }*/
    }
}
