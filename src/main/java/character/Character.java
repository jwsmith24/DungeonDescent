package character;

import java.util.ArrayList;

import utility.index.Condition;
import utility.index.PlayerClass;
import utility.index.PlayerRace;


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

    ArrayList<Condition> getActiveEffects();

    PlayerRace getPlayerRace();

    PlayerClass getPlayerClass();

    String getCharacterSheet();



}