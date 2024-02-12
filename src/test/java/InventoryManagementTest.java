import character.*;
import character.Character;
import org.junit.jupiter.api.Test;
import utility.CharacterBuilder;
import utility.index.EquipmentSlot;
import utility.index.Item;
import utility.index.PlayerClass;
import utility.index.PlayerRace;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InventoryManagementTest {


    @Test
    void testInitializeInventory() {



        PlayerInventory.initializeInventory();

        // Player should start with no weapon

        assertEquals(Item.NO_WEAPON, PlayerInventory.getEquippedItem(EquipmentSlot.WEAPON), "wrong weapon initialized.");
        assertEquals(Item.NO_ARMOR, PlayerInventory.getEquippedItem(EquipmentSlot.ARMOR), "wrong armor");
        assertEquals(Item.NO_HELMET, PlayerInventory.getEquippedItem(EquipmentSlot.HELMET), "wrong helmet");
        assertEquals(Item.POTION_OF_HEALING, PlayerInventory.getEquippedItem(EquipmentSlot.POTION), "wrong potion");
        assertEquals(Item.NO_OFF_HAND, PlayerInventory.getEquippedItem(EquipmentSlot.OFF_HAND), "wrong offhand");
    }

    @Test
    void testRemoveStartingItem() {

        PlayerInventory.initializeInventory();

        PlayerInventory.removeItem(EquipmentSlot.WEAPON);

        // Verifying that the right output was displayed to console

        // And that the slot is still correct
        assertEquals(Item.NO_WEAPON, PlayerInventory.getEquippedItem(EquipmentSlot.WEAPON));


    }

    @Test
    void testDisplayInventoryWithNullInventory() {
        PlayerInventory.displayInventory();
    }

    @Test
    void testDisplayInventoryWithStarterInventory() {
        PlayerInventory.initializeInventory();
        PlayerInventory.displayInventory();
    }


    @Test
    void testEquipItemToEmptySlot() {

        PlayerInventory.initializeInventory();

        // Equip a helmet!
        PlayerInventory.equipItem(EquipmentSlot.HELMET, Item.HELMET_OF_PROTECTION);

        // Make sure it's equipped.
        assertEquals(Item.HELMET_OF_PROTECTION, PlayerInventory.getEquippedItem(EquipmentSlot.HELMET));

    }

    @Test
    void testRemoveItemFromEmptySlot() {
        PlayerInventory.initializeInventory();
        // Try to remove the helmet
        PlayerInventory.removeItem(EquipmentSlot.HELMET);


    }

    @Test
    void testRemoveItemFromEquippedSlot() {
        // Testing removing from equipped slot manually since it relies on user input


    }
}
