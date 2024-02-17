package character;

/**
 * Builder for character skills.
 */
public class CharacterSkills {

    // Skills
    private int dungeoneering;
    private int lockPicking;
    private int athletics;
    private int arcana;
    private int history;

    // Constructor
    public CharacterSkills(int dungeoneering, int lockPicking, int athletics, int arcana, int history) {
        this.dungeoneering = dungeoneering;
        this.lockPicking = lockPicking;
        this.athletics = athletics;
        this.arcana = arcana;
        this.history = history;
    }

    public static CharacterSkills skillBuilder(Character character) {

        return new CharacterSkills(

                character.getDungeoneering(),
                character.getLockPicking(),
                character.getAthletics(),
                character.getArcana(),
                character.getHistory()
        );
    }



    public int getDungeoneering() {
        return dungeoneering;
    }

    protected void modDungeoneering(int amount) {
        this.dungeoneering += amount;
    }


    public int getLockPicking() {
        return lockPicking;
    }

    protected void modLockPicking(int amount) {
        this.lockPicking += amount;
    }


    public int getAthletics() {
        return athletics;
    }

    protected void modAthletics(int amount) {
        this.athletics += amount;
    }


    public int getArcana() {
        return arcana;
    }

    protected void modArcana(int amount) {
        this.arcana += amount;
    }


    public int getHistory() {
        return history;
    }

    protected void modHistory(int amount) {
        this.history += amount;
    }

}
