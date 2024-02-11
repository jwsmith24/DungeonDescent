package character;

/**
 * Defines character functionality.
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

    Condition getActiveEffect();

    String getPlayerRace();

    String getSpecialAbility();

    String getRacialAbility();

    String getPlayerClass();

    String getAttackType();

    String getCharacterSheet();

    // Condition Updates

    void setPlayerCondition(Condition condition);

}