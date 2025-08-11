package _06SetsAndMaps.Ex;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebookMap = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("search")) {
                break;
            }

            String[] cmd = input.split("-");

            if (cmd.length == 2) {
                String name = cmd[0];
                String number = cmd[1];

                phonebookMap.put(name, number);
            }
        }

        while (true) {
            String searchName = scanner.nextLine();

            if (searchName.equals("stop")) {
                break;
            }

            if (phonebookMap.containsKey(searchName)) {
                System.out.println
                        (searchName + " -> " + phonebookMap.get(searchName));
            }
            else {
                System.out.println("Contact " + searchName + " does not exist.");
            }
        }
    }
}
