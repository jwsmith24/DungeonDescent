package character;

public class Priest extends CharacterDecorator {

    Character decoratedPriest;

    /**
     * A Priest gets +2 to history and has a unique special ability
     */
    public Priest(Character characterRef) {
        super(characterRef);
        decoratedPriest = characterRef;
    }

    @Override
    public String getPlayerClass() {
        return GameConstants.PRIEST;
    }
    @Override
    public String getAttackType() {

        return GameConstants.PRIEST_ATTACK;

    }

    @Override
    public int getHistory() {

        return decoratedPriest.getHistory() + GameConstants.STAT_BONUS;
    }

    @Override
    public String getSpecialAbility() {

        return GameConstants.PRIEST_SPECIAL;
    }

    @Override
    public String getCharacterSheet() {
        return decoratedPriest.getCharacterSheet() + CharacterSheetBuilder.buildClassSection(this);
    }

}
