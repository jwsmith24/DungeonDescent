package character;



/**
 * Mage decorator class.
 */
public class Mage extends ClassDecorator {

    Character decorated_mage;
    /**
     * A Mage gets a +2 bonus to Arcana and has a unique ability.
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
    public int getArcana() {
        return decorated_mage.getArcana() + GameConstants.STAT_BONUS;
    }

    @Override
    public String getSpecialAbility() {
        return GameConstants.MAGE_SPECIAL;
    }

    @Override
    public String getCharacterSheet() {
        return decorated_mage.getCharacterSheet() + String.format(
                "======================\n" +
                "| Class: %s\n" +
                "| Attack Type: %s\n" +
                "| Special Ability: %s\n"

                , GameConstants.MAGE, GameConstants.MAGE_ATTACK, GameConstants.MAGE_SPECIAL
        );
    }


}