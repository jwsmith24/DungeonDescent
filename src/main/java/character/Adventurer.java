package character;

import utility.index.Condition;

import java.util.ArrayList;

/**
 * Encapsulates a character after it is constructed to be more maintainable when interacting with
 * the rest of the environment and reduce overhead of more decorators.
 */
public class Adventurer {

    private CharacterInfo info;
    private CharacterStats stats;
    private CharacterSkills skills;
    private ArrayList<Condition> activeEffects;


    /**
     * Default constructor, Adventurers are built with the character builder classes.
     */
    public Adventurer() {
        // empty for now

    }

    /**
     * Logic for using an ultimate ability.
     */
    public void useUltimateAbility() {

        // Each player has a limited number of ultimate charges (starts at 1/rest)
        // All ultimate abilities do double damage

    }


    /**
     * Determines if player is still alive.
     */
    public boolean isAlive() {
        return stats.getHitPoints() > 0;
    }

    /**
     * Rather than a level system, skills will improve by the player spending the xp they earn from
     * defeating monsters in the dungeon.
     *
     * @param amount amount to subtract from player's total
     */
    public void spendXP(int amount) {

        // ensure XP spent is positive
        if (amount < 0) {
            System.out.println("XP spent cannot be negative");
            return;
        }

        int xp = this.info.getExperience();
        int newXp = xp - amount;

        // Ensure player has enough experience to purchase a skill upgrade
        if (newXp < 0) {
            System.out.println("Insufficient XP. Current balance: " + xp);


        } else {
            this.info.setExperience(newXp);

        }

    }

    /**
     * Used by entities that cause the player to gain xp.
     *
     * @param amount xp gained
     */
    public void gainXP(int amount) {
        // ensure XP gained is positive
        if (amount < 0) {
            System.out.println("XP gained cannot be negative");
            return;
        }

        int currentXP = this.info.getExperience();

        this.info.setExperience(currentXP + amount);
    }

    /**
     * Used by entities that cause the player damage.
     *
     * @param amount damage taken
     */
    public void takeDamage(int amount) {

        // check that damage is a positive value
        if (amount < 0) {
            System.out.println("Damage cannot be negative!");
        }

        int currentHP = this.stats.getHitPoints();
        currentHP -= amount;

        // check to see if damage kills player and set hp to 0
        if (currentHP <= 0) {
            System.out.println("The damage is fatal.");
            this.stats.setHitPoints(0);
        }
    }

    /**
     * Used by entites that cause the character to gain HP.
     *
     * @param amount hp gained
     */
    public void healPlayer(int amount) {
        int newHp = this.stats.getHitPoints() + amount;

        // if healing would bring player over max hp, just set hp to max
        this.stats.setHitPoints(Math.min(newHp, this.stats.getMaxHP()));
    }


    public ArrayList<Condition> getActiveEffects() {
        return activeEffects;
    }

    public void setActiveEffects(ArrayList<Condition> activeEffects) {
        this.activeEffects = activeEffects;
    }

    /**
     * Applies new condition to character. If this is the first condition applied, remove neutral
     * and apply the new condition. If this is condition 2+, add the condition. Clearing conditions
     * is clearing the list and adding neutral to active effects.
     *
     * @param newCondition new condition to apply to character.
     */
    public void applyCondition(Condition newCondition) {


        // If applying the NEUTRAL condition, we need to clear the list of active effects

        if (newCondition == Condition.NEUTRAL) {

            // Clear the list of all effects, add neutral
            activeEffects.clear();
            activeEffects.add(Condition.NEUTRAL);

        } else {
            // Remove neutral from list before applying new effect
            activeEffects.removeIf(condition -> condition == Condition.NEUTRAL);

            // Using the removeIf from Iterator instead of an enhanced for loop is safe
            // to use during concurrent iteration

            // Apply new effect
            activeEffects.add(newCondition);


        }

    }


    // Getters and Setters

    public void setInfo(CharacterInfo info) {
        this.info = info;
    }

    public CharacterInfo getInfo() {
        return this.info;
    }

    public void setStats(CharacterStats stats) {
        this.stats = stats;
    }

    public CharacterStats getStats() {
        return this.stats;
    }

    public void setSkills(CharacterSkills skills) {
        this.skills = skills;
    }

    public CharacterSkills getSkills() {
        return this.skills;
    }


}

