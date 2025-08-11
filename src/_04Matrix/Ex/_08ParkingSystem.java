package _04Matrix.Ex;
import java.util.*;

public class _08ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int R = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.nextLine();

        Map<Integer, Set<Integer>> parking = new HashMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("stop")) {
                break;
            }

            String[] data = line.split("\\s+");

            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int car = Integer.parseInt(data[2]);

            parking.putIfAbsent(col, new HashSet<>());

            if (!parking.get(col).contains(car)) {

                parking.get(col).add(car);
                int distance = Math.abs(row - col) + car + 1;

                System.out.println(distance);
            }
            else {

                int distance = -1;
                int closestCol = -1;

                for (int d = 1; d < C; d++) {

                    int left = car - d;
                    int right = car + d;

                    if (left > 0 && !parking.get(col).contains(left)) {
                        closestCol = left;
                        break;
                    }
                    if (right < C && !parking.get(col).contains(right)) {
                        closestCol = right;
                        break;
                    }
                }

                if (closestCol == -1) {
                    System.out.printf("Row %d full%n", col);
                }
                else {
                    parking.get(col).add(closestCol);
                    distance = Math.abs(row - col) + closestCol + 1;

                    System.out.println(distance);
                }
            }
        }
    }
}
