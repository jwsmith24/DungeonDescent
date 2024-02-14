package dungeon;

import character.Adventurer;
import monsters.Monster;
import monsters.MonsterFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;

/**
 * Director for all actions in the dungeon. Acts as the mediator to avoid tight coupling of classes. Specifically
 * Adventurer and Monster.
 */
public class DungeonMaster {
    int dungeonLevel;
    Adventurer player;
    Monster monster;
    Random d20 = new Random();
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);




    // Each floor has one fight and a chance to find some loot or a shop

    public void runDungeon() {
        runClassicDungeonCycle();

        // run cycle 2 (BOSS) - BEHOLDER
        // run cycle 3
        // run cycle 4 (FINAL BOSS) - DRAGON

    }

    private void fight(Adventurer player, Monster monster) {


    }

    /**
     * TODO: Implement actual functionality
     */
    private void runClassicDungeonCycle() {

        int level = 1;

        System.out.println("Apply cycle effect");

        while (level <= 5) {

            // if level == 5, we fight a medium monster
            if (level == 5) {

                // Generate a random medium monster
                Monster randomMediumMonster = MonsterFactory.randomMediumMonster();
                System.out.println("A " + randomMediumMonster.getName() + " appears!");

                System.out.println("Fight a medium monster!");
                System.out.println("Gain more XP");
                System.out.println("Have a larger chance to find loot");

                // Chance to find the shopkeeper or loot lying around
                if((d20.nextInt(20) + 1) > 15) {

                    Shop.shopKeeperEncounter(scanner);

                } else if ((d20.nextInt(20) + 1) > 10) {
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

                if ((d20.nextInt(20) + 1) > 12) {
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
