package _15ExamClasses.CustomList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<String>();

        String input;
        while (!(input = scanner.nextLine()).equals("END")) {
            String[] data = input.split("\\s+");

            String cmd = data[0];
            switch (cmd) {

                case "Add":
                    customList.add(data[1]);
                    break;

                case "Remove":
                    customList.remove(Integer.parseInt(data[1]));
                    break;

                case "Contains":
                    System.out.println(customList.contains(data[1]));
                    break;

                case "Swap":
                    int firstIdx = Integer.parseInt(data[1]);
                    int secondIdx = Integer.parseInt(data[2]);
                    customList.swap(firstIdx, secondIdx);
                    break;

                case "Greater":
                    System.out.println(customList.greater(data[1]));
                    break;

                case "Max":
                    System.out.println(customList.getMax());
                    break;

                case "Min":
                    System.out.println(customList.getMin());
                    break;

                case "Print":
                    customList.print();
                    break;
            }
        }
        scanner.close();
    }
}
