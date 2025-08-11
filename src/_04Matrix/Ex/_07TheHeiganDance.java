package _04Matrix.Ex;
import java.util.Scanner;

public class _07TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hp = 3_000_000;
        int playerHp = 18500;
        int playerRow = 7;
        int playerCol = 7;

        double dmg = Double.parseDouble(scanner.nextLine());

        boolean hasCloud = false;
        String ofDeath = "";

        while (true) {

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            String spell = parts[0];
            int spellRow = Integer.parseInt(parts[1]);
            int spellCol = Integer.parseInt(parts[2]);

            hp -= dmg;

            if (hasCloud) {

                playerHp -= 3500;
                hasCloud = false;

                if (playerHp <= 0) {
                    ofDeath = "Plague Cloud";
                }
            }

            boolean isDead = hp <= 0;

            if (playerHp <= 0) {
                break;
            }

            boolean isDmg = !isDead && dmgArea(playerRow, playerCol, spellRow, spellCol);

            if (isDmg) {
                if (moveTo(playerRow - 1, playerCol, spellRow, spellCol)) {
                    playerRow--;
                }
                else if (moveTo(playerRow, playerCol + 1, spellRow, spellCol)) {
                    playerCol++;
                }
                else if (moveTo(playerRow + 1, playerCol, spellRow, spellCol)) {
                    playerRow++;
                }
                else if (moveTo(playerRow, playerCol - 1, spellRow, spellCol)) {
                    playerCol--;
                }
                else {
                    if (spell.equals("Cloud")) {

                        playerHp -= 3500;
                        hasCloud = true;

                        if (playerHp <= 0) {
                            ofDeath = "Plague Cloud";
                        }
                    } else {
                        playerHp -= 6000;

                        if (playerHp <= 0) {
                            ofDeath = "Eruption";
                        }
                    }
                }
            }

            if (playerHp <= 0 || isDead) {
                break;
            }
        }

        if (hp <= 0) {
            System.out.println("Heigan: Defeated!");
        }
        else {
            System.out.printf("Heigan: %.2f%n", hp);
        }

        if (playerHp <= 0) {
            System.out.printf("Player: Killed by %s%n", ofDeath);
        }
        else {
            System.out.printf("Player: %d%n", playerHp);
        }

        System.out.printf("Final position: %d, %d%n", playerRow, playerCol);
    }

    private static boolean dmgArea(int row, int col, int spellRow, int spellCol) {

        return row >= spellRow - 1 && row <= spellRow + 1 &&
               col >= spellCol - 1 && col <= spellCol + 1;
    }

    private static boolean moveTo(int row, int col, int spellRow, int spellCol) {

        return row >= 0 && row < 15 &&
               col >= 0 && col < 15 &&
                !dmgArea(row, col, spellRow, spellCol);

    }
}
