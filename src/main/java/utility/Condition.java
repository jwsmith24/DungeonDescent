package utility;

/**
 * Possible Player/Enemy Conditions
 */
public enum Condition {
    POISONED("Character is poisoned. Effects: -1 to attack rolls and ability checks."),
    STUNNED("Character is stunned. Effects: Incapacitated, can't move."),
    BLINDED("Character is blinded. Effects: Can't see and automatically fails any ability check that requires sight."),
    RESTRAINED("Character is restrained. Effects: Speed becomes 0, can't benefit from any bonus to speed."),
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


}
