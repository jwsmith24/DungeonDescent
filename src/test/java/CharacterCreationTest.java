import character.*;
import character.Character;

import org.junit.jupiter.api.Test;
import utility.CharacterBuilder;
import utility.index.PlayerClass;
import utility.index.PlayerRace;

import static org.junit.jupiter.api.Assertions.*;


public class CharacterCreationTest {

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
        jeff = new RaceDecorator(jeff, PlayerRace.ORC);

        // Make sure Jeff has his original properties AND orc stuff
        assertEquals(PlayerRace.ORC.getRaceDescription(), jeff.getPlayerRace(), "Jeff is not an Orc");
        assertEquals(PlayerRace.ORC.getRacialBonusText(), jeff.getRacialAbility(), "Wrong racial ability");
        assertEquals("Jeff", jeff.getName(), "Jeff no longer has his name");
        assertEquals(12, jeff.getHitPoints(), "Orc HP bonus not applied");
        assertEquals(PlayerClass.NO_CLASS.getClassDescription(), jeff.getPlayerClass());
    }


    // test decorating only class
    @Test
    void testDecoratingOnlyClass() {
        Character jeff = new BasicCharacter("Jeff");

        // Make Jeff a Mage!
        jeff = new ClassDecorator(jeff, PlayerClass.MAGE);

        // Make sure Jeff has original properties AND mage stuff
        assertEquals("Jeff", jeff.getName(), "Jeff no longer has his name");
        assertEquals(PlayerClass.MAGE.getClassDescription(), jeff.getPlayerClass(), "Jeff is not a mage");
        assertEquals(3, jeff.getArcana(), "Arcana bonus not applied");
        assertEquals(PlayerClass.MAGE.getSpecialAbilityText(), jeff.getSpecialAbility(), "Wrong special");
        assertEquals(PlayerClass.MAGE.getAttackText(), jeff.getAttackType(), "Wrong attack type");

    }

    @Test
    void testDecoratingRaceThenClass() {
        Character bob = new BasicCharacter("Bob");

        // Bob is a demon
        bob = new RaceDecorator(bob, PlayerRace.DEMON);
        // Bob is also a Priest
        bob = new ClassDecorator(bob, PlayerClass.PRIEST);

        assertEquals(PlayerClass.PRIEST.getClassDescription(), bob.getPlayerClass(), "Bob is no longer a priest");
        assertEquals(PlayerRace.DEMON.getRaceDescription(), bob.getPlayerRace(), "Bob is no longer a demon");

        assertEquals("Bob", bob.getName(), "Bob lost his name");
        assertEquals(10, bob.getHitPoints(), "Bob's HP changed");
        assertEquals(3, bob.getHistory(), "History bonus not applied");
        assertEquals(3, bob.getSpeed(), "Speed bonus not applied");


    }

    @Test
    void testDecoratingClassThenRace() {
        Character steve = new BasicCharacter("Steve");

        // Steve is a Human
        steve = new RaceDecorator(steve, PlayerRace.HUMAN);
        // Steve is also a Warrior
        steve = new ClassDecorator(steve, PlayerClass.WARRIOR);

        assertEquals(PlayerClass.WARRIOR.getClassDescription(), steve.getPlayerClass(), "Steve is no longer a Warrior");
        assertEquals(PlayerRace.HUMAN.getRaceDescription(), steve.getPlayerRace(), "Wrong race");
        assertEquals("Steve", steve.getName(), "Wrong name");
        assertEquals(10, steve.getHitPoints(), "Wrong HP");
        assertEquals(3, steve.getAthletics(), "Athletics bonus not applied");
        assertEquals(3, steve.getAttack(), "Attack bonus not applied");

    }

    @Test
    void testStatPersistenceWithTwoClasses() {

        Character pete = new BasicCharacter("Pete");
        // Pete is a thief
        pete = new ClassDecorator(pete, PlayerClass.THIEF);
        // He's also a warrior
        pete = new ClassDecorator(pete, PlayerClass.WARRIOR);

        // Pete's latest class was warrior, so his attack should be a warrior attack
        assertEquals(PlayerClass.WARRIOR.getAttackText(), pete.getAttackType(), "Pete is not a warrior");

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
        pete = new ClassDecorator(pete, PlayerClass.WARRIOR);
        pete = new ClassDecorator(pete, PlayerClass.THIEF);

        assertEquals(PlayerClass.THIEF.getAttackText(), pete.getAttackType(), "Pete is not a warrior");

        // Pete should still have the +2 bonus to lockpicking
        assertEquals(3, pete.getLockPicking(), "Pete lost his lockpicking prof");
        // and Pete should have his warrior bonus to athletics
        assertEquals(3, pete.getAthletics(), "Pete lost his athletics prof");

        // Check basic character data
        assertEquals("Pete", pete.getName(), "Pete lost his name");
    }

    @Test
    void testStatPersistenceWithTwoRaces() {
        Character bucky = new BasicCharacter("Bucky");

        bucky = new RaceDecorator(bucky, PlayerRace.ORC);
        bucky = new RaceDecorator(bucky, PlayerRace.DEMON);

        // Bucky should have the bonuses to hit points and speed but only have the demon racial

        assertEquals(3, bucky.getSpeed(), "Speed incorrect");
        assertEquals(12, bucky.getHitPoints(), "HP incorrect");
        assertEquals(PlayerRace.DEMON.getRacialBonusText(), bucky.getRacialAbility(), "Racial ability is incorrect");
    }




}
