package character;


import utility.CharacterSheetBuilder;
import utility.GameConstants;

public class Orc extends CharacterDecorator {

    Character decoratedOrc;
    /**
     * An Orc gains a bonus to HP and has a unique racial ability.
     *
     * @param decoratedCharacter reference to next object in the decorator chain.
     */
    public Orc(Character decoratedCharacter) {
        super(decoratedCharacter);
        decoratedOrc = decoratedCharacter;
    }

    // Orc overrides
    @Override
    public String getPlayerRace() {

        return GameConstants.ORC;
    }

    @Override
    public int getHitPoints(){
        return decoratedOrc.getHitPoints() + GameConstants.STAT_BONUS;
    }

    @Override
    public String getRacialAbility() {
        return GameConstants.ORC_RACIAL;
    }

    /**
     * Adds race and racial ability to character sheet.
     * @return updated character sheet.
     */
    @Override
    public String getCharacterSheet() {

        return decoratedOrc.getCharacterSheet() + CharacterSheetBuilder.buildRaceSection(this);

    }
}