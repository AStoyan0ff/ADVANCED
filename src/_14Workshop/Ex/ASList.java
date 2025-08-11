package _14Workshop.Ex;

public class ASList {

     int value;
     ASList prev;
     ASList next;

    public ASList(int value, ASList prev, ASList next) {

        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
