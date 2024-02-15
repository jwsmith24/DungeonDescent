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



    public CharacterInfo(int experience, int level, String name, PlayerRace race, PlayerClass playerClass,
                         String characterSheet) {

        this.experience = experience;
        this.level = level;
        this.name = name;
        this.race = race;
        this.playerClass = playerClass;
        this.characterSheet = characterSheet;

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

    public void setName(String name) {
        this.name = name;
    }


    public void setRace(PlayerRace race) {
        this.race = race;
    }


    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public PlayerRace getPlayerRace() {
        return race;
    }




    public PlayerClass getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClass playerClass) {
        this.playerClass = playerClass;
    }


    public String getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(String characterSheet) {
        this.characterSheet = characterSheet;
    }


}
