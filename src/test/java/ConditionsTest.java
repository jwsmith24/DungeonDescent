import character.*;
import character.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionsTest {


    @Test
    void testCharacterBeginsNeutral() {
        Character bob = new BasicCharacter("bob");
        bob = new Demon(new Orc(bob));

        // Bob should be neutral!
        // Bob's active effects arraylist should have neutral in it AND it should be the only entry in it
        assertTrue(bob.getActiveEffects().contains(Condition.NEUTRAL));
        assertEquals(1, bob.getActiveEffects().size());

    }

    @Test
    void testApplyingEffectToNeutralCharacter() {
        Character bob = new BasicCharacter("bob");
        bob = new Demon (new Orc(bob));

        // Bob is restrained!
        // Make sure the arraylist updates appropriately, displays the correct effect and does NOT have neutral in it

        bob = new ApplyCondition(bob, Condition.RESTRAINED);

        assertTrue(bob.getActiveEffects().contains(Condition.RESTRAINED), "Bob is not showing RESTRAINED");
        assertFalse(bob.getActiveEffects().contains(Condition.NEUTRAL), "Neutral condition was not removed when new effect is applied");

    }

    @Test
    void testApplyingEffectToAffectedCharacter() {
        Character dan = new ApplyCondition(new Warrior(new Elf(new BasicCharacter("dad"))), Condition.PARALYZED);

        // dan is already paralyzed
        dan = new ApplyCondition(dan, Condition.POISONED);
        // if dan is also poisoned, both conditions should be present in the active effects list

        assertTrue(dan.getActiveEffects().contains(Condition.PARALYZED), "Original condition not in list");
        assertTrue(dan.getActiveEffects().contains(Condition.POISONED), "New condition is not in list");

        // Make sure neutral condition is still not there
        assertFalse(dan.getActiveEffects().contains(Condition.NEUTRAL), "Neutral condition was not removed when new effect is applied");

    }

    @Test
    void testApplyingNeutralToCharacterWithOneAffliction() {

        Character dad = new ApplyCondition(new Priest(new Demon(new BasicCharacter("dad"))), Condition.BLINDED);

        dad = new ApplyCondition(dad, Condition.NEUTRAL);

        // Need to make sure that dad is condition-free and only has neutral in the list
        assertFalse(dad.getActiveEffects().contains(Condition.BLINDED), "Condition still present");
        assertTrue(dad.getActiveEffects().contains(Condition.NEUTRAL), "List does not contain neutral");
        assertEquals(1, dad.getActiveEffects().size(), "List contains more than 1 element");

    }

    @Test
    void testApplyingNeutralToCharacterWithMultipleAfflictions() {
        Character dad = new ApplyCondition(new Priest(new Demon(new BasicCharacter("dad"))), Condition.STUNNED);
        dad = new ApplyCondition(dad, Condition.POISONED);
        // Dad is stunned and poisoned, but we throw a healing potion at him and now he's good
        dad = new ApplyCondition(dad, Condition.NEUTRAL);


        // Check that applying neutral still works properly
        assertEquals(1, dad.getActiveEffects().size(), "List contains more than 1 element");
        assertTrue(dad.getActiveEffects().contains(Condition.NEUTRAL), "List does not contain neutral");

    }

}
