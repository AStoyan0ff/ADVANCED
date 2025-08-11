package _13Workshop.Integer;

import java.util.function.Consumer;

public class SmartArray {

    private int[] data; // съхраняваме всички цели числа
    private int size; //размера
    private int capacity; // максималния брой числа

    public SmartArray() {

        this.size = 0;
        this.capacity = 4;
        this.data = new int[this.capacity];
    }

    public void add(int element) {

        if (this.size == this.capacity) {
            increaseCapacity();
        }

        this.data[size] = element;
        this.size++;
    }

    private void increaseCapacity() {

        this.capacity *= 2;
        int [] temp = new int[this.capacity];

        for (int pos = 0; pos <= this.data.length -1; pos++) {
            temp[pos] = this.data[pos];
        }
        this.data = temp;
    }

    public int get(int idx) {

        bValidate(idx);
        return this.data[idx];
    }

    private void bValidate(int idx) {

        if (idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    public int remove(int idx) {

        bValidate(idx);
        int removedElement = this.data[idx];

        for (int pos = idx; pos < this.size - 1; pos++) {
            this.data[pos] = this.data[pos + 1]; // преместваме позицията с 1 на ляво
        }
        this.data[this.size - 1] = 0;
        this.size--;


        return removedElement;
    }

    public boolean contains(int element) {
        for (int curr : this.data) {

            if (curr == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int element, int idx) {

        if (this.size == this.capacity || this.size == this.capacity - 1) {
            increaseCapacity();
        }
        for (int currPos = this.size - 1; currPos >= idx ; currPos--) {
            this.data[currPos + 1] = this.data[currPos]; // измествам индекса с 1 на дясно
        }

        this.data[idx] = element;
        this.size++;
    }

    public void forEach(Consumer<Integer> consumer) {

        for (int pos = 0; pos <= this.size -1; pos ++) {

            int currElement = this.data[pos];
            consumer.accept(currElement);
        }
    }
}


