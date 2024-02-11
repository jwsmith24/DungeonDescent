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

        return decoratedHuman.getCharacterSheet() + String.format(

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