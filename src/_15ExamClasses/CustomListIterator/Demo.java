package _15ExamClasses.CustomListIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private final List<T> elementList = new ArrayList<>();

    public void add(T element) {
        elementList.add(element);
    }

    public T remove(int idx) {
        return elementList.remove(idx);
    }

    public boolean contains(T element) {
        return elementList.contains(element);
    }

    public void swap(int first, int second) {
        Collections.swap(elementList, first, second);
    }

    public int greater(T element) {
        int cnt = 0;

        for (T value : elementList) {

            if (value.compareTo(element) > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public T getMax() {
        return Collections.max(elementList);
    }

    public T getMin() {
        return Collections.min(elementList);
    }

    @Override
    public Iterator<T> iterator() {
        return elementList.iterator();
    }
}

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("END")) {
            String[] data = input.split("\\s+");

            String cmd = data[0];

            switch (cmd) {

                case "Add" ->
                        customList.add(data[1]);

                case "Remove" ->
                        customList.remove(Integer.parseInt(data[1]));

                case "Contains" ->
                        System.out.println(customList.contains(data[1]));

                case "Swap" -> {

                    int a = Integer.parseInt(data[1]);
                    int s = Integer.parseInt(data[2]);
                    customList.swap(a, s);
                }
                case "Greater" ->
                        System.out.println(customList.greater(data[1]));

                case "Max" ->
                        System.out.println(customList.getMax());

                case "Min" ->
                        System.out.println(customList.getMin());

                case "Print" -> {

                    for (String e : customList) {
                        System.out.println(e);
                    }
                }
            }
        }
    }
}
