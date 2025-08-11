package _15ExamClasses.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CustomList<T extends Comparable<T>> {

    private List<T> elementList = new ArrayList<>();

    public void add(T element) {
        elementList.add(element);
    }

    public T remove(int idx) {
        return elementList.remove(idx);
    }

    public boolean contains(T element) {
        return elementList.contains(element);
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

    public void print() {

        for (T value : elementList) {
            System.out.println(value);
        }
    }

    public void swap(int first, int second) {
        Collections.swap(elementList, first, second);
    }

   /* public void swap(int first, int second) {

        T firstValue = elementList.get(first);
        T secondValue = elementList.get(second);

        this.elementList.set(first, secondValue);
        this.elementList.set(second, firstValue);
    }*/
}
