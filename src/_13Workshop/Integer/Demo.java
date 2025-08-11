package _13Workshop.Integer;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartArray smartArray = new SmartArray();

        smartArray.add(3);
        smartArray.remove(10);
        smartArray.forEach(e -> System.out.println(e + " "));
    }
}


