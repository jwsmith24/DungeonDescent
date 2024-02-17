import character.*;
import character.Character;
import utility.CharacterBuilder;
import utility.index.PlayerClass;
import utility.index.PlayerRace;

public abstract class AdventurerTests {

    Adventurer player = spawnCharacter();

    /**
     * Helper method to spawn in a test Player named "Cloud".
     * @return Adventurer named Cloud
     */
    public Adventurer spawnCharacter() {
        // Spawn character
        Character testPlayer = new BasicCharacter("Cloud");
        testPlayer = new RaceDecorator(testPlayer, PlayerRace.HUMAN);
        testPlayer = new ClassDecorator(testPlayer, PlayerClass.WARRIOR);

        return CharacterBuilder.spawnCharacter(testPlayer);
    }


}
