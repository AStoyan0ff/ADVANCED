package _12DefiningClassesEX.FamilyTree;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String obj = scanner.nextLine();

        Map<String, Person> nameMap = new LinkedHashMap<>();
        Map<String, Person> bDayMap = new LinkedHashMap<>();

        List<String> relationList = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {

            if (input.contains(" - ")) {
                relationList.add(input);
            }
            else {
                String[] data = input.split("\\s+");

                String name = data[0] + " " + data[1];
                String birthday = data[2];

                Person personName = nameMap.getOrDefault(name, new Person(name, null));

                personName.setBirthday(birthday);
                nameMap.put(name, personName);
                bDayMap.put(birthday, personName);

                Person bBirthday = bDayMap.getOrDefault(birthday, personName);

                bBirthday.setName(name);
                bBirthday.setBirthday(birthday);

                bDayMap.put(birthday, bBirthday);
                nameMap.put(name, bBirthday);
            }
        }

        for (String r : relationList) {

            String [] data = r.split(" - ");
            String pData = data[0];
            String chData = data[1];

            Person parent = getPersons(pData, nameMap, bDayMap);
            Person child = getPersons(chData, nameMap, bDayMap);

            parent.addChild(child);
            child.addParent(parent);
        }

        Person object = getPersons(obj, nameMap, bDayMap);

        System.out.println(object);
        System.out.println("Parents:");

        for (Person parent : object.getParentsList()) {
            System.out.println(parent);
        }
        System.out.println("Children:");

        for (Person ch : object.getChildrenList()) {
            System.out.println(ch);
        }
    }

    private static Person getPersons(String input,
                   Map<String, Person> peopleName,
                   Map<String, Person> peopleDay) {


        if (input.contains("/")) {
            peopleDay.putIfAbsent(input, new Person(null, input));
            return peopleDay.get(input);
        }
        else {
            peopleName.putIfAbsent(input, new Person(input, null));
            return peopleName.get(input);
        }
    }
}
