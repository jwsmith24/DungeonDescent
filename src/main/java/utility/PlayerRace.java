package utility;

public enum PlayerRace {
    ORC("Orc", "+2 to HP"),
    HUMAN("Human", "+2 to ATK"),
    DEMON("Demon", "+2 to SPD"),
    ELF("Elf", "+2 to ENG"),
    GNOME("Gnome", "+2 to LUC"),
    NEW_CHARACTER("Character does not have a race yet", "+99 to existence");

    private final String raceDescription;
    private final String racialBonusText;

    // Add the reference to STAT_BONUS under the race enum as well. Allows it to be changed
    // independently in the future if desired.
    public static final int STAT_BONUS = PlayerClass.STAT_BONUS;

    PlayerRace(String raceDescription, String racialBonusText) {
        this.raceDescription = raceDescription;
        this.racialBonusText = racialBonusText;
    }


    public String getRaceDescription() {
        return raceDescription;
    }

    public String getRacialBonusText() {
        return racialBonusText;
    }

}
