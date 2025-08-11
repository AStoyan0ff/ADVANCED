package _12DefiningClassesEX.PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {

        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void checkElement(String element) {

        boolean isElement = pokemons
                .stream()
                .anyMatch(p -> p.getElement().equals(element));

        if (isElement) {
            badges++;
        }
        else {
            for (Pokemon p : pokemons) {
                p.decreaseHealth(10);
            }
            pokemons.removeIf(p -> !p.isAlive());
        }
    }
}