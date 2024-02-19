import dungeon.DungeonMaster;
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
     * Runs the game.
     */
    private static void runDungeon() {
        DungeonMaster.runDungeon();
    }


}
