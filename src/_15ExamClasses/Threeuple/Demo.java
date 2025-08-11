package _15ExamClasses.Threeuple;
import java.util.Scanner;

class Threeuple<T1, T2, T3> {

    private T1 first;
    private T2 second;
    private T3 third;

    public Threeuple(T1 first, T2 second, T3 third) {

        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public T3 getThird() {
        return third;
    }

    public void setThird(T3 third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return first + " -> " + second + " -> " + third;
    }
}

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\s+");

        String person = firstInput[0] + " " + firstInput[1];
        String address = firstInput[2];
        String town = firstInput[3];

        Threeuple<String, String, String> one = new Threeuple<>(person, address, town);

        String[] secondInput = scanner.nextLine().split("\\s+");

        String name = secondInput[0];
        int liters = Integer.parseInt(secondInput[1]);
        boolean bDrink = secondInput[2].equalsIgnoreCase("drunk");

        Threeuple<String, Integer, Boolean> two = new Threeuple<>(name, liters, bDrink);

        String[] thirdInput = scanner.nextLine().split("\\s+");

        String accName = thirdInput[0];
        double balance = Double.parseDouble(thirdInput[1]);
        String bank = thirdInput[2];

        Threeuple<String, Double, String> three = new Threeuple<>(accName, balance, bank);

        print(one);
        print(two);
        print(three);
    }

    public static void print(Threeuple<?, ?, ?> tuple) {
        System.out.println(tuple.getFirst() + " -> " + tuple.getSecond() + " -> " + tuple.getThird());
    }
}
