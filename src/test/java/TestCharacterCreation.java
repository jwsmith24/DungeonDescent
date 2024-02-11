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
        assertEquals(3, bob.getHistory(), "History bonus not applied");
        assertEquals(3, bob.getSpeed(), "Speed bonus not applied");


    }

    @Test
    void testDecoratingClassThenRace() {
        Character steve = new BasicCharacter("Steve");

        // Steve is a Human
        steve = new Human(steve);
        // Steve is also a Warrior
        steve = new Warrior(steve);

        assertEquals(GameConstants.WARRIOR, steve.getPlayerClass(), "Steve is no longer a Warrior");
        assertEquals(GameConstants.HUMAN, steve.getPlayerRace(), "Wrong race");
        assertEquals("Steve", steve.getName(), "Wrong name");
        assertEquals(10, steve.getHitPoints(), "Wrong HP");
        assertEquals(3, steve.getAthletics(), "Athletics bonus not applied");
        assertEquals(3, steve.getAttack(), "Attack bonus not applied");

    }

    @Test
    void testStatPersistenceWithTwoClasses() {

        Character pete = new BasicCharacter("Pete");
        // Pete is a thief
        pete = new Thief(pete);
        // He's also a warrior
        pete = new Warrior(pete);

        // Pete's latest class was warrior, so his attack should be a warrior attack
        assertEquals(GameConstants.WARRIOR_ATTACK, pete.getAttackType(), "Pete is not a warrior");

        // Pete should still have the +2 bonus to lockpicking though
        assertEquals(3, pete.getLockPicking(), "Pete lost his lockpicking prof");
        // and Pete should have his warrior bonus to athletics
        assertEquals(3, pete.getAthletics(), "Pete lost his athletics prof");

        // Check basic character data
        assertEquals("Pete", pete.getName(), "Pete lost his name");
    }

    @Test
    void testStatPersistenceWithTwoClassesReverseOrder() {
        Character pete = new BasicCharacter("Pete");
        pete = new Warrior(pete);
        pete = new Thief(pete);

        assertEquals(GameConstants.THIEF_ATTACK, pete.getAttackType(), "Pete is not a warrior");

        // Pete should still have the +2 bonus to lockpicking
        assertEquals(3, pete.getLockPicking(), "Pete lost his lockpicking prof");
        // and Pete should have his warrior bonus to athletics
        assertEquals(3, pete.getAthletics(), "Pete lost his athletics prof");

        // Check basic character data
        assertEquals("Pete", pete.getName(), "Pete lost his name");
    }



}
