package _06SetsAndMaps.Ex;
import java.util.*;

public class _10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> valueMap = new TreeMap<>();
        Map<String, Set<String>> ipMap = new TreeMap<>();

        for (int pos = 0; pos < N; pos++) {
            String [] data = scanner.nextLine().split(" ");

            String ip = data[0];
            String user = data[1];
            int value = Integer.parseInt(data[2]);

            valueMap.put(user, valueMap.getOrDefault(user, 0) + value);

            ipMap.putIfAbsent(user, new TreeSet<>());
            ipMap.get(user).add(ip);
        }

        for (String as : valueMap.keySet()) {
            int total = valueMap.get(as);

            Set<String> ipS = ipMap.get(as);
            System.out.println(as + ": " + total + " " + ipS);
        }
    }
}
