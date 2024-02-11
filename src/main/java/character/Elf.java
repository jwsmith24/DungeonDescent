package character;


public class Elf extends ClassDecorator {

    Character decoratedElf;
    /**
     * An Elf gets a +2 bonus to Energy and has a unique special ability.
     *
     * @param decoratedCharacter reference to next object in the decorator chain.
     */
    public Elf(Character decoratedCharacter) {
        super(decoratedCharacter);
        decoratedElf = decoratedCharacter;
    }

    // Orc overrides
    @Override
    public String getPlayerRace() {

        return GameConstants.ELF;
    }

    @Override
    public int getEnergy(){
        return decoratedElf.getEnergy() + GameConstants.STAT_BONUS;
    }

    @Override
    public String getRacialAbility() {
        return GameConstants.ELF_RACIAL;
    }

    /**
     * Adds race and racial ability to character sheet.
     * @return updated character sheet.
     */
    @Override
    public String getCharacterSheet() {

        return decoratedElf.getCharacterSheet() + String.format(

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