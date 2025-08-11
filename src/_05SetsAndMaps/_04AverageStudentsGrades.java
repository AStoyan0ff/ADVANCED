package _05SetsAndMaps;
import java.util.*;

public class _04AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentMap = new TreeMap<>();

        for (int pos = 0; pos < N; pos++) {
            String [] data = scanner.nextLine().split("\\s+");

            if (data.length != 2) {
                continue;
            }

            String name = data[0];
            double grade;

            try {
                grade = Double.parseDouble(data[1]);

                if (grade < 0 || grade > 6) {
                    throw new NumberFormatException();
                }
            }
            catch (NumberFormatException e) {
                continue;
            }

            studentMap.putIfAbsent(name, new ArrayList<>());
            studentMap.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> pair : studentMap.entrySet()) {

            String name = pair.getKey();
            List<Double> gradeList = pair.getValue();

            System.out.print(name + " -> ");
            double sum = 0d;

            for (double as : gradeList) {

                System.out.printf("%.2f ", as);
                sum += as;
            }

            double avr = sum / gradeList.size();
            System.out.printf("(avg: %.2f)%n", avr);
        }
    }
}
