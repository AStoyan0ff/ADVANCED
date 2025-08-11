package _14Workshop.Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomLinkedList {

    private ASList head;
    private ASList tail;
    private int size;

    public void addFirst(int element) {

        if (this.isEmpty()) {
            addIfEmpty(element);
        }
        else {
            ASList newASList = new ASList(element, null, this.head);
            this.head.prev = newASList;
            this.head = newASList;
        }
    }

    private void addIfEmpty(int element) {
        ASList newASList = new ASList(element, null, null);

        this.head = newASList;
        this.tail = newASList;
    }

    public boolean isEmpty() { // метод дали листа е празен
        return this.size == 0;
    }

    public int get(int idx) {

        if (!isValidIdx(idx)) {
            throw new IndexOutOfBoundsException("Invalid!");
            // ако не е валидиран -> хвърля Ексепшън
        }

        ASList currElement = this.head;

        for (int pos = 0; pos < idx; pos++) {
            currElement = currElement.next;
        }
        return currElement.value;
    }

    private boolean isValidIdx(int idx) { // Метод за Валидиране на индекс
        return idx >= 0 && idx < this.size;
    }

    public int removeFirst() { // Метод за премахване на първия индекс

        if (this.isEmpty()) {
            throw new NoSuchElementException("Error!");
        }
        int res = this.head.value;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return res;
    }

    public int removeLast() { // метод за премахване на последен индекс

        if (this.isEmpty()) {
            throw new NoSuchElementException("Error!");
        }

        int res = this.tail.value;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        }
        else {

            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return res;
    }

    public void forEach(Consumer<Integer> consumer) {

        ASList currElement = this.head;

        while (currElement != null) {

            consumer.accept(currElement.value);
            currElement = currElement.next;
        }
    }

    private int[] toArray() {

        List<Integer> numberList = new ArrayList<>();
        this.forEach(numberList::add);

        return numberList
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
