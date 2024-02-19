import character.Adventurer;
import character.BasicCharacter;
import character.Character;
import character.ClassDecorator;
import character.RaceDecorator;

import dungeon.DungeonMaster;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import utility.CharacterBuilder;
import utility.index.PlayerClass;
import utility.index.PlayerRace;



/**
 * Basic main class to ensure everything is set up properly.
 */
public class Main {

    /**
     * Simple main method to test dev tools for assignment part 1.
     */
    public static void main(String[] args) {

        welcomeScreen();

    }

    /**
     * Displays welcome screen and then updates DungeonMaster to be
     * in scripted or unscripted mode.
     */
    private static void welcomeScreen() {

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        displayWelcomeText();

        System.out.println("\nEnter 1 for the Scripted Version "
                + "| Enter 2 for the Normal Version");

        // Have player choose scripted or unscripted mode
        boolean playerDeciding = true;

        int result;

        while (playerDeciding) {

            try {
                result = scanner.nextInt();
                scanner.nextLine();

                if (result == 1) {
                    playerDeciding = false;
                    DungeonMaster.setIsScripted(true);
                    runDungeon();

                } else if (result == 2) {
                    playerDeciding = false;
                    DungeonMaster.setIsScripted(false);
                    runDungeon();
                }

            } catch (Exception e) {
                System.out.println("Enter 1 or 2");

            }
        }
    }

    private static void displayWelcomeText() {
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*            Welcome to Dungeon Descent!              *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");

    }


    /**
     * Demo for how the user could make a character.
     */
    private static void userCharacterCreationDemo() {
        Adventurer player = CharacterBuilder.createCharacter();
        System.out.println("Prepare to descend into the dungeon, " + player.getName() + "!");

    }

    /**
     * Demonstrates decorator pattern used for character design.
     */
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
                + "\nIf we were to fight right now, I would use a: "
                + craig.getPlayerClass().getAttackText());

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


    /**
     * Runs the game.
     */
    private static void runDungeon() {
        DungeonMaster.runDungeon();
    }


}
