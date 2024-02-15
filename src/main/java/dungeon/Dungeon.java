package dungeon;

import character.Adventurer;
import monsters.Monster;
import monsters.MonsterFactory;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;


/**
 * This class represents the dungeon itself. Players and the Dungeon interact via the DungeonMaster Mediator.
 */
public class Dungeon {
    private static int dungeonLevel;
    private static final Random d20 = new Random();
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    // Each floor has one fight and a chance to find some loot or a shop
    public static void runDungeon() {
        runClassicDungeonCycle();

        // run cycle 2 (BOSS) - BEHOLDER
        // run cycle 3
        // run cycle 4 (FINAL BOSS) - DRAGON

    }

    private static int rollAD20() {
        return d20.nextInt(20) + 1;
    }

    /**
     * TODO: Implement actual functionality
     */
    private static void runClassicDungeonCycle() {

        int level = 1;

        System.out.println("Apply cycle effect");

        while (level <= 5) {

            // roll a d20 each floor
            int lootChance = rollAD20();

            // At level 5, fight a medium monster
            if (level == 5) {

                // Generate a random medium monster
                Monster randomMediumMonster = MonsterFactory.randomMediumMonster();
                System.out.println("A " + randomMediumMonster.getName() + " appears!");

                System.out.println("Fight a medium monster!");
                System.out.println("Gain more XP");
                System.out.println("Have a larger chance to find loot");

                // Chance to find the shopkeeper or loot lying around
                if((lootChance) > 15) {

                    Shop.shopKeeperEncounter(scanner);

                } else if ((lootChance) > 10) {
                    System.out.println("The monster leaves behind some loot!");

                }

                System.out.println("Want to take a long rest? You have X/3 remaining");
                level++;
                dungeonLevel++;

            } else {
                // Generate a random small monster
                Monster randomSmallMonster = MonsterFactory.randomSmallMonster();
                System.out.println("A " + randomSmallMonster.getName() + " appears!");

                // go to combat
                // resolve combat

                System.out.println("Fight a small monster!");
                System.out.println("Gain XP");
                System.out.println("Have a chance to find loot");

                if (lootChance > 12) {
                    System.out.println("The monsters leaves behind some loot!");
                }

                level++;
                dungeonLevel++;
            }
        }

        System.out.println("dungeon level after cycle 1 is: " + dungeonLevel);

    }

    private static void runMagicDungeonCycle() {

    }

}
