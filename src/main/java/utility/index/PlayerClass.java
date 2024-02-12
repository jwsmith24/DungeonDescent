package utility.index;

/**
 * Contains all character class options in the game.
 */
public enum PlayerClass {

    NO_CLASS("Player does not have a class yet", "unarmed strike", "No class, no bonus.", "make a joke"),
    WARRIOR("Warrior", "sword strike", "athletics *", "thunderous smash"),
    MAGE("Mage", "fire bolt", "arcana *", "fire storm"),
    THIEF("Thief", "dagger strike", "lockpicking *", "sneak attack"),
    PRIEST("Priest", "smite", "history *", "holy spirit");


    private final String classDescription;
    private final String attackText;
    private final String specialAbilityText;
    private final String classBonus;
    public static final int STAT_BONUS = 2;


    PlayerClass(String classDescription, String attackText, String classBonus, String specialAbilityText) {
        this.classDescription = classDescription;
        this.attackText = attackText;
        this.classBonus = classBonus;
        this.specialAbilityText = specialAbilityText;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public String getAttackText() {
        return attackText;
    }

    public String getClassBonus() {
        return classBonus;
    }

    public String getSpecialAbilityText() {
        return specialAbilityText;
    }


}
