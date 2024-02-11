package utility;

import character.Adventurer;
import character.Character;

public class CharacterBuilder {

    // Essentially needs to hard copy the final state of the wrapped/decorated player object

    public static Adventurer adventurerBuilder(Character characterRef) {

        // Create Adventurer object that captures state of decorated object
        Adventurer newPlayer = new Adventurer();

        // Extract Stats
        newPlayer.setAttack(characterRef.getAttack());
        newPlayer.setDefense(characterRef.getDefense());
        newPlayer.setHitPoints(characterRef.getHitPoints());
        newPlayer.setEnergy(characterRef.getEnergy());
        newPlayer.setSpeed(characterRef.getSpeed());
        newPlayer.setLuck(characterRef.getLuck());

        // Extract Skills
        newPlayer.setDungeoneering(characterRef.getDungeoneering());
        newPlayer.setLockPicking(characterRef.getLockPicking());
        newPlayer.setAthletics(characterRef.getAthletics());
        newPlayer.setArcana(characterRef.getArcana());
        newPlayer.setHistory(characterRef.getHistory());

        // Extract Info
        newPlayer.setName(characterRef.getName());
        newPlayer.setCharacterSheet(characterRef.getCharacterSheet());
        newPlayer.setRace(characterRef.getPlayerRace());
        newPlayer.setRacialAbility(characterRef.getRacialAbility());

        newPlayer.setPlayerClass(characterRef.getPlayerClass());
        newPlayer.setSpecialAbility(characterRef.getSpecialAbility());
        newPlayer.setAttackType(characterRef.getAttackType());

        newPlayer.setExperience(characterRef.getExperience());
        newPlayer.setLevel(characterRef.getLevel());
        newPlayer.setActiveEffects(characterRef.getActiveEffects());



        return newPlayer;
    }

}
