import character.*;

/**
 * Basic main class to ensure everything is set up properly.
 */
public class Main {

    static int level = 0;

    /**
     * Simple main method to test dev tools.
     */
    public static void main(String[] args) {



        System.out.println("Let's make a Mage!");

        Player mageBob = new Mage("Bob the Mage");
        System.out.println(mageBob);


        System.out.println("Let's make a Warrior!");

        Player warriorCraig = new Warrior("Craig the Warrior");
        System.out.println(warriorCraig);

        System.out.println("Let's make a Thief!");
        Player thiefDoug = new Thief("Doug the Thief");
        System.out.println(thiefDoug);

    }
}
