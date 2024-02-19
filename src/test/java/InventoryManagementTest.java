import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import character.PlayerInventory;
import org.junit.jupiter.api.Test;
import utility.DungeonUtil;
import utility.index.EquipmentSlot;
import utility.index.Item;




public class InventoryManagementTest {

    @Test
    void testInitializeInventory() {



        PlayerInventory.initializeInventory();

        // Player should start with no weapon

        assertEquals(Item.NO_WEAPON, PlayerInventory.getEquippedItem(EquipmentSlot.WEAPON),
                "wrong weapon initialized.");
        assertEquals(Item.NO_ARMOR, PlayerInventory.getEquippedItem(EquipmentSlot.ARMOR),
                "wrong armor");
        assertEquals(Item.NO_HELMET, PlayerInventory.getEquippedItem(EquipmentSlot.HELMET),
                "wrong helmet");
        assertEquals(Item.NO_POTION, PlayerInventory.getEquippedItem(EquipmentSlot.POTION),
                "wrong potion");
        assertEquals(Item.NO_OFF_HAND, PlayerInventory.getEquippedItem(EquipmentSlot.OFF_HAND),
                "wrong offhand");
    }

    @Test
    void testRemoveStartingItem() {

        PlayerInventory.initializeInventory();

        PlayerInventory.removeItem(EquipmentSlot.WEAPON, true);

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
        PlayerInventory.equipItem(EquipmentSlot.HELMET, Item.IRON_HELMET, true);

        // Make sure it's equipped.
        assertEquals(Item.IRON_HELMET, PlayerInventory.getEquippedItem(EquipmentSlot.HELMET));

    }

    @Test
    void testEquipItemToEquippedSlot() {
        PlayerInventory.equipItem(EquipmentSlot.HELMET, Item.IRON_HELMET, true);
        PlayerInventory.equipItem(EquipmentSlot.HELMET, Item.HAT_OF_STYLE, true);
    }

    @Test
    void testRemoveItemFromEmptySlot() {
        PlayerInventory.initializeInventory();
        // Try to remove the helmet
        PlayerInventory.removeItem(EquipmentSlot.HELMET, true);


    }

    @Test
    void testRemoveItemFromEquippedSlot() {

        PlayerInventory.initializeInventory();

        // equip helmet of protection
        PlayerInventory.equipItem(EquipmentSlot.HELMET, Item.HELMET_OF_PROTECTION, true);

        // find hat of style and try to equip
        PlayerInventory.equipItem(EquipmentSlot.HELMET, Item.HAT_OF_STYLE, true);

        assertEquals(Item.HAT_OF_STYLE, PlayerInventory.getEquippedItem(EquipmentSlot.HELMET));

        PlayerInventory.displayInventory();


    }

    @Test
    void testRollForRandomItem() {
        int size = 3;

        assertTrue(DungeonUtil.rollRandomItem(size) <= 3);

    }
}
