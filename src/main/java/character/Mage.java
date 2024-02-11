package character;



/**
 * Mage decorator class.
 */
public class Mage extends CharacterDecorator {

    Character decoratedMage;
    /**
     * A Mage gets a +2 bonus to Arcana and has a unique ability.
     * @param characterRef base player object.
     */
    public Mage(Character characterRef) {

        super(characterRef);
        decoratedMage = characterRef;
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
        return decoratedMage.getArcana() + GameConstants.STAT_BONUS;
    }

    @Override
    public String getSpecialAbility() {
        return GameConstants.MAGE_SPECIAL;
    }

    @Override
    public String getCharacterSheet() {
        return decoratedMage.getCharacterSheet() + CharacterSheetBuilder.buildClassSection(this);
    }


}