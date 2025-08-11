package _15ExamClasses.hotel; // 23 October 2021

public class Main {
    public static void main(String[] args) {

        Hotel hotel = new Hotel("Hilton", 30);
        Person person = new Person("Mark", 11111, 41, "Sofia");

        hotel.add(person);
        System.out.println(person);

        System.out.println(hotel.getCount());
        System.out.println(hotel.remove("Anna"));

        hotel.add(new Person("Alice", 22121, 18, "London"));
        hotel.add(new Person("Lizzy", 31311, 24, "Varna"));
        hotel.add(new Person("Lucy", 54122, 31, "Birmingham"));
        hotel.add(new Person("Maria", 66611, 41, "Sofia"));

        System.out.println(hotel.getPerson("Lucy", "Birmingham"));
        System.out.println(hotel.getPerson("Anna", "Burgas"));

        System.out.println(hotel.getCount());
        System.out.println(hotel.remove("Alice"));
        System.out.println(hotel.getStatistics());
    }
}
