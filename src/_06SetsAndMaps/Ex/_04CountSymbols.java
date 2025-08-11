package _06SetsAndMaps.Ex;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> symbolMap = new TreeMap<>();

        for (char c : input.toCharArray()) {
            symbolMap.put(c, symbolMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> pair : symbolMap.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue() + " time/s");
        }
    }
}
