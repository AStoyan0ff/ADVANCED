package _09FunctionalProgramming;
import java.util.Scanner;
import java.util.*;

public class _05FilterByAge {
    static class Person {

        String name;
        int age;

        Person(String name, int age) {

            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine().trim());
        List<Person> peopleList = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            String[] cmd = scanner.nextLine().trim().split(",\\s *");

            String name = cmd[0];
            int age = Integer.parseInt(cmd[1]);
            peopleList.add(new Person(name, age));
        }

        String state = scanner.nextLine().trim();
        int ageLimit = Integer.parseInt(scanner.nextLine().trim());
        String format = scanner.nextLine().trim();

        List<Person> filterList = filter(peopleList, state, ageLimit);
        print(filterList, format);
    }

    static List<Person> filter(List<Person> people, String state, int ageLimit) {
        List<Person> resList = new ArrayList<>();

        for (Person p : people) {

            if ("older".equals(state) && p.age >= ageLimit) {
                resList.add(p);
            }
            else if ("younger".equals(state) && p.age <= ageLimit) {
                resList.add(p);
            }
        }

        return resList;
    }

    static void print(List<Person> people, String format) {

        for (Person as : people) {
            switch (format) {

                case "name":
                    System.out.println(as.name);
                    break;

                case "age":
                    System.out.println(as.age);
                    break;

                case "name age":
                    System.out.println(as.name + " - " + as.age);
                    break;
            }
        }
    }
}