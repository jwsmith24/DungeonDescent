package character;

public class Demon extends ClassDecorator{
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

        return decoratedDemon.getCharacterSheet() + String.format(

                "======================\n" +
                        "| Race: %s\n" +
                        "| Racial ability: %s\n" +
                        "======================\n" +
                        "|\tStats\n" +
                        "======================\n" +
                        "| Attack: %s\n" +
                        "| Defence: %s\n" +
                        "| Hit Points: %s\n" +
                        "| Energy: %s\n" +
                        "| Speed: %s\n" +
                        "| Luck: %s\n"

                , this.getPlayerRace(), this.getRacialAbility(), this.getAttack(), this.getDefense(),
                this.getHitPoints(), this.getEnergy(), this.getSpeed(), this.getLuck()
        );

    }
}
