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

    String getSpecialAbility();

    String getPlayerClass();

    String getAttackType();

    @Override
    String toString();

}