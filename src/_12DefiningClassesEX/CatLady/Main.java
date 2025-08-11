package _12DefiningClassesEX.CatLady;


import java.util.*;
import java.util.Scanner;

public class Main {

    static class Cat {
        String breed;
        String name;
        double value;

        public Cat(String breed, String name, double value) {

            this.breed = breed;
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", breed, name, value);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("End")) {
                break;
            }

            String[] input = line.split("\\s+");
            String breed = input[0];
            String name = input[1];
            double value = Double.parseDouble(input[2]);

            cats.put(name, new Cat(breed, name, value));
        }

        String catToShow = scanner.nextLine();
        System.out.println(cats.get(catToShow));
    }
}