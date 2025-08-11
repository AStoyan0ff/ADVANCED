package _12DefiningClassesEX.CarSalesman;

public class Engine {

    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power, String displacement, String efficiency) {

        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this(model, power, "n/a", "n/a");
    }

    public Engine(String model, int power, String third) {

        this(model, power,
                isNumeric(third) ? third : "n/a",
                isNumeric(third) ? "n/a" : third);
    }

    private static boolean isNumeric(String str) {

        try {

            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s",
                model, power, displacement, efficiency);
    }

    public String getModel() {
        return model;
    }
}
