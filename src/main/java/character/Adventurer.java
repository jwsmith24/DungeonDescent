package character;

import utility.index.Condition;

import java.util.ArrayList;

/**
 * Encapsulates a character after it is constructed to be more maintainable
 * when interacting with the rest of the environment and reduce overhead of more decorators.
 */
public class Adventurer {

    CharacterInfo info;
    CharacterStats stats;
    CharacterSkills skills;
    ArrayList<Condition> activeEffects;


    /**
     * Default constructor, sets everything after character creation.
     */
    public Adventurer() {


    }

    public ArrayList<Condition> getActiveEffects() {
        return new ArrayList<>(activeEffects);
    }
    public void setActiveEffects(ArrayList<Condition> activeEffects) {
        this.activeEffects = new ArrayList<> (activeEffects);
    }


    /**
     * Rather than a level system, skills will improve by the player spending the xp
     * they earn from defeating monsters in the dungeon.
     * @param xpSpent amount to subtract from player's total
     */
    public void spendXP(int xpSpent) {
        // ensure xpspent is positive
        if (xpSpent < 0) {
            System.out.println("XP spent cannot be negative");
            return;
        }

        int xp = this.info.getExperience();
        int newXp = xp - xpSpent;

        // Ensure player has enough experience to purchase a skill upgrade
        if (newXp < 0) {
            System.out.println("Insufficient XP. Current balance: " + xp);


        } else {
            this.info.setExperience(newXp);

        }

    }

    public void gainXP(int xpGained) {
        // ensure xpGained is positive
        if (xpGained < 0) {
            System.out.println("XP gained cannot be negative");
            return;
        }

        int currentXP = this.info.getExperience();

        this.info.setExperience(currentXP + xpGained);
    }

    public void takeDamage(int damage) {

       // check that damage is a positive value
        if (damage < 0) {
            throw new IllegalArgumentException("Damage value cannot be negative!");
        }

        int currentHP = this.stats.getHitPoints();
         currentHP -= damage;

        // check to see if damage kills player and set hp to 0
        if (currentHP <= 0) {
            System.out.println("The damage is fatal.");
            this.stats.setHitPoints(0);
        }
    }

    public void healPlayer(int healingReceived) {
        int newHp = this.stats.getHitPoints() + healingReceived;

        // if healing would bring player over max hp, just set hp to max
        this.stats.setHitPoints(Math.min(newHp, this.stats.getMaxHP()));
    }






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

