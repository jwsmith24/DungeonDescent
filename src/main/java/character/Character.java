package character;


/**
 * Defines base character.
 */
public interface Character {

    String getName();

    // Base core stats
    int getAttack();
    int getDefense();
    int getHitPoints();
    int getEnergy();
    int getSpeed();

    // Base skills
    int getDungeoneering();
    int getLockPicking();
    int getAthletics();
    int getArcana();

    int getExperience();

    String getPlayerRace();
    String getSpecialAbility();
    void setSpecialAbility(String specialAbility);
    String getRacialAbility();
    void setRacialAbility(String racialAbility);
    String getPlayerClass();
    void setPlayerClass(String playerClass);
    String getAttackType();
    void setAttackType(String attackType);

    String getCharacterSheet();

}