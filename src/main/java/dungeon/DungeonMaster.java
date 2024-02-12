package dungeon;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;

/**
 * Director for all actions in the dungeon.
 */
public class DungeonMaster {
    int dungeonLevel;

    // player stats (atk, def, hp, luck, energy, speed)

    // monster stats (atk, def, hp, speed)

    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    // Each floor has one fight and a chance to find some loot or a shop

    public void runDungeon() {
        runWelcomeDungeonCycle();

        // run cycle 2 (BOSS) - BEHOLDER
        // run cycle 3
        // run cycle 4 (FINAL BOSS) - DRAGON

    }

    /**
     * Simulates rolling a D20!
     * @return result of the dice roll
     */
    private int rollD20() {

        Random random = new Random();
        return random.nextInt(20) + 1;
    }





    /**
     * TODO: Implement actual functionality
     */
    private void runWelcomeDungeonCycle() {

        int level = 1;

        System.out.println("Apply cycle effect");

        while (level <= 5) {

            // if level == 5, we fight a medium monster
            if (level == 5) {
                System.out.println("Fight a medium monster!");
                System.out.println("Gain more XP");
                System.out.println("Have a larger chance to find loot");

                // Chance to find the shopkeeper or loot lying around
                int result = rollD20();

                if(result > 15) {
                    System.out.println("The Shopkeeper appears!");

                } else if (result > 10) {
                    System.out.println("The monster leaves behind some loot!");

                }

                System.out.println("Want to take a long rest? You have X/3 remaining");
                level++;
                dungeonLevel++;

            } else {
                System.out.println("Fight a small monster!");
                System.out.println("Gain XP");
                System.out.println("Have a chance to find loot");

                if (rollD20() > 12) {
                    System.out.println("The monsters leaves behind some loot!");
                }

                level++;
                dungeonLevel++;
            }
        }

        System.out.println("dungeon level after cycle 1 is: " + dungeonLevel);

    }

    private void runMagicDungeonCycle() {

    }












}
