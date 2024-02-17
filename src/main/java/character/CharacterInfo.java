package character;

import utility.index.PlayerClass;
import utility.index.PlayerRace;



/**
 * Builder for character info.
 */
public class CharacterInfo {

    private int experience;
    private int level;
    private String name;
    private PlayerRace race;
    private PlayerClass playerClass;
    private String characterSheet;
    private int ultimateCharges;



    public CharacterInfo(int experience, int level, String name, PlayerRace race, PlayerClass playerClass,
                         String characterSheet) {

        this.experience = experience;
        this.level = level;
        this.name = name;
        this.race = race;
        this.playerClass = playerClass;
        this.characterSheet = characterSheet;
        this.ultimateCharges = 1;

    }

    /**
     * Handles construction of the character's information
     * @param character
     * @return characterInfo object
     */
    public static CharacterInfo infoBuilder(Character character) {

        return new CharacterInfo(

                character.getExperience(),
                character.getLevel(),
                character.getName(),
                character.getPlayerRace(),
                character.getPlayerClass(),
                character.getCharacterSheet());

    }




    public String getName() {
        return name;
    }


    public int getExperience() {
        return experience;
    }

    public void gainExperience(int experience) {

        this.experience += experience;
    }


    public int getLevel() {
        return level;
    }

    /**
     * Increment player level by 1
     */
    public void gainLevel() {

        this.level += 1;
    }


    public PlayerRace getPlayerRace() {
        return race;
    }




    public PlayerClass getPlayerClass() {
        return playerClass;
    }



    public String getCharacterSheet() {
        return characterSheet;
    }

    public int getUltimateCharges() {
        return ultimateCharges;
    }
    public void gainUltimateCharge() {

        this.ultimateCharges += 1;

    }

    public boolean spendUltimateCharge() {
        if (ultimateCharges > 0) {
            this.ultimateCharges -= 1;
            return true;

        } else {
            System.out.println("You are out of ultimate charges");
            return false;
        }

    }


}
