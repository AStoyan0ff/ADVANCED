package _02StackQueues.Ex;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");
        LinkedHashMap<String, Integer> robots = getLinkedHashMap(input);
        String time = scanner.nextLine();

        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);

        long totalTime = hours * 3600L + minutes * 60L + seconds;

        ArrayDeque<String> qu = new ArrayDeque<>();

        int [] workingTime = new int[robots.size()];

        String product = scanner.nextLine();
        while (!product.equals("End")) {

            qu.offer(product);
            product = scanner.nextLine();
        }

        while(!qu.isEmpty()){

            String currentProduct = qu.poll();
            totalTime++;
            boolean isAssigned = false;

            for (int as = 0; as < workingTime.length; as++) {

                if(workingTime[as] > 0) {
                    --workingTime[as];
                }
            }

            for (int i = 0; i < workingTime.length; i++) {
                if(workingTime[i] == 0) {

                    int count = 0;

                    for (Map.Entry<String, Integer> robot : robots.entrySet()){

                        if (count == i) {

                            workingTime[i] = robot.getValue();

                            long takenHour =  totalTime / 3600 % 24;
                            long takenMinute = totalTime % 3600 / 60;
                            long takenSeconds = totalTime % 60;

                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct, takenHour, takenMinute, takenSeconds);
                            isAssigned =  true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }

            if(!isAssigned) {
                qu.offer(currentProduct);
            }

        }
    }

    private static LinkedHashMap<String, Integer> getLinkedHashMap(String[] inputRobot) {
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();

        for (String s : inputRobot) {

            String name = s.split("-")[0];
            int time = Integer.parseInt(s.split("-")[1]);
            robots.put(name, time);
        }
        return robots;
    }
}
