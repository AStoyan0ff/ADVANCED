package _10FunctionalProgramming.Ex;
import java.util.*;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsList = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
        Map<String, Predicate<String>> filtersMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Print")) {

            String[] partCmd = input.split(";");

            String cmd = partCmd[0];
            String filterType = partCmd[1];
            String filterParam = partCmd[2];

            String value = filterType + ";" + filterParam;

            if (cmd.equals("Add filter")) {
                filtersMap.put(value, getInfo(filterType, filterParam));
            }
            else if (cmd.equals("Remove filter")) {
                filtersMap.remove(value);
            }
        }

        List<String> resList = guestsList
                    .stream()
                    .filter(guest -> filtersMap.values()
                    .stream()
                    .noneMatch(p -> p.test(guest)))
                    .collect(Collectors.toList());

        System.out.println(String.join(" ", resList));
    }
    private static Predicate<String> getInfo(String typeDef, String typeOf) {


        return switch (typeDef) {

            case "Starts with" -> name -> name.startsWith(typeOf);
            case "Ends with" -> name -> name.endsWith(typeOf);
            case "Length" -> name -> name.length() == Integer.parseInt(typeOf);
            case "Contains" -> name -> name.contains(typeOf);

            default -> name -> false;
        };
    }
}
