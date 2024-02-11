import character.*;
import character.Character;
import org.junit.jupiter.api.Test;
import utility.CharacterBuilder;
import utility.PlayerClass;
import utility.PlayerRace;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerShellTest {

    @Test
    void testAdventurerEncapsulation() {
        // Make Cloud, a Human Warrior
        Character cloud = new BasicCharacter("cloud");
        cloud = new RaceDecorator(cloud, PlayerRace.HUMAN);
        cloud = new ClassDecorator(cloud, PlayerClass.WARRIOR);

        // Once character creation is done, we want to capture the state of the object so that
        // updating conditions, level, experience, etc. doesn't scale out of control.

        Adventurer dungeonCloud = CharacterBuilder.adventurerBuilder(cloud);
        System.out.println(dungeonCloud.getCharacterSheet());


        assertEquals(cloud.getAttack(), dungeonCloud.getAttack(), "Attack scores differ");
        assertEquals(cloud.getCharacterSheet(), dungeonCloud.getCharacterSheet(), "Character sheet strings are different");
        assertEquals(cloud.getPlayerRace(), dungeonCloud.getPlayerRace(), "races do not match");
        assertEquals(cloud.getPlayerClass(), dungeonCloud.getPlayerClass(), "classes do not match");

    }
}
