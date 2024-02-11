package character;

public class Thief extends ClassDecorator {

    Character decoratedThief;

    /**
     * A Thief gets a +2 bonus to lockpicking and has a unique special ability.
     */
    public Thief(Character characterRef) {
        super(characterRef);
        decoratedThief = characterRef;
    }

    @Override
    public String getPlayerClass() {
        return GameConstants.THIEF;
    }
    @Override
    public String getAttackType() {

        return GameConstants.THIEF_ATTACK;

    }

    @Override
    public int getLockPicking() {

        return decoratedThief.getLockPicking() + GameConstants.STAT_BONUS;
    }

    @Override
    public String getSpecialAbility() {

        return GameConstants.THIEF_SPECIAL;
    }

    @Override
    public String getCharacterSheet() {
        return decoratedThief.getCharacterSheet() + CharacterSheetBuilder.buildClassSection(this);
    }

}
