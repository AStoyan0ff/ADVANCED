package _12DefiningClassesEX.PokemonTrainer;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Tournament")) {
            String[] data = input.split("\\s+");

            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            trainerMap.putIfAbsent(trainerName, new Trainer(trainerName));
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainerMap.get(trainerName).addPokemon(pokemon);
        }

        while (!(input = scanner.nextLine()).equals("End")) {
            String element = input;

            for (Trainer trainer : trainerMap.values()) {
                trainer.checkElement(element);
            }
        }

        trainerMap
                .values()
                .stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(trainer -> System.out.printf("%s %d %d%n",
                        trainer.getName(),
                        trainer.getBadges(),
                        trainer.getPokemons().size()));
    }
}
