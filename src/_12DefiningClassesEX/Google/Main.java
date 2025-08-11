package _12DefiningClassesEX.Google;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> peopleMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String [] cmd = input.split("\\s+");

            String name = cmd[0];
            String type = cmd[1];

            peopleMap.putIfAbsent(name, new Person(name));
            Person person = peopleMap.get(name);

            switch (type) {

                case "company":

                    String compName = cmd[2];
                    String department = cmd[3];
                    double salary = Double.parseDouble(cmd[4]);

                    person.setCompany(new Company(compName, department, salary));
                    break;

                case "car":

                    String carModel = cmd[2];
                    int carSpeed = Integer.parseInt(cmd[3]);

                    person.setCar(new Car(carModel, carSpeed));
                    break;

                case "pokemon":

                    String pokName = cmd[2];
                    String pokType = cmd[3];

                    person.addPokemon(new Pokemon(pokName, pokType));
                    break;

                case "parents":

                    String parName = cmd[2];
                    String parBirthday = cmd[3];

                    person.addParent(new Parent(parName, parBirthday));
                    break;

                case "children":

                    String chName = cmd[2];
                    String chBirthday = cmd[3];

                    person.addChild(new Child(chName, chBirthday));
                    break;
            }
        }

        String object = scanner.nextLine();

        if (peopleMap.containsKey(object)) {
            System.out.println(peopleMap.get(object));
        }
    }
}
