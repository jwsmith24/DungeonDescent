import character.*;
import character.Character;

/**
 * Basic main class to ensure everything is set up properly.
 */
public class Main {

    static int level = 0;

    /**
     * Simple main method to test dev tools.
     */
    public static void main(String[] args) {


        // Make a base character Bob
        Character bob = new BasicCharacter("Bob");
       // System.out.println(bob.getCharacterSheet());
        // Bob is an Orc
        bob = new Human(bob);
        //System.out.println(bob.getCharacterSheet());
        // Bob wants to cast spells
        bob = new Mage(bob);
        System.out.println(bob.getCharacterSheet());





        System.out.println("Bob's race is: " + bob.getPlayerRace());
        System.out.println("Bob's name is: " + bob.getName());
        System.out.println("Bob's class is: " + bob.getPlayerClass());


        System.out.println("Bob's Arcana is: " + bob.getArcana());




/*
        System.out.println("Let's make a Warrior!");

        Player warriorCraig = new Warrior("Craig the Warrior");
        System.out.println(warriorCraig);

        System.out.println("Let's make a Thief!");
        Player thiefDoug = new Thief("Doug the Thief");
        System.out.println(thiefDoug);*/



    }
}
