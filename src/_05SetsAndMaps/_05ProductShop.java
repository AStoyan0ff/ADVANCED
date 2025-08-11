package _05SetsAndMaps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _05ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopMaps = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Revision")) {
                break;
            }

            String [] data = input.split(",\\s*");

            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            shopMaps.putIfAbsent(shop, new LinkedHashMap<>());
            shopMaps.get(shop).put(product, price);
        }
        /*shopMaps.keySet();

        for (String key : shopMaps.keySet()) {
            System.out.println(key + "->" + shopMaps.get(key));
        }*/

        for (Map.Entry<String, Map<String, Double>> shopPair : shopMaps.entrySet()) {

            System.out.println(shopPair.getKey() + "->");

            for (Map.Entry<String, Double> productPair : shopPair.getValue().entrySet()) {

                System.out.printf("Product: %s, Price: %.1f%n",
                        productPair.getKey(),
                        productPair.getValue());
            }
        }
    }
}
