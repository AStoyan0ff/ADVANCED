package _06SetsAndMaps.Ex;
import java.util.Scanner;
import java.util.*;

public class _09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> dataMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("report")) {

            String [] cmd = input.split("\\|");

            String city = cmd[0];
            String country = cmd[1];
            long people = Long.parseLong(cmd[2]);

            dataMap.putIfAbsent(country, new LinkedHashMap<>());
            dataMap.get(country).put(city, people);
        }

        dataMap // Много зор със Stream API -> Lambda, Трябва да поработя в/у това
                .entrySet()
                .stream()
                .sorted((a, s) -> {

                    long p1 = a
                            .getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::longValue)
                            .sum();

                    long p2 = s
                            .getValue()
                            .values()
                            .stream()
                            .mapToLong(Long::longValue)
                            .sum();

                    return Long.compare(p2, p1);
                })
                .forEach(countryEntry -> {

                    String country = countryEntry.getKey();
                    Map<String, Long> cities = countryEntry.getValue();

                    long totalPopulation = cities
                            .values()
                            .stream()
                            .mapToLong(Long::longValue)
                            .sum();

                    System.out.println(country + " (total population: " + totalPopulation + ")");

                    cities.entrySet()
                            .stream()
                            .sorted((c1, c2) -> Long.compare(c2.getValue(), c1.getValue()))
                            .forEach(cityEntry -> {

                                System.out.println("=>" + cityEntry.getKey() + ": " + cityEntry.getValue());
                            });

                });

    }
}
