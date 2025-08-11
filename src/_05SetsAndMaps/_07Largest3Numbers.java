package _05SetsAndMaps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _07Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(" ");
        List<Integer> numbersList = new ArrayList<>();

        for (String data : input) {
            numbersList.add(Integer.parseInt(data));
        }

        numbersList.sort(Collections.reverseOrder());

        for (int pos = 0; pos < Math.min(3, numbersList.size()); pos++) {
            System.out.print(numbersList.get(pos) + " ");
        }
    }
}
