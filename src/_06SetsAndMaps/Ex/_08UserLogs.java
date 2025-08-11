package _06SetsAndMaps.Ex;
import java.util.*;

public class _08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> userLogIn = new TreeMap<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] cmd = input.split(" ");

            String ip = cmd[0].substring(3);
            String user = cmd[2].substring(5);

            userLogIn.putIfAbsent(user, new LinkedHashMap<>());

            Map<String, Integer> allIPs = userLogIn.get(user);
            allIPs.put(ip, allIPs.getOrDefault(ip, 0) + 1);
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> userPair : userLogIn.entrySet()) {
            System.out.println(userPair.getKey() + ":");

            LinkedHashMap<String, Integer> ipData = userPair.getValue();

            List<String> outList = new ArrayList<>();

            for (Map.Entry<String, Integer> ipPair : ipData.entrySet()) {
                outList.add(ipPair.getKey() + " => " + ipPair.getValue());
            }

            System.out.println(String.join(", ", outList) + ".");
        }
        System.out.println();
    }
}
