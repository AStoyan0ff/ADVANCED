package _06SetsAndMaps.Ex;
import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> venueMap = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("^(.+?) @(\\w+(?: \\w+){0,2}) (\\d+) (\\d+)$");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            Matcher matcher = pattern.matcher(input);

            if (!matcher.matches()) {
                continue;
            }

            String singer = matcher.group(1);
            String venue = matcher.group(2);
            int price = Integer.parseInt(matcher.group(3));
            int cnt = Integer.parseInt(matcher.group(4));

            int revenue = price * cnt;

            venueMap.putIfAbsent(venue, new LinkedHashMap<>());
            Map<String, Integer> singersMap = venueMap.get(venue);

            singersMap.put(singer, singersMap.getOrDefault(singer, 0) + revenue);
        }

        for (Map.Entry<String, Map<String, Integer>> pair : venueMap.entrySet()) {

            String venue = pair.getKey();
            System.out.println(venue);

            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(pair.getValue().entrySet());
            sortedList.sort((a, s) -> s.getValue().compareTo(a.getValue()));

            for (Map.Entry<String, Integer> entry : sortedList) {
                System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
