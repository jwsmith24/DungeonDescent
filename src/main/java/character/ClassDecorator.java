package character;

import java.util.ArrayList;

/**
 * <p>Template for decorator classes that will wrap the Basic Character.</p>
 *
 * <p>Fully implements Character to ensure it knows all of the functionality, but is abstract
 * so that each decorator class only has to override the methods that it will be augmenting.</p>
 */
public abstract class ClassDecorator implements Character {

    // Stores reference to wrapped class that it's decorating.
    Character decoratedCharacter;

    /**
     * Constructor for the base decorator class.
     * @param decoratedCharacter reference to next object in the decorator chain.
     */
    public ClassDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }

    // Getters for Core Stats

    @Override
    public int getAttack() {
        return decoratedCharacter.getAttack();
    }

    @Override
    public int getDefense() {
        return decoratedCharacter.getDefense();
    }

    @Override
    public int getHitPoints() {
        return decoratedCharacter.getHitPoints();
    }

    @Override
    public int getEnergy() {
        return decoratedCharacter.getEnergy();
    }

    @Override
    public int getSpeed() {
        return decoratedCharacter.getSpeed();
    }

    @Override
    public int getLuck() {
        return decoratedCharacter.getLuck();
    }

    // Getters for Skills

    @Override
    public int getDungeoneering() {
        return decoratedCharacter.getDungeoneering();
    }

    @Override
    public int getLockPicking() {
        return decoratedCharacter.getLockPicking();
    }

    @Override
    public int getAthletics() {
        return decoratedCharacter.getAthletics();
    }

    @Override
    public int getArcana() {
        return decoratedCharacter.getArcana();
    }

    @Override
    public int getHistory() {
        return decoratedCharacter.getHistory();
    }

    // Getters for Player Info

    @Override
    public String getName() {
        return decoratedCharacter.getName();
    }

    @Override
    public int getExperience() {
        return decoratedCharacter.getExperience();
    }

    @Override
    public int getLevel() {
        return decoratedCharacter.getLevel();
    }

    @Override
    public ArrayList<Condition> getActiveEffects() {
        return decoratedCharacter.getActiveEffects();
    }

    @Override
    public String getPlayerClass() {
        return decoratedCharacter.getPlayerClass();
    }

    @Override
    public String getAttackType() {
        return decoratedCharacter.getAttackType();
    }

    @Override
    public String getSpecialAbility() {
        return decoratedCharacter.getSpecialAbility();
    }

    @Override
    public String getPlayerRace() {
        return decoratedCharacter.getPlayerRace();
    }

    @Override
    public String getRacialAbility() {
        return decoratedCharacter.getRacialAbility();
    }

    /**
     * Builds part of the character sheet at each tier of decoration.
     * @return character sheet string
     */
    @Override
    public String getCharacterSheet() {
        return null;
    }



}
