package _06SetsAndMaps.Ex;
import java.util.*;

public class _07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playerMS = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("JOKER")) {
                break;
            }

            String [] cmd = input.split(": ");

            String name = cmd[0];
            String [] cards = cmd[1].split(", ");

            playerMS.putIfAbsent(name, new HashSet<>());

            for (String card : cards) {
                playerMS.get(name).add(card);
            }
        }
        for (Map.Entry<String, Set<String>> pair : playerMS.entrySet()) {

            String name = pair.getKey();
            Set<String> cardSet = pair.getValue();

            int total = 0;

            for (String card : cardSet) {
                total += getCards(card);
            }

            System.out.println(name + ": " + total);
        }
    }

    public static int getCards(String card) {
        String powerStr = card.substring(0, card.length() - 1);
        char typeChar = card.charAt(card.length() - 1);

        int power = getPower(powerStr);
        int type = getValues(typeChar);

        return power * type;
    }

    private static int getPower(String power) {

        return switch (power) {

            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            default -> Integer.parseInt(power);
        };
    }

    private static int getValues(char type) {

        return switch (type) {

            case 'S' -> 4;
            case 'H' -> 3;
            case 'D' -> 2;
            case 'C' -> 1;
            default -> 0;
        };
    }
}
