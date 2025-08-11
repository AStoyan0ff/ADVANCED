package _12DefiningClassesEX.CarSalesman;

public class Car {

    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {

        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {

        this(model, engine, "n/a", "n/a");
    }

    public Car(String model, Engine engine, String third) {

        this(model, engine,
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
        return String.format("%s:%n%s%nWeight: %s%nColor: %s",
                model, engine.toString(), weight, color);
    }
}
