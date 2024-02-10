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



        System.out.println("Let's make a mage!");

        Player wizard = new Mage("bob");

        System.out.println("We want to see something that's specific to Mage " +
                "AND something that comes from the base class");

        System.out.println(wizard);



    }
}
