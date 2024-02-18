package utility;

import java.util.Random;

/**
 * Utility class to handle all dice rolling in the game.
 */
public class DungeonUtil {

    public static final int SMALL_XP = 100;
    public static final int MED_XP = 200;
    public static final int BOSS_XP = 500;

    public static final int TRAP_DAMAGE = 6;

    public static final int TRAP_DC = 12;

    private static final Random RANDOM = new Random();


    /**
     * Simulates rolling a 20-sided die
     * @return result of roll
     */
    public static int rollAD20() {
        return RANDOM.nextInt(20) + 1;
    }

    /**
     * Simulates rolling a 10-sided die
     * @return result of roll
     */
    public static int rollAD10() {
        return RANDOM.nextInt(10) + 1;
    }

    /**
     * Handles rolling a random number on a loot table of a given size.
     * @return random number to select loot
     */
    public static int rollRandomItem(int arraySize) {
        return RANDOM.nextInt(arraySize);
    }

    public static void printSpacer() {
        System.out.println("*\n");
        System.out.println("*\n");
        System.out.println("*\n");
    }

    public static void printSpecialWrapper() {

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }



    private DungeonUtil() {
        // no objects here
    }


}
