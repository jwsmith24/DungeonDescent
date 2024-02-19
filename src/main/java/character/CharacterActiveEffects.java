package character;

import java.util.ArrayList;

import utility.index.Condition;


public class CharacterActiveEffects {

    private final ArrayList<Condition> activeEffects;


    public CharacterActiveEffects(ArrayList<Condition> activeEffects) {
        this.activeEffects = new ArrayList<>(activeEffects);
    }

    /**
     * Builder for Active Effects.
     */
    public static CharacterActiveEffects effectsBuilder(Character characterRef) {

        // wrap up character active effects into the effects class
        return new CharacterActiveEffects(characterRef.getActiveEffects());
    }

    /**
     * Applies new condition to character. If this is the first condition applied, remove neutral
     * and apply the new condition. If this is condition 2+, add the condition. Clearing conditions
     * is clearing the list and adding neutral to active effects.
     *
     * @param newCondition new condition to apply to character.
     */
    protected void applyCondition(Condition newCondition) {


        // If applying the NEUTRAL condition, we need to clear the list of active effects

        if (newCondition == Condition.NEUTRAL) {

            // Clear the list of all effects, add neutral
            activeEffects.clear();
            activeEffects.add(Condition.NEUTRAL);

            System.out.println("Conditions are cleared!");

        } else {
            // Remove neutral from list before applying new effect
            activeEffects.removeIf(condition -> condition == Condition.NEUTRAL);

            // Using the removeIf from Iterator instead of an enhanced for loop is safe
            // to use during concurrent iteration

            // Apply new effect
            activeEffects.add(newCondition);

            System.out.println("You are now " + newCondition.name());
            System.out.println(newCondition.getDescription());

        }


    }

    /**
     * If player has a certain condition, method will return true.
     */
    protected boolean hasCondition(Condition type) {

        for (Condition condition : this.activeEffects) {
            if (condition.equals(type)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Displays all the active conditions to the player.
     */
    protected void displayConditions() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("Active Conditions:");

        for (Condition condition : this.activeEffects) {
            System.out.println(condition.getDescription());
        }

        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    }

}
