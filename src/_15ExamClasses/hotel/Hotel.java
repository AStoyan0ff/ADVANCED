package _15ExamClasses.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private final String name;
    private final int capacity;
    private final List<Person> rosterList;

    public Hotel(String name, int capacity) {

        this.name = name;
        this.capacity = capacity;
        this.rosterList = new ArrayList<>();
    }

    public void add(Person p) {

        if (rosterList.size() < capacity) {
            rosterList.add(p);
        }
    }

    public boolean remove(String name) {
        return rosterList.removeIf(p -> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {

        return rosterList
                .stream()
                .filter(p ->
               p.getName().equals(name) &&
               p.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return rosterList.size();
    }

    public String getStatistics() {

        StringBuilder buff = new StringBuilder();
        buff.append("The people in the hotel ").append(name).append(" are:\n");

        for (Person p : rosterList) {
            buff.append(p).append("\n");
        }
        return buff.toString().trim();
    }
}
