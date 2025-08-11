package _06SetsAndMaps.Ex;
import java.util.*;
import java.util.Scanner;

public class _11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materialsMap = new HashMap<>();

        materialsMap.put("shards", 0);
        materialsMap.put("fragments", 0);
        materialsMap.put("motes", 0);

        Map<String, Integer> trashMap = new TreeMap<>();

        boolean bLegend = false;
        String getItems = "";

        while (!bLegend) {

            String[] input = scanner.nextLine().toLowerCase().split(" ");

            for (int pos = 0; pos < input.length; pos += 2) {

                int qty = Integer.parseInt(input[pos]);
                String material = input[pos + 1];

                if (materialsMap.containsKey(material)) {
                    materialsMap.put(material, materialsMap.get(material) + qty);

                    if (materialsMap.get(material) >= 250) {
                        materialsMap.put(material, materialsMap.get(material) - 250);

                        getItems = switch (material) {

                            case "shards" -> "Shadowmourne";
                            case "fragments" -> "Valanyr";
                            case "motes" -> "Dragonwrath";
                            default -> getItems;
                        };

                        bLegend = true;
                        break;
                    }
                }
                else {

                    trashMap.putIfAbsent(material, 0);
                    trashMap.put(material, trashMap.get(material) + qty);
                }
            }
        }
        System.out.println(getItems + " obtained!");

        materialsMap
                .entrySet()
                .stream()
                .sorted((a, s) -> {

                    int cmp = Integer.compare(s.getValue(), a.getValue());
                    return cmp != 0 ? cmp : a.getKey().compareTo(s.getKey());
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        for (Map.Entry<String, Integer> entry : trashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
