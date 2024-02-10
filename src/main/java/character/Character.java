package character;


/**
 * Defines base character.
 */
public interface Character {

    String getName();

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

    // Player Info
    int getExperience();

    String getPlayerRace();
    String getSpecialAbility();

    String getRacialAbility();

    String getPlayerClass();

    String getAttackType();

    String getCharacterSheet();

}