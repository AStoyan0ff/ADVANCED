package _10FunctionalProgramming.Ex;
import java.util.*;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsList = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));

        String input;
        while (!(input = scanner.nextLine()).equals("Party!")) {
            String[] cmd = input.split("\\s+");

            String action = cmd[0];
            String criteria = cmd[1];
            String arg = cmd[2];

            Predicate<String> claimList = getIt(criteria, arg);

            if (action.equals("Remove")) {
                guestsList.removeIf(claimList);
            }
            else if (action.equals("Double")) {

                List<String> matchesList = guestsList
                        .stream()
                        .filter(claimList)
                        .toList();

                guestsList.addAll(matchesList);
            }
        }

        if (guestsList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        }
        else {
            List<String> sortedList = guestsList.stream()
                        .sorted()
                        .collect(Collectors.toList());

            System.out.println(String.join(", ", sortedList) + " are going to the party!");
        }
    }

    private static Predicate<String> getIt(String test, String arg) {
        return switch (test) {

            case "StartsWith" -> name -> name.startsWith(arg);
            case "EndsWith" -> name -> name.endsWith(arg);
            case "Length"     -> name -> name.length() == Integer.parseInt(arg);
            default -> name -> false;
        };
    }
}
