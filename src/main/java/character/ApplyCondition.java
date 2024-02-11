package character;

import java.util.ArrayList;

public class ApplyCondition extends ClassDecorator{

    Character affectedCharacter;
    Condition newCondition;

    /**
     * This decorator applies a condition effect to the player.
     *
     * @param decoratedCharacter reference to next object in the decorator chain.
     */
    public ApplyCondition(Character decoratedCharacter, Condition condition) {
        super(decoratedCharacter);
        this.affectedCharacter = decoratedCharacter;
        newCondition = condition;
    }

    /**
     * Adds new condition to a character's list of active effects
     * or clears list if condition is set to neutral.
     * @return list of active effects
     */
    @Override
    public ArrayList<Condition> getActiveEffects() {

        // Get the list of existing conditions from previous wrapper, and then decide what to do!
        ArrayList<Condition> existingEffects = affectedCharacter.getActiveEffects();

        // If applying the NEUTRAL condition, we need to clear the list of active effects
        if (newCondition == Condition.NEUTRAL){
            existingEffects.clear();
            existingEffects.add(Condition.NEUTRAL);

        } else {

            // If character is neutral, need to remove that entry before applying new effect
            existingEffects.removeIf(condition -> condition == Condition.NEUTRAL);

            // Using the removeIf from Iterator instead of an enhanced for loop is safe
            // to use during concurrent iteration

            // Apply new effect
            existingEffects.add(newCondition);

        }

        // And give it back
        return existingEffects;

    }
}
