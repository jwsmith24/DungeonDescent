package character;

import java.util.ArrayList;

import utility.CharacterSheetBuilder;
import utility.index.Condition;
import utility.index.PlayerClass;
import utility.index.PlayerRace;
import utility.index.PlayerSkills;
import utility.index.PlayerStats;




/**
 * <p>The basic concrete character class that can be decorated by the race and class
 * decorators.</p>
 *
 * <p>Functionality for ALL characters can be added here while class or race-specific
 * functionality will override the applicable methods in the decorator classes.</p>
 */
public class BasicCharacter implements Character {


    // Core Stats
    int attack;
    int defence;
    int hitPoints;
    int energy;
    int speed;
    int luck;

    // Skills
    int dungeoneering;
    int lockPicking;
    int athletics;
    int arcana;
    int history;

    // Player Info
    String name;
    PlayerRace race;
    int experience;
    int level;
    ArrayList<Condition> activeEffects = new ArrayList<>();

    PlayerClass playerClass;


    /**
     * A Player starts with all the base stats plus whatever they're named by the user.
     *
     * @param name character name
     */
    public BasicCharacter(String name) {

        // Set base stats
        this.attack = PlayerStats.ATTACK.getBaseValue();
        this.defence = PlayerStats.AC.getBaseValue();
        this.hitPoints = PlayerStats.HP.getBaseValue();
        this.energy = PlayerStats.ENERGY.getBaseValue();
        this.speed = PlayerStats.SPEED.getBaseValue();
        this.luck = PlayerStats.LUCK.getBaseValue();

        // Set base skills
        this.dungeoneering = PlayerSkills.DUNGEONEERING.getBaseValue();
        this.lockPicking = PlayerSkills.LOCK_PICKING.getBaseValue();
        this.athletics = PlayerSkills.ATHLETICS.getBaseValue();
        this.arcana = PlayerSkills.ARCANA.getBaseValue();
        this.history = PlayerSkills.HISTORY.getBaseValue();

        // Set base player info
        this.name = name;
        this.experience = 0;
        this.level = 1;
        this.activeEffects.add(Condition.NEUTRAL);

        this.playerClass = PlayerClass.NO_CLASS;
        this.race = PlayerRace.NEW_CHARACTER;

    }

    /**
     * Copy constructor.
     */
    public BasicCharacter(Character characterRef) {

        this.attack = characterRef.getAttack();
        this.defence = characterRef.getDefense();
        this.hitPoints = characterRef.getHitPoints();
        this.energy = characterRef.getEnergy();
        this.speed = characterRef.getSpeed();
        this.luck = characterRef.getLuck();
        this.dungeoneering = characterRef.getDungeoneering();
        this.lockPicking = characterRef.getLockPicking();
        this.athletics = characterRef.getAthletics();
        this.arcana = characterRef.getArcana();
        this.history = characterRef.getHistory();
        this.name = characterRef.getName();
        this.race = characterRef.getPlayerRace();
        this.experience = characterRef.getExperience();
        this.level = characterRef.getLevel();
        this.activeEffects = new ArrayList<>(characterRef.getActiveEffects());
        this.playerClass = characterRef.getPlayerClass();

    }


    // Getters for Core Stats
    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defence;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getLuck() {
        return luck;
    }


    // Getters for Skills
    @Override
    public int getDungeoneering() {
        return dungeoneering;
    }

    @Override
    public int getLockPicking() {
        return lockPicking;
    }

    @Override
    public int getAthletics() {
        return athletics;
    }

    @Override
    public int getArcana() {
        return arcana;
    }

    @Override
    public int getHistory() {
        return history;
    }


    // Getters for Player Data

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public int getLevel() {
        return level;
    }


    @Override
    public ArrayList<Condition> getActiveEffects() {
        // Returns a new arraylist object so that we don't
        // modify the original with our wrapper conditions!
        return new ArrayList<>(activeEffects);
    }

    @Override
    public PlayerClass getPlayerClass() {
        return playerClass;
    }


    @Override
    public PlayerRace getPlayerRace() {
        return race;
    }


    @Override
    public String getCharacterSheet() {

        return CharacterSheetBuilder.buildBasicSection(this);

    }


}


