package character;

import utility.CharacterSheetBuilder;
import utility.index.PlayerRace;

/**
 * Provides race-specific functionality to a character.
 */
public class RaceDecorator extends CharacterDecorator {

    Character decoratedRace;
    PlayerRace playerRace;

    /**
     * Stores reference to the wrapped object and filters overrides based on race selection.
     */
    public RaceDecorator(Character characterRef, PlayerRace playerRace) {
        super(characterRef);
        decoratedRace = characterRef;
        this.playerRace = playerRace;
    }

    // Generic Racial Overrides

    @Override
    public String getPlayerRace() {
        return playerRace.getRaceDescription();
    }

    @Override
    public String getRacialAbility() {
        return playerRace.getRacialBonusText();
    }

    @Override
    public String getCharacterSheet() {

        return decoratedRace.getCharacterSheet() + CharacterSheetBuilder.buildRaceSection(this);
    }


    // Race-specific overrides

    @Override
    public int getHitPoints() {
        if (playerRace == PlayerRace.ORC) {
            return decoratedRace.getHitPoints() + PlayerRace.STAT_BONUS;
        }
        return decoratedRace.getHitPoints();
    }

    @Override
    public int getAttack() {
        if (playerRace == PlayerRace.HUMAN) {
            return decoratedRace.getAttack() + PlayerRace.STAT_BONUS;
        }
        return decoratedRace.getAttack();
    }

    @Override
    public int getEnergy() {
        if (playerRace == PlayerRace.ELF) {
            return decoratedRace.getEnergy() + PlayerRace.STAT_BONUS;
        }
        return decoratedRace.getEnergy();
    }

    @Override
    public int getSpeed() {
        if (playerRace == PlayerRace.DEMON) {
            return decoratedRace.getSpeed() + PlayerRace.STAT_BONUS;
        }
        return decoratedRace.getSpeed();
    }

    @Override
    public int getLuck() {
        if (playerRace == PlayerRace.GNOME) {
            return decoratedRace.getLuck() + PlayerRace.STAT_BONUS;
        }
        return decoratedRace.getLuck();
    }
}
