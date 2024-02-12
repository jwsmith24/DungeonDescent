import character.*;
import character.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utility.CharacterBuilder;
import utility.index.Condition;
import utility.index.PlayerClass;
import utility.index.PlayerRace;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionsTest {


    @Test
    void testCharacterBeginsNeutral() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        assertEquals(1, player.getActiveEffects().size(), "effects list not 1");
        assertTrue(player.getActiveEffects().contains(Condition.NEUTRAL));

    }

    @Test
    void testApplyingEffectToNeutralCharacter() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        // Apply effect
        player.applyCondition(Condition.RESTRAINED);


        assertTrue(player.getActiveEffects().contains(Condition.RESTRAINED), "Bob is not showing RESTRAINED");
        assertFalse(player.getActiveEffects().contains(Condition.NEUTRAL), "Neutral condition was not removed when new effect is applied");
        assertEquals(1, player.getActiveEffects().size(), "list size != 1");

    }

    @Test
    void testApplyingEffectToAffectedCharacter() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        // Apply initial effect
        player.applyCondition(Condition.BLINDED);

        // Apply another effect
        player.applyCondition(Condition.STUNNED);

        // Both conditions should be present in the active effects list
        assertTrue(player.getActiveEffects().contains(Condition.BLINDED), "Original condition not in list");
        assertTrue(player.getActiveEffects().contains(Condition.STUNNED), "New condition is not in list");

        // Make sure neutral condition is still not there
        assertFalse(player.getActiveEffects().contains(Condition.NEUTRAL), "Neutral condition was not removed when new effect is applied");

    }

    @Test
    void testApplyingNeutralToCharacterWithOneAffliction() {

        Adventurer player = CharacterCreationTest.spawnCharacter();

        // Afflict them with blindness
        player.applyCondition(Condition.BLINDED);

        // Cure them
        player.applyCondition(Condition.NEUTRAL);

        // Check for condition-free with only neutral in the list
        assertFalse(player.getActiveEffects().contains(Condition.BLINDED), "Condition still present");
        assertTrue(player.getActiveEffects().contains(Condition.NEUTRAL), "List does not contain neutral");
        assertEquals(1, player.getActiveEffects().size(), "List contains more than 1 element");

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
        assertEquals(1, player.getActiveEffects().size(), "List contains more than 1 element");
        assertTrue(player.getActiveEffects().contains(Condition.NEUTRAL), "List does not contain neutral");

    }


}
