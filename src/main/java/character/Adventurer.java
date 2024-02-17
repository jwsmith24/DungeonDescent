package character;

import utility.DungeonUtil;
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
     * Resets hp to max hp, resets ultimate charges, and clears conditions
     */
    public void takeLongRest() {
        System.out.println("You find a cozy spot to rest");
        DungeonUtil.printSpacer();

        healPlayer(this.getMaxHP());
        this.regainUltimate();
        applyCondition(Condition.NEUTRAL);

        System.out.println("HP restored to full");
        System.out.println("Ultimate Charges Reset");
        System.out.println("Conditions have been cleared");

    }

    /**
     * Allows other entities to trigger player regaining their ultimate charges.
     * Ultimate charges are based on energy score.
     */
    private void regainUltimate() {
        for(int i = 0; i < stats.getEnergy(); i++) {
            info.gainUltimateCharge();
        }
    }

    /**
     * Determines if player is still alive.
     */
    public boolean isAlive() {
        return stats.getCurrentHP() > 0;
    }


    public void gainSmallXP() {

        this.info.gainExperience(100);
    }

    public void gainMediumXP() {

        this.info.gainExperience(200);
    }

    public void gainBossXP() {

        this.info.gainExperience(500);
    }




    public int nextLevelXP() {

        return 1000 * this.getLevel();
    }




    /**
     * Used by entities that cause the player damage.
     *
     * @param amount damage taken
     */
    public void takeDamage(int amount) {

        // Update HP to amount after subtracting damage
        int currentHP = this.stats.getCurrentHP() - amount;
        this.stats.setCurrentHP(currentHP);

        // Display how much damage was done by attack
        System.out.println("The attack hits you for " + amount + " damage!");

        // Display remaining hp to player
        System.out.println("Remaining hit points: " + this.getCurrentHP() + "/" + this.getMaxHP());

        // check to see if damage kills player and set hp to 0
        if (currentHP <= 0) {
            System.out.println("The damage is fatal.");
            this.stats.setCurrentHP(0);
        }
    }

    /**
     * Used by entites that cause the character to gain HP.
     *
     * @param amount hp gained
     */
    public void healPlayer(int amount) {

        int newHp = this.stats.getCurrentHP() + amount;

        // if healing would bring player over max hp, just set hp to max
        this.stats.setCurrentHP(Math.min(newHp, this.stats.getMaxHP()));
    }


    public void applyPower() {
        DungeonUtil.printSpacer();
        DungeonUtil.printSpecialAbilityWrapper();

        System.out.println("You feel a presence come from deep within the dungeon. An overwhelming feeling of "
                + "joy washes over you, then.. power. It beckons you onward... \n");
        System.out.println("All stats increase by 1");
        System.out.println("HP increases by 10\n");
        
        DungeonUtil.printSpecialAbilityWrapper();

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
            int hpGained = DungeonUtil.rollAD10();

            System.out.println("You drink a potion of healing and restore "
                    + hpGained + " hit points!");

            healPlayer(hpGained);

            System.out.println("Remaining hit points: " + getCurrentHP() + "/" + getMaxHP());

        } else {

            System.out.println("You rummage through your sack but find no potions");
        }


    }


    // Spenders
    public boolean spendUltimateCharge() {

        return info.spendUltimateCharge();
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

    public int getCurrentXP() {
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


    public int getCurrentHP() {
        return stats.getCurrentHP();
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

