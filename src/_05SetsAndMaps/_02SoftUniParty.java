package _05SetsAndMaps;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guestVip = new TreeSet<>();
        Set<String> guestRegular = new TreeSet<>();

        String input;
        while (!(input = scanner.nextLine()).equals("PARTY")) {

            if (Character.isDigit(input.charAt(0))) {
                guestVip.add(input);
            }
            else {
                guestRegular.add(input);
            }
        }

        while (!input.equals("END")) {

            guestVip.remove(input);
            guestRegular.remove(input);

            input = scanner.nextLine();
        }

        System.out.println(guestVip.size() + guestRegular.size());

        guestVip.forEach(System.out::println);
        guestRegular.forEach(System.out::println);

    }
}
