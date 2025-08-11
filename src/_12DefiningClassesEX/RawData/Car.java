package _12DefiningClassesEX.RawData;

public class Car {

    String model;
    Engine engine;
    Cargo cargo;

    Tire[] tires;

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {

        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public boolean bFragTire() {
        // Сръвнение на "type" с обекта "cargo" в стринга "fragile"  -> t || f
        if (!cargo.type.equals("fragile")) return false;

        for (Tire tire : tires) {
            if (tire.pressure < 1) return true;
        }
        return false;
    }

    public boolean bFlamPower() {
        //Проверка за "type" е точно "flamable" -> товара е фламБЕ =)
        // И "&&" ->  двигателят има мощност > 250;
        return cargo.type.equals("flamable") && engine.power > 250;

        // if (car.bFlamPower()) {
        //    System.out.println(car.model);
        //}
    }
}
