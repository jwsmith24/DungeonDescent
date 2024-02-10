package character;


public class Orc extends ClassDecorator {

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
        return decoratedOrc.getCharacterSheet() + String.format(

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

                , GameConstants.ORC, GameConstants.ORC_RACIAL, decoratedOrc.getAttack(), decoratedOrc.getDefense(),
                this.getHitPoints(), decoratedOrc.getEnergy(), decoratedOrc.getSpeed(), decoratedOrc.getLuck()
        );

    }
}