package character;

/**
 * Base class decorator. Can be extended to augment a player's stats based on race, class, and background.
 */
public abstract class ClassDecorator implements Character {

    Character decoratedCharacter; // Store reference to decorator object

    /**
     * Constructor for the base decorator class.
     * @param decoratedCharacter reference to next object in the decorator chain.
     */
    public ClassDecorator(Character decoratedCharacter) {
        this.decoratedCharacter = decoratedCharacter;
    }

    /**
     * Builds part of the character sheet at each tier of decoration.
     * @return character sheet string
     */
    @Override
    public String getCharacterSheet() {
        return null;
    }








   // Getters & Setters

    @Override
    public String getName() {
        return decoratedCharacter.getName();
    }

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
    public int getExperience() {
        return decoratedCharacter.getExperience();
    }

    @Override
    public String getSpecialAbility() {
        return decoratedCharacter.getSpecialAbility();
    }


    @Override
    public String getRacialAbility() {
        return decoratedCharacter.getRacialAbility();
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
    public String getPlayerRace() {
        return decoratedCharacter.getPlayerRace();
    }


}