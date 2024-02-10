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
        characterRef.setSpecialAbility(GameConstants.MAGE_SPECIAL);

        characterRef.setAttackType(GameConstants.MAGE_ATTACK);
        // need to override the getter methods instead, because updating them like this in the constructor doesn't work


    }

    @Override
    public String getAttackType() {
        return decorated_mage.getAttackType() + GameConstants.MAGE_ATTACK;
    }

    @Override
    public String getPlayerClass() {

        return GameConstants.MAGE;
    }

    @Override
    public String getSpecialAbility() {
        return decorated_mage.getSpecialAbility() + GameConstants.MAGE_SPECIAL;
    }


}