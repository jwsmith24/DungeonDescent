package character;



/**
 * Mage decorator class.
 */
public class Mage extends ClassDecorator {

    Character decorated_mage;
    /**
     * A Mage has a unique special and their stats don't change from the base.
     * @param characterRef base player object.
     */
    public Mage(Character characterRef) {

        super(characterRef);
        decorated_mage = characterRef;
    }

    @Override
    public String getAttackType() {
        return GameConstants.MAGE_ATTACK;
    }

    @Override
    public String getPlayerClass() {

        return GameConstants.MAGE;
    }

    @Override
    public String getSpecialAbility() {
        return GameConstants.MAGE_SPECIAL;
    }

    @Override
    public String getCharacterSheet() {
        return decorated_mage.getCharacterSheet() + String.format(
                "======================\n" +
                "Class: %s\n" +
                "Attack Type: %s\n" +
                "Special Ability: %s\n"

                , GameConstants.MAGE, GameConstants.MAGE_ATTACK, GameConstants.MAGE_SPECIAL
        );
    }


}