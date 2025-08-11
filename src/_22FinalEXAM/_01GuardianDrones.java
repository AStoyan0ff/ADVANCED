package _22FinalEXAM;
import java.util.*;

public class _01GuardianDrones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> st = new ArrayDeque<>();
        ArrayDeque<Integer> qu = new ArrayDeque<>();

        String[] mechanical = scanner.nextLine().split(" ");
        String[] power = scanner.nextLine().split(" ");

        for (String s : mechanical) {
            st.push(Integer.parseInt(s));
        }

        for (String s : power) {
            qu.offer(Integer.parseInt(s));
        }

        Map<String, Integer> droneMap = new LinkedHashMap<>();

        droneMap.put("Sentinel-X", 100);
        droneMap.put("Viper-MKII", 85);
        droneMap.put("Aegis-7", 75);
        droneMap.put("Striker-R", 65);
        droneMap.put("Titan-Core", 55);

        Set<String> assembledSet = new LinkedHashSet<>();

        while (!st.isEmpty() && !qu.isEmpty() && assembledSet.size() < 5) {
            int part = st.pop();

            while (!qu.isEmpty() && qu.peek() <= 0) {
                qu.poll();
            }

            if (qu.isEmpty()) break;

            int cell = qu.poll();
            int result = part + cell;

            String build = null;

            for (Map.Entry<String, Integer> pair : droneMap.entrySet()) {
                if (assembledSet.contains(pair.getKey())) continue;

                if (pair.getValue() == result) {

                    build = pair.getKey();
                    break;
                }
            }

            if (build == null) {
                int bBetter = -1;

                for (Map.Entry<String, Integer> pair : droneMap.entrySet()) {
                    int mustBe = pair.getValue();

                    if (assembledSet.contains(pair.getKey()))
                        continue;

                    if (mustBe < result && mustBe > bBetter) {
                        bBetter = mustBe;
                        build = pair.getKey();
                    }
                }

                if (build != null) {
                    assembledSet.add(build);

                    int newCell = cell - 30;

                    if (newCell > 0) {
                        qu.offer(newCell);
                    }
                    continue;
                }
            }

            if (build != null) {
                assembledSet.add(build);

            }
            else {

                int newCell = cell - 1;
                if (newCell > 0) {
                    qu.offer(newCell);
                }
            }
        }

        if (assembledSet.size() == 5) {
            System.out.println("Mission Accomplished! All Guardian Drones activated!");
        }
        else {
            System.out.println("Mission Failed! Some drones were not built.");
        }

        if (!assembledSet.isEmpty()) {
            System.out.print("Assembled Drones: ");
            System.out.println(String.join(", ", assembledSet));
        }

        if (!st.isEmpty()) {
            System.out.print("Mechanical Parts: ");

            List<String> partList = new ArrayList<>();

            while (!st.isEmpty()) {
                partList.add(String.valueOf(st.pop()));
            }
            System.out.println(String.join(", ", partList));
        }

        if (!qu.isEmpty()) {
            System.out.print("Power Cells: ");

            List<String> cellsList = new ArrayList<>();

            while (!qu.isEmpty()) {
                cellsList.add(String.valueOf(qu.poll()));
            }
            System.out.println(String.join(", ", cellsList));
        }
    }
}
