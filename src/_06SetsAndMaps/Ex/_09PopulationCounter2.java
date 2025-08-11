package _06SetsAndMaps.Ex;
import java.util.Scanner;
import java.util.*;

public class _09PopulationCounter2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> dataMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("report")) {
            String[] parts = input.split("\\|");

            String city = parts[0];
            String country = parts[1];
            long population = Long.parseLong(parts[2]);

            dataMap.putIfAbsent(country, new LinkedHashMap<>());
            dataMap.get(country).put(city, population);
        }

        List<Map.Entry<String, LinkedHashMap<String, Long>>> countries = new ArrayList<>(dataMap.entrySet());

        Collections.sort(countries, new Comparator<Map.Entry<String, LinkedHashMap<String, Long>>>() {

            @Override
            public int compare(Map.Entry<String, LinkedHashMap<String, Long>> e1,
                               Map.Entry<String, LinkedHashMap<String, Long>> e2) {

                long totalPop1 = 0;

                for (long pop : e1.getValue().values()) {
                    totalPop1 += pop;
                }

                long totalPop2 = 0;

                for (long pop : e2.getValue().values()) {
                    totalPop2 += pop;
                }

                return Long.compare(totalPop2, totalPop1);
            }
        });

        for (Map.Entry<String, LinkedHashMap<String, Long>> countryEntry : countries) {
            String country = countryEntry.getKey();

            LinkedHashMap<String, Long> cities = countryEntry.getValue();

            long totalPopulation = 0;

            for (long pop : cities.values()) {
                totalPopulation += pop;
            }

            System.out.println(country + " (total population: " + totalPopulation + ")");

            List<Map.Entry<String, Long>> cityList = new ArrayList<>(cities.entrySet());

            Collections.sort(cityList, new Comparator<Map.Entry<String, Long>>() {

                @Override
                public int compare(Map.Entry<String, Long> c1, Map.Entry<String, Long> c2) {
                    return Long.compare(c2.getValue(), c1.getValue());
                }
            });

            for (Map.Entry<String, Long> cityEntry : cityList) {
                System.out.println("=>" + cityEntry.getKey() + ": " + cityEntry.getValue());
            }
        }
    }
}
