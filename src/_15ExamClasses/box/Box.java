package _15ExamClasses.box;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> valuesList;

    public Box() {
        this.valuesList = new ArrayList<>();
    }
    public void add(T value) {
        this.valuesList.add(value);
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        for (T val: this.valuesList) {

            String formatValue = String.format("%s: %s", val.getClass().getName(), val);
            buff.append(formatValue).append(System.lineSeparator());
            //  buff.append(formatValue).append("\n");
        }
        return toString();
    }
}
