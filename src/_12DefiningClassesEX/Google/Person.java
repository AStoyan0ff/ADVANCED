package _12DefiningClassesEX.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;

    private List<Pokemon> pokemonList;
    private List<Parent> parentList;
    private List<Child> childList;

    public Person(String name) {

        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parentList.add(parent);
    }

    public void addChild(Child child) {
        this.childList.add(child);
    }

    @Override
    public String toString() {

        StringBuilder buff = new StringBuilder(name + "\n");

        buff.append("Company:\n");
        if (company != null) buff.append(company).append("\n");

        buff.append("Car:\n");
        if (car != null) buff.append(car).append("\n");

        buff.append("Pokemon:\n");
        for (Pokemon pokemon : pokemonList) buff.append(pokemon).append("\n");

        buff.append("Parents:\n");
        for (Parent parent : parentList) buff.append(parent).append("\n");

        buff.append("Children:\n");
        for (Child ch : childList) buff.append(ch).append("\n");

        return buff.toString().trim();

    }
}
