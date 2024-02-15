import character.*;

import character.Character;
import dungeon.Dungeon;
import dungeon.DungeonMaster;
import dungeon.Shop;
import utility.CharacterBuilder;
import utility.index.EquipmentSlot;
import utility.index.Item;
import utility.index.PlayerClass;
import utility.index.PlayerRace;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Basic main class to ensure everything is set up properly.
 */
public class Main {

    /**
     * Simple main method to test dev tools for assignment part 1.
     */
    public static void main(String[] args) {

        // Utilizing the decorator pattern here for race and class with
        // corresponding enums to keep things generalized and neat.

        // For building the character sheet, I made a builder class that hides all the print
        // formatting work behind nice static methods which the character decorator classes use.
        // It uses the decorator classes to act implicitly as the director to determine how a character sheet is built.



        //decoratorDemo();

        //userCharacterCreationDemo();


        runDungeon();



        //Shop.goShopping(new Scanner(System.in, StandardCharsets.UTF_8));


    }
    private static void userCharacterCreationDemo() {
        Adventurer player = CharacterBuilder.createCharacter();
        System.out.println("Prepare to descend into the dungeon, " + player.getName() + "!");

    }
    private static void decoratorDemo() {
        // Let's build a character - Craig and see their character sheet as its built!

        Character craig = new BasicCharacter("Craig");

        System.out.println("Hi, I'm " + craig.getName() + ".\n");

        System.out.println(craig.getCharacterSheet());

        // Craig wants to be a Human Mage

        // First, we make Craig a Human
        craig = new RaceDecorator(craig, PlayerRace.HUMAN);

        System.out.println("Hi, I'm still " + craig.getName() + " and I'm a "
                + craig.getPlayerRace() + "!"
                + "\nIf we were to fight right now, I would use a: " + craig.getPlayerClass().getAttackText());

        System.out.println(craig.getCharacterSheet());

        // Then, Craig decides to be a Mage:
        craig = new ClassDecorator(craig, PlayerClass.MAGE);

        System.out.println("\nI'm seriously still " + craig.getName()
                + " the " + craig.getPlayerRace()
                + ", but now I'm also a " + craig.getPlayerClass() + "!"
                + " If we were to fight, I would use a: " + craig.getPlayerClass().getAttackText());

        System.out.println(craig.getCharacterSheet());

        // You can see the human racial ability (+2 to attack) was applied as well
    }

    private static void buildInventory() {
        PlayerInventory.initializeInventory();

    }

    private static void runDungeon() {
        DungeonMaster.runDungeon();
    }
}
