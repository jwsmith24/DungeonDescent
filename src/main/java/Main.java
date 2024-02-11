import character.BasicCharacter;
import character.Character;
import character.ClassDecorator;
import character.RaceDecorator;

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

        // Utilizing the decorator pattern here for race and class with
        // corresponding enums to keep things generalized and neat.

        // For building the character sheet, I made a builder class that hides all the print
        // formatting work behind nice static methods which the character decorator classes use.
        // It uses the decorator classes to act implicitly as the director to determine how a character sheet is built.



        // Let's build a character - Craig and see their character sheet as its built!

        Character craig = new BasicCharacter("Craig");

        System.out.println("Hi, I'm " + craig.getName() + ".\n");

        System.out.println(craig.getCharacterSheet());

        // Craig wants to be a Human Mage

        // First, we make Craig a Human
        craig = new RaceDecorator(craig, PlayerRace.HUMAN);

        System.out.println("Hi, I'm still " + craig.getName() + " and I'm a "
                + craig.getPlayerRace() + "!"
                + "\nIf we were to fight right now, I would use a: " + craig.getAttackType());

        System.out.println(craig.getCharacterSheet());

        // Then, Craig decides to be a Mage:
        craig = new ClassDecorator(craig, PlayerClass.MAGE);

        System.out.println("\nI'm seriously still " + craig.getName()
                + " the " + craig.getPlayerRace()
                + ", but now I'm also a " + craig.getPlayerClass() + "!"
                + " If we were to fight, I would use a: " + craig.getAttackType());

        System.out.println(craig.getCharacterSheet());

        // You can see the human racial ability (+2 to attack) was applied as well




    }
}
