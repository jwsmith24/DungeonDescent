package character;


/**
 * Warrior decorator class.
 */
public class Warrior extends ClassDecorator {

    Character decoratedWarrior;
    /**
     * A Warrior get +2 to athletics and has a unique special ability.
     * @param characterRef reference to character
     */
    public Warrior(Character characterRef) {
        super(characterRef);
        decoratedWarrior = characterRef;
    }

    @Override
    public String getPlayerClass() {
        return GameConstants.WARRIOR;
    }
    @Override
    public String getAttackType() {

        return GameConstants.WARRIOR_ATTACK;

    }

    @Override
    public int getAthletics() {

        return decoratedWarrior.getAthletics() + GameConstants.STAT_BONUS;
    }

    @Override
    public String getSpecialAbility() {

        return GameConstants.WARRIOR_SPECIAL;
    }

    @Override
    public String getCharacterSheet() {
        return decoratedWarrior.getCharacterSheet() + CharacterSheetBuilder.buildClassSection(this);
    }

}
