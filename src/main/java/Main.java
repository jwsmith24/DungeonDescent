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



        Player wizard = new Mage("bob");

        System.out.println("Wizard attack score is: " + wizard.getAttack());
        System.out.println("Wizard hit points: " + wizard.getHitPoints());
    }
}
