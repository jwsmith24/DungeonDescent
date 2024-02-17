package dungeon;

import utility.index.Condition;
import utility.index.PlayerSkills;

public abstract class Trap {

    Condition effectType;
    int damage;
    PlayerSkills skillCheckType;
    String discoveryText;
    String successText;
    String failureText;
    String surpriseText;

    public Trap(Condition effectType, int damage, PlayerSkills skillCheckType, String discoveryText,
                String successText, String failureText, String surpriseText) {
        this.effectType = effectType;
        this.damage = damage;
        this.skillCheckType = skillCheckType;
        this.discoveryText = discoveryText;
        this.successText = successText;
        this.failureText = failureText;
        this.surpriseText = surpriseText;
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

    public void displayDiscoveryText() {
        System.out.println(discoveryText);
    }

    public void displaySuccessText() {
        System.out.println(successText);
    }

    public void displayFailureText() {
        System.out.println(failureText);
    }


}
