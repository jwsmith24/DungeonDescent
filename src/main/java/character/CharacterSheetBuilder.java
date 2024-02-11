package character;

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
                "======================\n"

                + "| Race: %s\n"
                + "| Racial ability: %s\n"
                + "======================\n"
                + "|\tStats\n"
                + "======================\n"
                + "| Attack: %s\n"
                + "| Defence: %s\n"
                + "| Hit Points: %s\n"
                + "| Energy: %s\n"
                + "| Speed: %s\n"
                + "| Luck: %s\n",

                decoratedRace.getPlayerRace(),
                decoratedRace.getRacialAbility(),
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
                "======================\n"
                + "| Class: %s\n"
                + "| Attack Type: %s\n"
                + "| Special Ability: %s\n",

                decoratedClass.getPlayerClass(), decoratedClass.getAttackType(),
                decoratedClass.getSpecialAbility()
        );


    }
}
