package character;


/**
 * Defines base character.
 */
public interface Character {

    // Stats
    int getAttack();

    int getDefense();

    int getHitPoints();

    int getEnergy();

    int getSpeed();

    int getLuck();


    // Skills
    int getDungeoneering();

    int getLockPicking();

    int getAthletics();

    int getArcana();

    int getHistory();


    // Player Info

    String getName();

    int getExperience();

    int getLevel();

    String getPlayerRace();

    String getSpecialAbility();

    String getRacialAbility();

    String getPlayerClass();

    String getAttackType();

    String getCharacterSheet();

}