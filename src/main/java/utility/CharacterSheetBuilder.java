package utility;

import character.Character;

/**
 * Utility class to provide character sheet assembly for each decorator class.
 */
public class CharacterSheetBuilder {

    /**
     * Helper method for all the race decorator classes to build their portion of the
     * character sheet with the appropriate data.
     * @param decoratedRace reference to character
     * @return chunk of character sheet with race data
     */
    public static String buildRaceSection(Character decoratedRace) {

        return String.format(
                "==================================%n"
                + "| Race: %s%n"
                + "| Racial bonus: %s%n"
                + "==================================%n"
                + "|\t\t\t  Stats%n"
                + "==================================%n"
                + "| Attack: %s%n"
                + "| Defence: %s%n"
                + "| Hit Points: %s%n"
                + "| Energy: %s%n"
                + "| Speed: %s%n"
                + "| Luck: %s%n",

                decoratedRace.getPlayerRace(),
                decoratedRace.getPlayerRace().getRacialBonusText(),
                decoratedRace.getAttack(),
                decoratedRace.getDefense(),
                decoratedRace.getHitPoints(),
                decoratedRace.getEnergy(),
                decoratedRace.getSpeed(),
                decoratedRace.getLuck()
        );
    }

    /**
     * Helper method for the class decorator classes to build their portion of the character sheet.
     * @param decoratedClass reference to character
     * @return chunk of character sheet with class data
     */
    public static String buildClassSection(Character decoratedClass) {

        return String.format(
                "==================================%n"
                + "| Class: %s%n"
                + "| Attack Type: %s%n"
                + "| Special Ability: %s%n"
                + "==================================%n",

                decoratedClass.getPlayerClass(), decoratedClass.getPlayerClass().getAttackText(),
                decoratedClass.getPlayerClass().getSpecialAbilityText()
        );
    }

    /**
     * Helper method to build the first section of the character sheet.
     * @param characterRef reference to the character
     * @return chunk of character sheet with basic info
     */
    public static String buildBasicSection(Character characterRef) {

        return String.format(
                "==================================%n"
                + "|\t\t Character Info%n"
                + "==================================%n"
                + "| Name: %s%n"
                + "| Experience: %s%n", characterRef.getName(), characterRef.getExperience());
    }

}
