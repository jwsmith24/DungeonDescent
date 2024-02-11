package character;

import utility.CharacterSheetBuilder;
import utility.GameConstants;

public class Demon extends CharacterDecorator {
    Character decoratedDemon;

    /**
     * A Demon gains a +2 bonus to speed and has a unique racial ability.
     *
     * @param decoratedCharacter reference to next object in the decorator chain.
     */
    public Demon(Character decoratedCharacter) {
        super(decoratedCharacter);
        decoratedDemon = decoratedCharacter;
    }


    // Demon Overrides

    @Override
    public String getPlayerRace() {
        return GameConstants.DEMON;
    }

    @Override
    public String getRacialAbility() {
        return GameConstants.DEMON_RACIAL;
    }

    /**
     * Applies the Demon racial bonus to speed.
     */
    @Override
    public int getSpeed() {
        return decoratedDemon.getSpeed() + GameConstants.STAT_BONUS;
    }

    /**
     * Adds race and racial ability to character sheet.
     * @return updated character sheet.
     */
    @Override
    public String getCharacterSheet() {

        return decoratedDemon.getCharacterSheet() + CharacterSheetBuilder.buildRaceSection(this);

    }
}
