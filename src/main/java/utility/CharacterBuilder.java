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
import utility.index.Condition;
import utility.index.PlayerClass;
import utility.index.PlayerRace;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Contains methods for character creation and displaying options to the user.
 */
public class CharacterBuilder {


    /**
     * Creates a pre-built character: Cloud, the Elf Warrior.
     */
    public static Adventurer createScriptedCharacter() {

        return new Adventurer(setScriptedInfo(), setScriptedStats(),
                setScriptedSkills(), setScriptedActiveEffects());
    }

    private static CharacterSkills setScriptedSkills() {
        // apply class bonus
        return new CharacterSkills(1,1,3,1,1);
    }


    private static CharacterStats setScriptedStats() {
        // apply racial bonus
        return new CharacterStats(1,1,10,3,1,1);
    }

    private static CharacterInfo setScriptedInfo() {

        String characterSheet = "test character sheet";

        return new CharacterInfo(0, 1, "Cloud", PlayerRace.ELF,
                PlayerClass.WARRIOR, characterSheet);
    }

    private static CharacterActiveEffects setScriptedActiveEffects() {
        ArrayList<Condition> activeEffects = new ArrayList<>();
        activeEffects.add(Condition.NEUTRAL);

        return new CharacterActiveEffects(activeEffects);

    }



    /**
     * Directs building a character to be used in the game.
     */
    public static Adventurer createCharacter() {

        Character generatedPlayer = manualCharacterCreation();

        // After character is built from user input, we capture the state in an Adventurer object.

        return spawnCharacter(generatedPlayer);

    }

    /**
     * Helper method to build a character from user input.
     *
     * @return finished character
     */
    private static Character manualCharacterCreation() {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        PlayerRace raceSelection;
        PlayerClass classSelection;
        Character player;

        while (true) {

            // Build basic character with user-provided name
            player = new BasicCharacter(selectCharacterName(scanner));

            // Add race decorator based on user's class choice
            raceSelection = selectRace(scanner);
            player = new RaceDecorator(player, raceSelection);

            // Add a class decorator based on user's class choice
            classSelection = selectClass(scanner);
            player = new ClassDecorator(player, classSelection);

            // Display character sheet and confirmation
            System.out.println(player.getCharacterSheet());


            System.out.println("===============================");
            System.out.println("Confirm Character? ");
            System.out.println("Enter 1 for yes or 2 for no.");
            System.out.println("===============================");


            if (Integer.parseInt(scanner.nextLine()) == 1) {
                break;
            }
            System.out.println("Restarting character creation!");
        }


        return player;
    }

    /**
     * Helper method to select class from player selection.
     */
    private static PlayerClass selectClass(Scanner scanner) {

        PlayerClass classSelection;

        System.out.println("Select your class!");
        printClassOptions();

        while (true) {

            if (scanner.hasNextLine()) {

                int choice;

                try {
                    choice = Integer.parseInt(scanner.nextLine());

                    if (choice <= 5 && choice > 0) {

                        if (choice == 1) {
                            classSelection = PlayerClass.WARRIOR;
                        } else if (choice == 2) {
                            classSelection = PlayerClass.MAGE;
                        } else if (choice == 3) {
                            classSelection = PlayerClass.THIEF;
                        } else {
                            classSelection = PlayerClass.PRIEST;
                        }

                        return classSelection;

                    } else {
                        System.out.println("Enter a valid choice");
                        printRaceOptions();
                    }
                } catch (Exception e) {
                    System.out.println("Enter a valid number");
                    printRaceOptions();
                }
            } else {
                System.out.println("No input found");
                break;
            }
        }


        return null;
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
     * Helper method to retrieve character name.
     */
    private static String selectCharacterName(Scanner scanner) {

        System.out.println("Enter your character name: ");

        try {
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            }

        } catch (Exception e) {
            System.out.println("Invalid Entry");
            scanner.nextLine();
        }

        return null;
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
    private static PlayerRace selectRace(Scanner scanner) {

        System.out.println("Select your race!");

        PlayerRace raceSelection;


        while (true) {

            printRaceOptions();


            if (scanner.hasNextLine()) {
                int choice;

                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice <= 5 && choice > 0) {

                        if (choice == 1) {
                            raceSelection = PlayerRace.ORC;
                        } else if (choice == 2) {
                            raceSelection = PlayerRace.HUMAN;
                        } else if (choice == 3) {
                            raceSelection = PlayerRace.DEMON;
                        } else if (choice == 4) {
                            raceSelection = PlayerRace.ELF;
                        } else {
                            raceSelection = PlayerRace.GNOME;
                        }
                        return raceSelection;

                    } else {
                        System.out.println("Enter a valid choice");

                    }
                } catch (Exception e) {
                    System.out.println("Enter a valid number");

                }
            } else {
                System.out.println("No input found");
            }
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
