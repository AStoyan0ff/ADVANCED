package _06SetsAndMaps.Ex;
import java.util.*;

public class _02SetsElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 80/100

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();

        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        List<Integer> inputList = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            int number = Integer.parseInt(scanner.nextLine());

            firstSet.add(number);
            inputList.add(number);
        }

        for (int pos = 0; pos < M; pos++) {
            int number = Integer.parseInt(scanner.nextLine());

            secondSet.add(number);
            inputList.add(number);
        }

        Set<Integer> printSet = new HashSet<>();

        for (int number : inputList) {

            if (firstSet.contains(number) &&
                    secondSet.contains(number) &&
                    !printSet.contains(number)) {

                System.out.print(number + " ");
                printSet.add(number);
            }
        }
    }
}
