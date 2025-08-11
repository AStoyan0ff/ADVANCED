package _06SetsAndMaps.Ex;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _13DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, int[]>> dragonsMap = new LinkedHashMap<>();

        for (int pos = 0; pos < n; pos++) {
            String [] cmd = scanner.nextLine().split(" ");

            String type = cmd[0];
            String name = cmd[1];

            int dmg = cmd[2].equals("null") ? 45 : Integer.parseInt(cmd[2]);
            int health = cmd[3].equals("null") ? 250 : Integer.parseInt(cmd[3]);
            int armor = cmd[4].equals("null") ? 10 : Integer.parseInt(cmd[4]);

            dragonsMap.putIfAbsent(type, new TreeMap<>());
            dragonsMap.get(type).put(name, new int[]{dmg, health, armor});
        }
        // Позволява форматиране на числа особено десетични стойности,
        // в текстов вид следвайки определен шаблон.

        //'0'-> винаги трябва да се покаже цифра дори ако е null
        //'.00' -> винаги ще се покажат точно 2 цифри след десетичната точка

        DecimalFormat buffer = new DecimalFormat("0.00");

        for (Map.Entry<String, TreeMap<String, int[]>> pair : dragonsMap.entrySet()) {
            String type = pair.getKey();

            TreeMap<String, int[]> dragonStatus = pair.getValue();

            double totalDamage = 0, totalHealth = 0, totalArmor = 0;

            for (int[] stats : dragonStatus.values()) {

                totalDamage += stats[0];
                totalHealth += stats[1];
                totalArmor += stats[2];
            }
            int count = dragonStatus.size();

            System.out.printf("%s::(%s/%s/%s)%n",
                    type, // !!!
                    buffer.format(totalDamage / count),
                    buffer.format(totalHealth / count),
                    buffer.format(totalArmor / count)
            );

            for (Map.Entry<String, int[]> dragon : dragonStatus.entrySet()) {
                int[] stats = dragon.getValue();

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                        dragon.getKey(), stats[0], stats[1], stats[2]);
            }
        }
    }
}
