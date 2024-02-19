package utility;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

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

    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    /**
     * Collect user input for a selection between 1 and the number of choices provided.
     */
    public static int getUserSelection(int numberOfChoices) {
        int selection = 0;
        boolean playerDeciding = true;

        while (playerDeciding) {

            try {
                selection = scanner.nextInt();
                scanner.nextLine();

                if (selection > 0 && selection < numberOfChoices) {
                    playerDeciding = false;
                }

            } catch (Exception e) {
                System.out.println("Enter a valid number between 1 and " + numberOfChoices);
            }
        }

        return selection;
    }

    /**
     * Collect user string input.
     */
    public static String getUserString() {
        String response = "Mysterious Character";

        boolean playerDeciding = true;

        while(playerDeciding) {
            try {
                response = scanner.nextLine();
                scanner.nextLine();
                playerDeciding = false;

            } catch (Exception e) {
                System.out.println("Enter valid characters");
            }
        }

        return response;
    }

    /**
     * Simulates rolling a 20-sided die.
     * @return result of roll
     */
    public static int rollAD20() {
        return RANDOM.nextInt(20) + 1;
    }

    /**
     * Simulates rolling a 10-sided die.
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

    /**
     * Prints out 3 * on new lines.
     */
    public static void printSpacer() {
        System.out.println("*\n");
        System.out.println("*\n");
        System.out.println("*\n");
    }

    /**
     * Used to consistently wrap important text.
     */
    public static void printSpecialWrapper() {

        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }



    private DungeonUtil() {
        // no objects here
    }


}
