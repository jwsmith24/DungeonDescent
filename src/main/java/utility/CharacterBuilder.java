package utility;

import character.Adventurer;
import character.BasicCharacter;
import character.Character;
import character.CharacterActiveEffects;
import character.CharacterInfo;
import character.CharacterSkills;
import character.CharacterStats;
import character.ClassDecorator;
import character.RaceDecorator;
import utility.index.PlayerClass;
import utility.index.PlayerRace;


/**
 * Contains methods for character creation and displaying options to the user.
 */
public class CharacterBuilder {


    /**
     * Directs building a character to be used in the game.
     */
    public static Adventurer createCharacter(boolean dungeonIsScripted) {

        Character generatedPlayer = characterCreation(dungeonIsScripted);

        // After character is built from user input, we capture the state in an Adventurer object.

        return spawnCharacter(generatedPlayer);

    }

    /**
     * Helper method to build a character from user input.
     *
     * @return finished character
     */
    private static Character characterCreation(boolean dungeonIsScripted) {

        PlayerRace raceSelection;
        PlayerClass classSelection;
        Character player;

        while (true) {

            // Build basic character with user-provided name
            player = new BasicCharacter(selectCharacterName(dungeonIsScripted));

            // Add race decorator based on user's class choice
            raceSelection = selectRace(dungeonIsScripted);
            player = new RaceDecorator(player, raceSelection);

            // Add a class decorator based on user's class choice
            classSelection = selectClass(dungeonIsScripted);
            player = new ClassDecorator(player, classSelection);

            // Display character sheet and confirmation
            System.out.println(player.getCharacterSheet());


            System.out.println("===============================");
            System.out.println("Confirm Character? ");
            System.out.println("Enter 1 for yes or 2 for no.");
            System.out.println("===============================");

            // get user input to confirm character creation
            int selection;
            if (dungeonIsScripted) {
                selection = 1;
            } else {
                selection = DungeonUtil.getUserSelection(2);
            }

            if (selection == 1) {
                break;

            } else {
                System.out.println("Restarting character creation!");
            }
        }

        return player;
    }

    /**
     * Helper method to select class from player selection.
     */
    private static PlayerClass selectClass(boolean isDungeonScripted) {


        System.out.println("Select your class!");
        printClassOptions();

        int choice;

        // sets scripted class to warrior for scripted or prompt player to choose
        if (isDungeonScripted) {
            choice = 1;

        } else {
            choice = DungeonUtil.getUserSelection(4);
        }

        if (choice == 1) {
            return PlayerClass.WARRIOR;

        } else if (choice == 2) {
            return PlayerClass.MAGE;

        } else if (choice == 3) {
            return PlayerClass.THIEF;

        } else {
            return PlayerClass.PRIEST;

        }

    }

    private static void printClassOptions() {

        // Print an ASCII sword!
        System.out.println("      /| ________________");
        System.out.println("O|===|* >________________>");
        System.out.println("      \\|");


        // Print class options
        String classOptions =
                "Class Options:\n"
                        +
                        "1. Warrior\n"
                        +
                        "2. Mage\n"
                        +
                        "3. Thief\n"
                        +
                        "4. Priest\n";

        System.out.println(classOptions);
    }

    /**
     * Gets character name from player or enters default name in scripted mode.
     */
    private static String selectCharacterName(boolean isDungeonScripted) {

        System.out.println("Enter your character name: ");

        String characterName;

        if (isDungeonScripted) {
            characterName = "Cloud";
        } else {
            characterName = DungeonUtil.getUserString();
        }

        return characterName;

    }

    /**
     * Helper method to print out race options.
     */
    private static void printRaceOptions() {

        System.out.println("  \\o/");
        System.out.println("   |");
        System.out.println("  / \\");

        String raceOptions =
                "Race Options:\n"
                        +
                        "1. Orc\n"
                        +
                        "2. Human\n"
                        +
                        "3. Demon\n"
                        +
                        "4. Elf\n"
                        +
                        "5. Gnome";

        System.out.println(raceOptions);
    }

    /**
     * Helper method to handle getting race selection from user.
     */
    private static PlayerRace selectRace(boolean isDungeonScripted) {

        System.out.println("Select your race!");

        printRaceOptions();

        int selection;
        if (isDungeonScripted) {
            selection = 4;

        } else {
            selection = DungeonUtil.getUserSelection(4);
        }

        if (selection == 1) {
            return PlayerRace.ORC;

        } else if (selection == 2) {
            return PlayerRace.HUMAN;

        } else if (selection == 3) {
            return PlayerRace.DEMON;

        } else if (selection == 4) {
            return PlayerRace.ELF;

        } else {
            return PlayerRace.GNOME;
        }

    }


    /**
     * Once character creation is done, we want to capture the state of the object so that updating
     * conditions, level, experience, etc. doesn't scale out of control.
     */
    public static Adventurer spawnCharacter(Character characterRef) {

        // Create Adventurer object that captures state of decorated object
        CharacterStats stats = CharacterStats.statBuilder(characterRef);
        CharacterSkills skills = CharacterSkills.skillBuilder(characterRef);
        CharacterInfo info = CharacterInfo.infoBuilder(characterRef);
        CharacterActiveEffects effects = CharacterActiveEffects.effectsBuilder(characterRef);

        return new Adventurer(info, stats, skills, effects);
    }

    /**
     * Private constructor - utility class.
     */
    private CharacterBuilder() {
        // No objects here!
    }

    /**
     * Displays character customization options to player.
     */
    public static void printCustomizationOptions() {
        printClassOptions();
        printRaceOptions();

    }
}
