package dungeon;

import utility.index.Condition;
import utility.index.PlayerSkills;

public abstract class Trap {

    private final Condition effectType;
    private final int damage;
    private final int difficultyCheck;
    private final PlayerSkills skillCheckType;
    private final String discoveryText;
    private final String successText;
    private final String failureText;
    private final String surpriseText;

    public Trap(Condition effectType, int damage, PlayerSkills skillCheckType, String discoveryText,
                String successText, String failureText, String surpriseText, int difficultyCheck) {
        this.effectType = effectType;
        this.damage = damage;
        this.skillCheckType = skillCheckType;
        this.discoveryText = discoveryText;
        this.successText = successText;
        this.failureText = failureText;
        this.surpriseText = surpriseText;
        this.difficultyCheck = difficultyCheck;
    }

    public boolean doesPlayerBeatAC(int result){
        return result >= difficultyCheck;
    }

    public PlayerSkills getSkillCheckType() {
        return skillCheckType;
    }

    public int getDamage() {
        return damage;
    }

    public Condition getEffectType(){
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
