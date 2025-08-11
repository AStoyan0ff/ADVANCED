package _15ExamClasses.Tuple;
import java.util.*;

class Tuple<T1, T2> {

    private T1 firstE;
    private T2 secondE;

    public Tuple(T1 first, T2 second) {

        this.firstE = first;
        this.secondE = second;
    }

    public T1 getFirstE() {
        return firstE;
    }

    public void setFirstE(T1 firstE) {
        this.firstE = firstE;
    }

    public T2 getSecondE() {
        return secondE;
    }

    public void setSecondE(T2 secondE) {
        this.secondE = secondE;
    }

    @Override
    public String toString() {
        return firstE + " -> " + secondE;
    }
}

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] first = scanner.nextLine().split("\\s+");

        String person = first[0] + " " + first[1];
        String address = first[2];

        Tuple<String, String> tupleFirst = new Tuple<>(person, address);
        String[] second = scanner.nextLine().split("\\s+");

        String name = second[0];
        int liters = Integer.parseInt(second[1]);

        Tuple<String, Integer> tupleSecond = new Tuple<>(name, liters);
        String[] third = scanner.nextLine().split("\\s+");

        int N = Integer.parseInt(third[0]);
        double decimal = Double.parseDouble(third[1]);

        Tuple<Integer, Double> tupleThird = new Tuple<>(N, decimal);

        System.out.println(tupleFirst);
        System.out.println(tupleSecond);
        System.out.println(tupleThird);
    }
}