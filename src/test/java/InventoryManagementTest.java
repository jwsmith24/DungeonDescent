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

        Adventurer player = CharacterCreationTest.spawnCharacter();

        player.getInventory().displayInventory();



    }

    @Test
    void testGetItemSlotWithStartingItemEquipped() {
        Adventurer player = CharacterCreationTest.spawnCharacter();

        assertEquals(Item.NO_WEAPON, player.getInventory().getEquippedItem(EquipmentSlot.WEAPON), "Wrong weapon is equipped");

    }
}
