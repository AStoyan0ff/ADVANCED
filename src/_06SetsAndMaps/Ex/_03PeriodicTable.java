package _06SetsAndMaps.Ex;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        Set<String> elementSet = new TreeSet<>();

        for (int pos = 0; pos < input; pos++) {

            String data = scanner.nextLine();
            String[] cmd = data.split("\\s+");

            for (String el : cmd) {
                elementSet.add(el);
            }
        }

        for (String e : elementSet) {
            System.out.print(e + " ");
        }
    }
}
