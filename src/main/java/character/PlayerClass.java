package character;

/**
 * Contains all character class options in the game.
 */
public enum PlayerClass {

    NO_CLASS("Player does not have a class yet", "unarmed strike", "make a joke"),
    WARRIOR("Warrior", "sword strike", "thunderous smash"),
    MAGE("Mage", "fire bolt", "sneak attack"),
    THIEF("Thief", "dagger strike", "fire storm"),
    PRIEST("Priest", "smite", "holy spirit");


    private final String classDescription;
    private final String attackText;
    private final String specialAbilityText;
    public static final int STAT_BONUS = 2;


    PlayerClass(String classDescription, String attackText, String specialAbilityText){
        this.classDescription = classDescription;
        this.attackText = attackText;
        this.specialAbilityText = specialAbilityText;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public String getAttackText() {
        return attackText;
    }

    public String getSpecialAbilityText() {
        return specialAbilityText;
    }


}
