package _05SetsAndMaps;
import java.util.TreeMap;
import java.util.Map;
import java.util.Scanner;

public class _06AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        Map<String, Double> studentsMap = new TreeMap<>();

        for (int pos = 0; pos < input; pos++) {
            String name =  scanner.nextLine();

            String [] data = scanner.nextLine().split("\\s+");

            double result = 0f;

            for (String curr : data) {
                result += Double.parseDouble(curr);
            }

            double avg = result / data.length;
            studentsMap.put(name, avg);
        }

        for (Map.Entry<String, Double> pair : studentsMap.entrySet()) {
            System.out.println(pair.getKey() + " is graduated with " + pair.getValue());
        }
    }
}
