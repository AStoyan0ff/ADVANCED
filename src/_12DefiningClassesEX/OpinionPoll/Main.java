package _12DefiningClassesEX.OpinionPoll;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        List<Person> peopleList = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            peopleList.add(new Person(name, age));
        }

        peopleList
                .stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
