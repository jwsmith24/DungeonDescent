package character;

import utility.DungeonUtil;
import utility.index.Condition;
import utility.index.PlayerClass;
import utility.index.PlayerRace;
import utility.index.PlayerSkills;

/**
 * Encapsulates a character after it is constructed to be more maintainable when interacting with
 * the rest of the environment and reduce overhead of more decorators.
 */
public class Adventurer {

    private final CharacterInfo info;
    private final CharacterStats stats;
    private final CharacterSkills skills;
    private final CharacterActiveEffects activeEffects;
    private int itemAttackBonus;
    private int itemArmorBonus;


    /**
     * Default constructor, Adventurers are built with the character builder classes.
     */
    public Adventurer(CharacterInfo info, CharacterStats stats, CharacterSkills skills,
                      CharacterActiveEffects activeEffects) {
        this.info = info;
        this.stats = stats;
        this.skills = skills;
        this.activeEffects = activeEffects;

    }

    /**
     * Calculates attack and armor bonus from current equipment.
     */
    public void updateItemBonuses() {

        itemAttackBonus = PlayerInventory.getItemAttackBonus();
        itemArmorBonus = PlayerInventory.getItemArmorBonus();
    }

    /**
     * Calculates damage of basic attack roll and displays result.
     * @return damage roll
     */
    public int basicAttackRoll() {
        // roll a d20 and add player attack bonus + level
        int attackRoll = DungeonUtil.rollAD20()
                + stats.getAttack() + info.getLevel() + itemAttackBonus;

        System.out.println("\nYou attack with: " + info.getPlayerClass().getAttackText());
        System.out.println("You rolled a " + attackRoll + " to hit!");

        return attackRoll;
    }

    /**
     * Calculates damage of a normal attack roll.
     */
    public int basicAttackDamage() {
        int result = DungeonUtil.rollAD10() + stats.getAttack() + info.getLevel();

        System.out.println("Your attack hits for " + result + " damage!");

        return result;
    }

    /**
     * calculates damage on a critical hit.
     */
    public int basicAttackCriticalStrike() {
        int result = (DungeonUtil.rollAD20() + stats.getAttack() + info.getLevel()) * 2;

        System.out.println("Your attack hits for " + result + " damage!");

        return result;
    }

    /**
     * If player has charges to use, calculate special ability damage. Otherwise, return 0 damage.
     * @return special ability damage.
     */
    public int useSpecialAttack() {

        if (info.spendUltimateCharge()) {

            DungeonUtil.printSpecialWrapper();
            System.out.println("You use: " + info.getPlayerClass().getSpecialAbilityText());
            DungeonUtil.printSpecialWrapper();

            // special deals double damage and is guaranteed to hit
            int result = 2 * (DungeonUtil.rollAD10() + stats.getAttack());

            // display damage and remaining charges for special ability
            System.out.println("Your special attack hits for " + result + " damage!");

            System.out.println("Ultimate Charges Remaining: " + getUltimateCharges());

            return result;

        } else {

            System.out.println("Out of ultimate charges until next long rest");
            System.out.println("Using basic attack instead");

            return 0;
        }
    }

    /**
     * Handles player rolling a skill check for the passed skill.
     * @param skill skill used for the check
     * @return result of the skill check
     */
    public int rollSkillCheck(PlayerSkills skill) {

        int roll = DungeonUtil.rollAD20();

        switch (skill) {
            case ARCANA:
                roll += skills.getArcana();
                break;
            case ATHLETICS:
                roll += skills.getAthletics();
                break;
            case HISTORY:
                roll += skills.getHistory();
                break;
            case DUNGEONEERING:
                roll += skills.getDungeoneering();
                break;
            case LOCK_PICKING:
                roll += skills.getLockPicking();
                break;
            default:
                roll += 1;
        }

        System.out.println("Roll for " + skill.name() + "!");
        System.out.println("Result: " + roll);

        return roll;


    }


    /**
     * Resets hp to max hp, resets ultimate charges, and clears conditions.
     */
    public void takeLongRest() {
        System.out.println("You find a cozy spot to rest");

        healPlayer(this.getMaxHp());
        this.regainUltimate();
        activeEffects.applyCondition(Condition.NEUTRAL);

        System.out.println("HP restored to full");
        System.out.println("Ultimate Charges Reset");
        System.out.println("Conditions have been cleared");

    }

    /**
     * Allows other entities to trigger player regaining their ultimate charges.
     * Ultimate charges are based on energy score.
     */
    public void regainUltimate() {

        while (info.getUltimateCharges() < stats.getEnergy()) {

            info.gainUltimateCharge();
        }
    }

    /**
     * Determines if player is still alive.
     */
    public boolean isAlive() {
        return stats.getCurrentHitPoints() > 0;
    }

