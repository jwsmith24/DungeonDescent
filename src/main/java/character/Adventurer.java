package character;

import utility.index.Condition;

import java.util.ArrayList;

/**
 * Encapsulates a character after it is constructed to be more maintainable
 * when interacting with the rest of the environment and reduce overhead of more decorators.
 */
public class Adventurer implements Character {

    // Core Stats
    int attack;
    int defense;
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













    // Getters and Setters

    @Override
    public int getAttack() {
        return attack;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    @Override
    public int getDungeoneering() {
        return dungeoneering;
    }

    public void setDungeoneering(int dungeoneering) {
        this.dungeoneering = dungeoneering;
    }

    @Override
    public int getLockPicking() {
        return lockPicking;
    }

    public void setLockPicking(int lockPicking) {
        this.lockPicking = lockPicking;
    }

    @Override
    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    @Override
    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }

    @Override
    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public ArrayList<Condition> getActiveEffects() {
        return new ArrayList<>(activeEffects);
    }

    @Override
    public String getPlayerRace() {
        return race;
    }

    public void setActiveEffects(ArrayList<Condition> activeEffects) {
        this.activeEffects = new ArrayList<> (activeEffects);
    }

    @Override
    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    @Override
    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    @Override
    public String getRacialAbility() {
        return racialAbility;
    }

    public void setRacialAbility(String racialAbility) {
        this.racialAbility = racialAbility;
    }

    @Override
    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    @Override
    public String getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(String characterSheet) {
        this.characterSheet = characterSheet;
    }

    String characterSheet;

    /**
     * Default constructor.
     */
    public Adventurer() {

        // default constructor
    }


}

