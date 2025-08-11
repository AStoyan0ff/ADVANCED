package campers;

import java.util.ArrayList;
import java.util.List;

public class Campsite {

    private String name;
    private int availableTents;
    private List<Camper> campers;

    public Campsite(String name, int availableTents) {

        this.name = name;
        this.availableTents = availableTents;
        this.campers = new ArrayList<>();
    }

    public String addCamper(Camper camper) {
        if (camper.getHasTent()) {

            campers.add(camper);
            return String.format("Camper %s joined the campsite.", camper.getName());
        }
        else {

            if (camper.getBudget() < 30) {
                return String.format("%s cannot afford to rent a tent.", camper.getName());
            }
            if (availableTents <= 0) {
                return String.format("No available tents at %s.", name);
            }
            campers.add(camper);
            availableTents--;

            return String.format("Camper %s joined the campsite.", camper.getName());
        }
    }

    public boolean removeCamper(String name) {
        for (Camper camper : campers) {

            if (camper.getName().equals(name)) {
                campers.remove(camper);
                return true;
            }
        }
        return false;
    }

    public String getMostExperiencedCamper() {

        if (campers.isEmpty()) {
            return String.format("There are no campers at %s.", name);
        }

        Camper mostExperienced = campers.get(0);

        for (Camper camper : campers) {

            if (camper.getExperienceLevel() > mostExperienced.getExperienceLevel()) {
                mostExperienced = camper;
            }
        }

        return String.format("%s has the most camping experience with %d trips.",
                mostExperienced.getName(), mostExperienced.getExperienceLevel());
    }

    public Camper getCamper(String name) {
        for (Camper camper : campers) {

            if (camper.getName().equals(name)) {
                return camper;
            }
        }
        return null;
    }

    public int getCount() {
        return campers.size();
    }

    public String getCampersWithPersonalTents() {

        if (campers.isEmpty()) {
            return String.format("No campers currently at %s.", name);
        }

        List<String> names = new ArrayList<>();

        for (Camper camper : campers) {

            if (camper.getHasTent()) {
                names.add(camper.getName());
            }
        }

        if (names.isEmpty()) {
            return String.format("No campers currently at %s.", name);
        }

        return "Campers with their own tents: " + String.join(", ", names);
    }

    public String getReport() {

        if (campers.isEmpty()) {
            return String.format("There are no campers at %s.", name);
        }

        StringBuilder buff = new StringBuilder(String.format("Campsite %s hosts the following campers:", name));

        for (int pos = 0; pos < campers.size(); pos++) {
            Camper camper = campers.get(pos);

            buff.append(String.format("%n%d. %s with %d camping trips.",
                    pos + 1, camper.getName(), camper.getExperienceLevel()));
        }

        return buff.toString();
    }
}
