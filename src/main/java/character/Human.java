package character;


public class Human extends ClassDecorator {

    Character decoratedHuman;
    /**
     * An Orc gains a bonus to HP and has a unique racial ability.
     *
     * @param decoratedCharacter reference to next object in the decorator chain.
     */
    public Human(Character decoratedCharacter) {
        super(decoratedCharacter);
        decoratedHuman = decoratedCharacter;
    }

    // Orc overrides
    @Override
    public String getPlayerRace() {

        return GameConstants.HUMAN;
    }

    @Override
    public int getAttack(){
        return decoratedHuman.getAttack() + GameConstants.STAT_BONUS;
    }

    @Override
    public String getRacialAbility() {
        return GameConstants.HUMAN_RACIAL;
    }

    /**
     * Adds race and racial ability to character sheet.
     * @return updated character sheet.
     */
    @Override
    public String getCharacterSheet() {

        return decoratedHuman.getCharacterSheet() + CharacterSheetBuilder.buildRaceSection(this);

    }
}