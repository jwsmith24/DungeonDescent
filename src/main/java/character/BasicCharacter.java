package character;

import java.util.ArrayList;

/**
 * <p>The basic concrete character class that can be decorated by the race and class decorators.</p>
 *
 * <p>Functionality for ALL characters can be added here while class or race-specific
 *  functionality will override the applicable methods in the decorator classes.</p>
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
    String race;
    int experience;
    int level;
    ArrayList<Condition> activeEffects = new ArrayList<>();

    String playerClass;
    String specialAbility;
    String racialAbility;
    String attackType;


    /**
     * A Player starts with all the base stats plus whatever they're named by the user.
     * @param name character name
     */
    public BasicCharacter(String name) {

        // Set base stats
        this.attack = GameConstants.BASE_ATTACK;
        this.defence = GameConstants.BASE_DEF;
        this.hitPoints = GameConstants.BASE_HP;
        this.energy = GameConstants.BASE_ENERGY;
        this.speed = GameConstants.BASE_SPEED;

        // Set base skills
        this.dungeoneering = GameConstants.BASE_DUNGEONEERING;
        this.lockPicking = GameConstants.BASE_LOCKPICKING;
        this.athletics = GameConstants.BASE_ATHLETICS;
        this.arcana = GameConstants.BASE_ARCANA;
        this.history = GameConstants.BASE_HISTORY;

        // Set base player info
        this.name = name;
        this.experience = 0;
        this.level = 1;
        this.activeEffects.add(Condition.NEUTRAL);

        this.playerClass = GameConstants.CLASSLESS;
        this.attackType = GameConstants.UNARMED_ATTACK;
        this.specialAbility = GameConstants.NEW_CHARACTER;

        this.race = GameConstants.NEW_CHARACTER;
        this.racialAbility = GameConstants.NEW_CHARACTER;
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

        // Copy the array

        return new ArrayList<>(activeEffects);
    }

    @Override
    public String getPlayerClass() {
        return playerClass;
    }

    @Override
    public String getAttackType() {
        return attackType;
    }

    @Override
    public String getSpecialAbility() {
        return specialAbility;
    }


    @Override
    public String getPlayerRace() {
        return race;
    }

    @Override
    public String getRacialAbility() {
        return racialAbility;
    }


    @Override
    public String getCharacterSheet() {

        return CharacterSheetBuilder.buildBasicSection(this);

    }




}


