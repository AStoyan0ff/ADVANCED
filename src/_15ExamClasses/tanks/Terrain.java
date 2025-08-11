package _15ExamClasses.tanks;

import java.util.ArrayList;
import java.util.List;

public class Terrain {
    private String type;
    private List<Tank> tanks;
    private int area;

    public Terrain(String type, int area) {

        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>();
    }

    public String addTank(Tank tank) {

        for (Tank t : tanks) {

            if (t.getBrand().equals(tank.getBrand()) && t.getModel().equals(tank.getModel())) {
                return "Tank with this brand and model already exists!";
            }
        }


        if (type.equals("Swamp") && tank.getWeight() > 14000) {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        }

        tanks.add(tank);
        return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
    }

    public boolean removeTank(String brand, String model) {
        for (Tank tank : tanks) {

            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {
                tanks.remove(tank);

                return true;
            }
        }
        return false;
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        List<String> matchingTanks = new ArrayList<>();

        for (Tank tank : tanks) {

            if (tank.getBarrelCaliber() > barrelCaliber) {
                matchingTanks.add(tank.getBrand());
            }
        }

        if (matchingTanks.isEmpty()) {
            return "There are no _15ExamClasses.tanks with the specified caliber.";
        }

        return String.format("Tanks with caliber more than %dmm: %s",
                barrelCaliber, String.join(", ", matchingTanks));
    }

    public Tank getTankByBrandAndModel(String brand, String model) {

        for (Tank tank : tanks) {
            if (tank.getBrand().equals(brand) && tank.getModel().equals(model)) {

                return tank;
            }
        }
        return null;
    }

    public String getTheMostArmoredTank() {

        if (tanks.isEmpty()) {
            return null;
        }

        Tank mostArmored = tanks.get(0);

        for (Tank tank : tanks) {

            if (tank.getArmor() > mostArmored.getArmor()) {
                mostArmored = tank;
            }
        }

        return String.format("%s %s is the most armored tank with %dmm. armor thickness.",
                mostArmored.getBrand(), mostArmored.getModel(), mostArmored.getArmor());
    }

    public int getCount() {
        return tanks.size();
    }

    public String getStatistics() {
        if (tanks.isEmpty()) {
            return String.format("There are no _15ExamClasses.tanks in the %s.", type.toLowerCase());
        }

        StringBuilder buff = new StringBuilder();
        buff.append(String.format("Tanks located in the %s:", type.toLowerCase()));

        for (Tank tank : tanks) {
            buff.append("\n-- ").append(tank.getBrand()).append(" ").append(tank.getModel());
        }

        return buff.toString();
    }
}