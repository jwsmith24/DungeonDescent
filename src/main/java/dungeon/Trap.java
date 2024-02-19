package dungeon;

import utility.index.Condition;
import utility.index.PlayerSkills;

public abstract class Trap {

    private final Condition effectType;
    private final int damage;
    private final int difficultyCheck;
    private final String name;
    private final PlayerSkills skillCheckType;
    private final String discoveryText;
    private final String successText;
    private final String failureText;
    private final String surpriseText;

    /**
     * Trap constructor.
     */
    public Trap(String name, Condition effectType, int damage,
                PlayerSkills skillCheckType, String discoveryText,
                String successText, String failureText, String surpriseText, int difficultyCheck) {

        this.name = name;
        this.effectType = effectType;
        this.damage = damage;
        this.skillCheckType = skillCheckType;
        this.discoveryText = discoveryText;
        this.successText = successText;
        this.failureText = failureText;
        this.surpriseText = surpriseText;
        this.difficultyCheck = difficultyCheck;
    }

    /**
     * Checks if player beats the trap DC.
     */
    public boolean doesPlayerBeatArmorClass(int result) {
        return result >= difficultyCheck;
    }

    /**
     * Tells which skill to use for the trap DC.
     */
    public PlayerSkills getSkillCheckType() {
        return skillCheckType;
    }

    public int getDamage() {
        return damage;
    }

    public Condition getEffectType() {
        return effectType;
    }

    public int getDifficultyCheck() {
        return difficultyCheck;
    }

    public void displayDiscoveryText() {
        System.out.println(discoveryText);
    }

    public void displaySuccessText() {
        System.out.println(successText);
    }

    public void displayFailureText() {
        System.out.println(failureText);
    }

    public void displaySurpriseText() {
        System.out.println(surpriseText);
    }



}
