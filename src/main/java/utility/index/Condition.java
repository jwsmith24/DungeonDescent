package utility.index;

import character.Adventurer;

import java.util.ArrayList;

/**
 * Possible Player/Enemy Conditions with descriptions.
 */
public enum Condition {
    POISONED("Character is poisoned. Effects: -1 to attack rolls and ability checks."),
    STUNNED("Character is stunned. Effects: Incapacitated, can't move."),
    BLINDED("Character is blinded. "
            + "Effects: Can't see and automatically fails any ability check that requires sight."),
    RESTRAINED("Character is restrained. "
            + "Effects: Speed becomes 0, can't benefit from any bonus to speed."),
    PARALYZED("Character is paralyzed. Effects: Incapacitated and can't move or speak."),
    NEUTRAL("Character does not have any active conditions.");


    //todo: add positive conditions!

    //todo: add random condition method?

    private final String description;

    Condition(String description) {
        this.description = description;
    }

    /**
     * Can be implemented to provided help text.
     * @return condition description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Adds new condition to a character's list of active effects
     * or clears list if condition is set to neutral.
     */

    public void applyCondition(Adventurer affectedCharacter, Condition newCondition) {

        // Get the list of existing conditions from previous wrapper, and then decide what to do!
        ArrayList<Condition> existingEffects = affectedCharacter.getActiveEffects();

        // If applying the NEUTRAL condition, we need to clear the list of active effects

        if (newCondition == Condition.NEUTRAL) {
            existingEffects.clear();
            existingEffects.add(Condition.NEUTRAL);

        } else {

            // If character is neutral, need to remove it before applying new effect
            existingEffects.removeIf(condition -> condition == Condition.NEUTRAL);

            // Using the removeIf from Iterator instead of an enhanced for loop is safe
            // to use during concurrent iteration

            // Apply new effect
            existingEffects.add(newCondition);

        }



    }


}
