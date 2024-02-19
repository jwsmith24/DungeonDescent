package character;

import utility.CharacterSheetBuilder;
import utility.index.PlayerClass;

/**
 * Provides class-specific functionality to a character.
 */
public class ClassDecorator extends CharacterDecorator {

    Character decoratedClass;
    PlayerClass playerClass;

    /**
     * Stores reference to the wrapped object and filters overrides based on class selection.
     */
    public ClassDecorator(Character characterRef, PlayerClass playerClass) {
        super(characterRef);
        decoratedClass = characterRef;
        this.playerClass = playerClass;
    }

    /**
     * Returns the new class description.
     */
    @Override
    public PlayerClass getPlayerClass() {

        return playerClass;
    }



    @Override
    public String getCharacterSheet() {
        return decoratedClass.getCharacterSheet() + CharacterSheetBuilder.buildClassSection(this);
    }



    // Override skill getters based on class

    @Override
    public int getArcana() {
        if (playerClass == PlayerClass.MAGE) {
            return decoratedClass.getArcana() + PlayerClass.STAT_BONUS;
        }
        return decoratedClass.getArcana();
    }

    @Override
    public int getHistory() {
        if (playerClass == PlayerClass.PRIEST) {
            return decoratedClass.getHistory() + PlayerClass.STAT_BONUS;
        }
        return decoratedClass.getHistory();
    }

    @Override
    public int getAthletics() {
        if (playerClass == PlayerClass.WARRIOR) {
            return decoratedClass.getAthletics() + PlayerClass.STAT_BONUS;
        }
        return decoratedClass.getAthletics();
    }

    @Override
    public int getLockPicking() {
        if (playerClass == PlayerClass.THIEF) {
            return decoratedClass.getLockPicking() + PlayerClass.STAT_BONUS;
        }
        return decoratedClass.getLockPicking();
    }




}
