package _06SetsAndMaps.Ex;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emailMap = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("stop")) {
                break;
            }

            String email = scanner.nextLine();

            if (email.equalsIgnoreCase("stop")) {
                break;
            }

            String domain = email.substring(email.lastIndexOf('.') + 1).toLowerCase();

            if (!(domain.equals("us") || domain.equals("uk") || domain.equals("com"))) {
                emailMap.put(name, email);
            }
        }

        emailMap.forEach((name, email) -> System.out.println(name + " -> " + email));
    }
}
