package character;

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

    public void setDungeoneering(int dungeoneering) {
        this.dungeoneering = dungeoneering;
    }


    public int getLockPicking() {
        return lockPicking;
    }

    public void setLockPicking(int lockPicking) {
        this.lockPicking = lockPicking;
    }


    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }


    public int getArcana() {
        return arcana;
    }

    public void setArcana(int arcana) {
        this.arcana = arcana;
    }


    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

}
