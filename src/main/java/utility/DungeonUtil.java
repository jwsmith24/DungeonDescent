package utility;

import java.util.Random;

/**
 * Utility class to handle all dice rolling in the game.
 */
public class DungeonUtil {

    private static final Random d20 = new Random();


    /**
     * Simulates rolling a 20-sided die
     * @return result of roll
     */
    public static int rollAD20() {
        return d20.nextInt(20) + 1;
    }

    public static int rollAD10() {
        return d20.nextInt(10) + 1;
    }


    public static void printSpacer() {
        System.out.println("*\n");
        System.out.println("*\n");
        System.out.println("*\n");
    }



    private DungeonUtil() {
        // no objects here
    }


}
