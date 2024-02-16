import character.Adventurer;
import character.PlayerInventory;
import org.junit.jupiter.api.Test;
import utility.Dice;
import utility.index.EquipmentSlot;
import utility.index.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdventurerCombatTest {


    public Adventurer getTestCharacter() {
        return CharacterCreationTest.spawnCharacter();
    }




    @Test
    void testPowerBoost() {
        Adventurer player = getTestCharacter();


        player.applyPower();

        assertEquals(13, player.getAC(),
                "AC not increased");

        assertEquals(20, player.getHitPoints(),
                "Player hp not increased");
    }

    /**
     * Test to ensure damage is applied properly and doesn't reduce max hp.
     */
    @Test
    void testTakeDamage() {
        Adventurer player = getTestCharacter();

        // test player starts with 10 hp
        player.takeDamage(2);

        assertEquals(8, player.getHitPoints(),
                "HP not reduced properly");

        assertEquals(10, player.getMaxHP(),
                "Max HP changed");
    }

    @Test
    void testDrinkPotionWithoutOneEquipped() {
        Adventurer player = getTestCharacter();

        player.drinkPotion();

        assertEquals(10, player.getHitPoints(),
                "HP changed even though potion slot was empty");


    }


    /**
     * Checks that healing potion applies health, doesn't raise the max hp, and doesn't go over max hp
     */
    @Test
    void testDrinkPotionWithOneEquipped() {
        Adventurer player = getTestCharacter();
        PlayerInventory.equipItem(EquipmentSlot.POTION, Item.POTION_OF_HEALING, true);

        // deal 3 damage
        player.takeDamage(3);

        player.drinkPotion();

        assertTrue(player.getHitPoints() > 7,
                "No healing was applied");

        assertEquals(10, player.getMaxHP(),
                "Max HP increased");

        assertTrue(player.getHitPoints() <= player.getMaxHP(),
                "HP has exceeded max HP");
    }
}