    /**
     * Apply xp = current rate of small monster.
     */
    public void gainSmallXp() {
        int xp = DungeonUtil.SMALL_XP;


        System.out.println("You gained " + xp + " XP!");
        this.info.gainExperience(DungeonUtil.SMALL_XP);
    }

    /**
     * Apply xp = current rate of medium monster.
     */
    public void gainMediumXp() {
        int xp = DungeonUtil.MED_XP;

        System.out.println("You gained " + xp + " XP!");
        this.info.gainExperience(DungeonUtil.MED_XP);
    }

    /**
     * Apply boss xp to player.
     */
    public void gainBossExperience() {
        int xp = DungeonUtil.BOSS_XP;

        System.out.println("You gained " + xp + " XP!");
        this.info.gainExperience(DungeonUtil.BOSS_XP);
    }


    /**
     * XP to next level = next level * 100
     * Ex: Level 2 player needs to acquire 300 xp to level up.
     * @return total xp required for next level
     */
    public int nextLevelXp() {

        return 100 * (this.getLevel() + 1);
    }

    /**
     * If player meets conditions to level up, increase level.
     */
    public void checkLevelUp() {
        // if current xp > amount needed to level up, apply level up

        if (getCurrentXp() >= nextLevelXp()) {

            info.gainLevel();

            DungeonUtil.printSpecialWrapper();
            System.out.println("Ding! Level " + getLevel() + " acquired!");
            DungeonUtil.printSpecialWrapper();

            info.resetExperience();
        }


    }

    /**
     * Allows other classes to check if a player has a condition.
     *
     * @return if player has condition
     */
    public boolean hasCondition(Condition condition) {
        return activeEffects.hasCondition(condition);
    }

    /**
     * Applies new condition to player unless the condition is already present.
     * If it's already present, informs the player.
     * @param condition new condition to be applied
     */
    public void applyCondition(Condition condition) {

        if (!hasCondition(condition)) {
            activeEffects.applyCondition(condition);

        } else {
            System.out.println(info.getName() + " is already affected by "
                    + condition.getDescription());
        }
    }

    /**
     * Allows other entities to trigger displaying active conditions to the player.
     */
    public void displayConditions() {
        activeEffects.displayConditions();
    }




    /**
     * Used by entities that cause the player damage. Subtracts armor bonus from
     * incoming damage.
     *
     * @param amount damage taken
     */
    public void takeDamage(int amount) {

        // subtract armor bonus from damage taken with minimum damage of 1
        int reducedDmg = Math.max(1, amount - itemArmorBonus);

        //apply damage to character
        stats.takeDamage(reducedDmg);

        // Display how much damage was done by attack
        System.out.println("The attack hits you for " + reducedDmg + " damage!");

        // Display remaining hp to player
        System.out.println("Remaining hit points: " + this.getCurrentHp() + "/" + this.getMaxHp());

        // check to see if damage kills player and set hp to 0
        if (getCurrentHp() <= 0) {
            System.out.println("The damage is fatal.");
            this.stats.zeroizeHitPoints();
        }
    }

    /**
     * Used by entities that cause the character to gain HP.
     *
     * @param amount hp gained
     */
    public void healPlayer(int amount) {

        // if healing would bring player over max hp, just set hp to max
        this.stats.restoreHitPoints(amount);
    }


    /**
     * Applies the stat boost to the player.
     */
    public void applyPower() {

        DungeonUtil.printSpecialWrapper();

        System.out.println("You feel a presence come from deep within the dungeon. "
                + "\nAn overwhelming feeling of joy washes over you, then.. power. "
                + "\nIt beckons you onward... ");

        System.out.println("All stats increase by 1");
        System.out.println("HP increases by 10\n");

        DungeonUtil.printSpecialWrapper();

        stats.applyPowerStatBoost();
    }


    /**
     * Use potion if player has one in inventory, otherwise default to basic attack.
     */
    public boolean drinkPotion() {

        if (PlayerInventory.consumePotion()) {
            int hpGained = DungeonUtil.rollAD10() + getLuck();

            System.out.println("You drink a potion of healing and restore "
                    + hpGained + " hit points!");

            healPlayer(hpGained);

            System.out.println("Remaining hit points: " + getCurrentHp() + "/" + getMaxHp());

            return true;

        } else {

            System.out.println("You rummage through your sack but find no potions");
            System.out.println("Using basic attack instead");
            return false;
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

    public int getCurrentXp() {
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


    public int getArmorClass() {
        return stats.getArmorClass();
    }


    public int getCurrentHp() {
        return stats.getCurrentHitPoints();
    }


    public int getMaxHp() {
        return stats.getMaxHitPoints();
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

