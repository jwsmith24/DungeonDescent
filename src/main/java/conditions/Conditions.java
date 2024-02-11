package conditions;

/**
 * Possible Player/Enemy Conditions
 */
public enum Conditions {
    POISONED("Character is poisoned. Effects: -1 to attack rolls and ability checks."),
    STUNNED("Character is stunned. Effects: Incapacitated, can't move."),
    BLINDED("Character is blinded. Effects: Can't see and automatically fails any ability check that requires sight."),
    RESTRAINED("Character is restrained. Effects: Speed becomes 0, can't benefit from any bonus to speed."),
    PARALYZED("Character is paralyzed. Effects: Incapacitated and can't move or speak."),
    NEUTRAL("Character does not have any active conditions.");

    //todo: add positive conditions!



    private final String description;

    Conditions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}
