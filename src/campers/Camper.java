package campers;

public class Camper {

    private String name;
    private int age;
    private int experienceLevel;
    private Boolean hasTent;
    private int budget;

    public Camper(String name, int age, int experienceLevel, Boolean hasTent, int budget) {

        this.name = name;
        this.age = age;
        this.experienceLevel = experienceLevel;
        this.hasTent = hasTent;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public Boolean getHasTent() {
        return hasTent;
    }

    public int getBudget() {
        return budget;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public void setHasTent(Boolean hasTent) {
        this.hasTent = hasTent;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return String.format("Camper %s is %d years old with %d camping trips.",
                name, age, experienceLevel);
    }
}
