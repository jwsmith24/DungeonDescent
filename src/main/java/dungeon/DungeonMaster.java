package dungeon;

import character.Adventurer;
import monsters.Monster;
import monsters.MonsterFactory;
import utility.CharacterBuilder;
import utility.Dice;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;

/**
 * Director for all actions in the dungeon. Acts as the mediator to avoid tight coupling of classes.
 * Specifically Adventurer and Monster.
 */
public class DungeonMaster {

    // The dungeon master knows about the player and the monsters.
    private static Adventurer player;
    private static Monster monster;

    // DungeonMaster also knows about the player inventory and the dungeon itself which are
    // both static

    private static int dungeonLevel;
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);


    /**
     * Uses the Character Builder class to allow the user to build their chracter.
     */
    private static void spawnCharacter() {
        player = CharacterBuilder.createCharacter();
    }

    /**
     * TODO: Implement actual functionality
     */

    // Each floor has one fight and a chance to find some loot or a shop
    public static void runDungeon() {
        // welcome text
        displayWelcomeText();

        // Create character
        spawnCharacter();

        // start dungeon
        runClassicDungeonCycle();

        // run cycle 2 (BOSS) - BEHOLDER
        // run cycle 3
        // run cycle 4 (FINAL BOSS) - DRAGON

    }

    private static void displayWelcomeText() {
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*            Welcome to Dungeon Descent               *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
    }
    private static void runClassicDungeonCycle() {

        int level = 1;
        Combat dungeonCombat;
        boolean playerIsAlive = true;

        System.out.println("Apply cycle effect");

        while (level <= 5 && playerIsAlive) {

            // roll a d20 each floor for chance at finding loot
            int lootChance = Dice.rollAD20();

            // At level 5, fight a medium monster
            if (level == 5) {

                // Set active monster to a random medium monster
                monster = MonsterFactory.randomMediumMonster();
                System.out.println("A " + monster.getName() + " appears!");

                // go to combat
                dungeonCombat = new Combat(player, monster);
                // combat resolves into a boolean that's true if player is alive or false if they died.
                playerIsAlive = dungeonCombat.combat();

                // Chance to find the shopkeeper or loot lying around
                if (playerIsAlive && (lootChance) > 15) {

                    Shop.shopKeeperEncounter(scanner);

                } else if (playerIsAlive && (lootChance > 10)) {
                    System.out.println("The monster leaves behind some loot!");

                }

                System.out.println("Want to take a long rest? You have X/3 remaining");

                level++;
                dungeonLevel++;

            } else {

                // set active monster to a random small monster
                monster = MonsterFactory.randomSmallMonster();
                System.out.println("A " + monster.getName() + " appears!");

                // go to combat
                dungeonCombat = new Combat(player, monster);
                // combat resolves into a boolean that's true if player is alive or false if they died.
                playerIsAlive = dungeonCombat.combat();

                // As long as the player is still alive, they get a chance to find loot.
                if (playerIsAlive && lootChance > 12) {
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





















