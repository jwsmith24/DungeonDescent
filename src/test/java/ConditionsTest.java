import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import character.Adventurer;

import org.junit.jupiter.api.Test;

import utility.index.Condition;




public class ConditionsTest {


    @Test
    void testCharacterBeginsNeutral() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        assertTrue(player.hasCondition(Condition.NEUTRAL));

    }

    @Test
    void testApplyingEffectToNeutralCharacter() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        // Apply effect
        player.applyCondition(Condition.RESTRAINED);


        assertTrue(player.hasCondition(Condition.RESTRAINED),
                "Bob is not showing RESTRAINED");
        assertFalse(player.hasCondition(Condition.NEUTRAL),
                "Neutral condition was not removed when new effect is applied");


    }

    @Test
    void testApplyingEffectToAffectedCharacter() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        // Apply initial effect
        player.applyCondition(Condition.BLINDED);

        // Apply another effect
        player.applyCondition(Condition.STUNNED);

        // Both conditions should be present in the active effects list
        assertTrue(player.hasCondition(Condition.BLINDED),
                "Original condition not in list");
        assertTrue(player.hasCondition(Condition.STUNNED),
                "New condition is not in list");

        // Make sure neutral condition is still not there
        assertFalse(player.hasCondition(Condition.NEUTRAL),
                "Neutral condition was not removed when new effect is applied");

    }

    @Test
    void testApplyingNeutralToCharacterWithOneAffliction() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        // Afflict them with blindness
        player.applyCondition(Condition.BLINDED);

        // Cure them
        player.applyCondition(Condition.NEUTRAL);

        // Check for condition-free with only neutral in the list
        assertFalse(player.hasCondition(Condition.BLINDED),
                "Condition still present");
        assertTrue(player.hasCondition(Condition.NEUTRAL),
                "List does not contain neutral");

    }

    @Test
    void testApplyingNeutralToCharacterWithMultipleAfflictions() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        // Inflict two conditions
        player.applyCondition(Condition.PARALYZED);
        player.applyCondition(Condition.POISONED);

        // Cure them
        player.applyCondition(Condition.NEUTRAL);

        // Check that applying neutral still works properly
        assertTrue(player.hasCondition(Condition.NEUTRAL),
                "List does not contain neutral");

    }


}
