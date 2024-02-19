import dungeon.DungeonMaster;
import utility.DungeonUtil;


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


        displayWelcomeText();

        System.out.println("\nEnter 1 for the Scripted Version "
                + "| Enter 2 for the Normal Version");

        // Have player choose scripted or unscripted mode
        int selection = DungeonUtil.getUserSelection(2);

        // update Dungeon Master to chosen mode
        if (selection == 1) {

            DungeonMaster.setIsScripted(true);
            runDungeon();

        } else if (selection == 2) {

            DungeonMaster.setIsScripted(false);
            runDungeon();
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
