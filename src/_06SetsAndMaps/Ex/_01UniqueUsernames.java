package _06SetsAndMaps.Ex;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cnt = Integer.parseInt(scanner.nextLine());

        Set<String> nameSet = new LinkedHashSet<>();

        for (int pos = 0; pos < cnt; pos++) {

            String user = scanner.nextLine();
            nameSet.add(user);
        }

        for (String name : nameSet) {
            System.out.println(name);
        }
    }
}
