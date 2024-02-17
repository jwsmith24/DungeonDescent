package character;

import utility.Dice;
import utility.index.Condition;
import utility.index.PlayerClass;
import utility.index.PlayerRace;

import java.util.ArrayList;

/**
 * Encapsulates a character after it is constructed to be more maintainable when interacting with
 * the rest of the environment and reduce overhead of more decorators.
 */
public class Adventurer {

    private final CharacterInfo info;
    private final CharacterStats stats;
    private final CharacterSkills skills;
    private final ArrayList<Condition> activeEffects;


    /**
     * Default constructor, Adventurers are built with the character builder classes.
     */
    public Adventurer(CharacterInfo info, CharacterStats stats, CharacterSkills skills, ArrayList<Condition> activeEffects) {
        this.info = info;
        this.stats = stats;
        this.skills = skills;
        this.activeEffects = activeEffects;

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

        // Update HP to amount after subtracting damage
        int currentHP = this.stats.getHitPoints() - amount;
        this.stats.setHitPoints(currentHP);

        // Display how much damage was done by attack
        System.out.println("The attack hits you for " + amount + " damage!");

        // Display remaining hp to player
        System.out.println("Remaining hit points: " + this.getHitPoints() + "/" + this.getMaxHP());

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


    public void applyPower() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("You feel a presence come from deep within the dungeon. An overwhelming feeling of "
                + "joy washes over you, then.. power. It beckons you onward... \n");


        System.out.println("All stats increase by 1");
        System.out.println("HP increases by 10\n");

        stats.applyPowerStatBoost();
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

    /**
     * If player has a certain condition, method will return true.
     */
    public boolean hasCondition(Condition type) {

        for (Condition condition : this.activeEffects) {
            if (condition.equals(type)) {
                return true;
            }
        }
        return false;

    }


    public void drinkPotion() {

        if (PlayerInventory.consumePotion()) {
            int hpGained = Dice.rollAD10();

            System.out.println("You drink a potion of healing and restore "
                    + hpGained + " hit points!");

            healPlayer(hpGained);

            System.out.println("Remaining hit points: " + getHitPoints() + "/" + getMaxHP());

        } else {

            System.out.println("You rummage through your sack but find no potions");
        }


    }


    // Spenders
    public void spendUltimateCharges(int amount) {
        info.setUltimateCharges(amount);
    }

    // Getters

    public int getDungeoneering() {
        return skills.getDungeoneering();
    }

    public int getLockPicking() {
        return skills.getLockPicking();
    }

    public int getAthletics() {
        return skills.getAthletics();
    }

    public int getArcana() {
        return skills.getArcana();
    }

    public int getHistory() {
        return skills.getHistory();
    }


    public String getName() {
        return info.getName();
    }

    public int getExperience() {
        return info.getExperience();
    }

    public int getLevel() {
        return info.getLevel();
    }

    public PlayerRace getPlayerRace() {
        return info.getPlayerRace();
    }

    public PlayerClass getPlayerClass() {
        return info.getPlayerClass();
    }

    public String getCharacterSheet() {
        return info.getCharacterSheet();
    }

    public int getUltimateCharges() {
        return info.getUltimateCharges();
    }

    public int getAttack() {
        return stats.getAttack();
    }


    public int getAC() {
        return stats.getAC();
    }


    public int getHitPoints() {
        return stats.getHitPoints();
    }


    public int getMaxHP() {
        return stats.getMaxHP();
    }


    public int getEnergy() {
        return stats.getEnergy();
    }


    public int getSpeed() {
        return stats.getSpeed();
    }


    public int getLuck() {
        return stats.getLuck();
    }


}

