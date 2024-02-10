import character.*;
import character.Character;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class TestCharacterCreation {

    @Test
    void testMakeBasicCharacter() {

        Character jeff = new BasicCharacter("Jeff");

        assertEquals("Jeff", jeff.getName(), "Name not assigned properly");
        assertEquals(1, jeff.getArcana(), "Skills not assigned properly");
        assertEquals(10, jeff.getHitPoints(), "Stats not assigned properly");
    }

    @Test
    void testDecoratingOnlyRace() {
        Character jeff = new BasicCharacter("Jeff");

        // Make Jeff an Orc!
        jeff = new Orc(jeff);

        // Make sure Jeff has his original properties AND orc stuff
        assertEquals(GameConstants.ORC, jeff.getPlayerRace(), "Jeff is not an Orc");
        assertEquals(GameConstants.ORC_RACIAL, jeff.getRacialAbility(), "Wrong racial ability");
        assertEquals("Jeff", jeff.getName(), "Jeff no longer has his name");
        assertEquals(12, jeff.getHitPoints(), "Orc HP bonus not applied");
        assertNull(jeff.getPlayerClass(), "Jeff should not have a class");
    }


    // test decorating only class
    @Test
    void testDecoratingOnlyClass() {
        Character jeff = new BasicCharacter("Jeff");

        // Make Jeff a Mage!
        jeff = new Mage(jeff);

        // Make sure Jeff has original properties AND mage stuff
        assertEquals("Jeff", jeff.getName(), "Jeff no longer has his name");
        assertEquals(GameConstants.MAGE, jeff.getPlayerClass(), "Jeff is not a mage");
        assertNull(jeff.getPlayerRace(), "Jeff should not have a race yet");
        assertEquals(3, jeff.getArcana(), "Arcana bonus not applied");
        assertEquals(GameConstants.MAGE_SPECIAL, jeff.getSpecialAbility(), "Wrong special");
        assertEquals(GameConstants.MAGE_ATTACK, jeff.getAttackType(), "Wrong attack type");

    }

    @Test
    void testDecoratingRaceThenClass() {
        Character bob = new BasicCharacter("Bob");

        // Bob is a demon
        bob = new Demon(bob);
        // Bob is also a Priest
        bob = new Priest(bob);

        assertEquals(GameConstants.PRIEST, bob.getPlayerClass(), "Bob is no longer a priest");
        assertEquals(GameConstants.DEMON, bob.getPlayerRace(), "Bob is no longer a demon");
        assertEquals("Bob", bob.getName(), "Bob lost his name");
        assertEquals(10, bob.getHitPoints(), "Bob's HP changed");


    }

    


    // test decorating class and then race


}
