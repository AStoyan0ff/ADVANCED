package _15ExamClasses.parrots;
import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {

        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {

        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : data) {

            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);

                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldList = new ArrayList<>();

        for (Parrot parrot : data) {

            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                soldList.add(parrot);
            }
        }
        return soldList;
    }

    public int count() {
        return data.size();
    }

    public String report() {

        StringBuilder buff = new StringBuilder();
        buff.append("Parrots available at ").append(name).append(":\n");

        for (Parrot parrot : data) {

            if (parrot.isAvailable()) {
                buff.append(parrot).append("\n");
            }
        }
        return buff.toString().trim();
    }
}
