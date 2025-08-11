package _15ExamClasses.workout;
import java.util.ArrayList;
import java.util.List;

public class Workout {

    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {

        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {

        if (this.exercises.size() < exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise e : this.exercises) {

            if (e.getName().equals(name) && e.getMuscle().equals(muscle)) {
                this.exercises.remove(e);

                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise e : exercises) {

            if (e.getName().equals(name) && e.getMuscle().equals(muscle)) {
                return e;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {

        if (this.exercises.isEmpty()) {
            return null;
        }

        Exercise mostBurned = exercises.get(0);

        for (Exercise exercise : exercises) {

            if (exercise.getBurnedCalories() > mostBurned.getBurnedCalories()) {
                mostBurned = exercise;
            }
        }
        return mostBurned;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {

        StringBuilder buff = new StringBuilder();
        buff.append(String.format("Workout type: %s", this.type));

        for (Exercise e : exercises) {

            buff.append(System.lineSeparator());
            buff.append(e.toString());
        }

        return buff.toString();
    }
}
