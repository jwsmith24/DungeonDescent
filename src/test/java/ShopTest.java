import static org.junit.jupiter.api.Assertions.assertEquals;

import character.PlayerInventory;
import dungeon.Shop;
import org.junit.jupiter.api.Test;
import utility.index.EquipmentSlot;
import utility.index.Item;

public class ShopTest {




    @Test
    void testShopKeeperEncounter() {

        PlayerInventory.initializeInventory();
        // run shop keeper encounter in scripted mode
        Shop.shopKeeperEncounter(true);

        // player should have no helmet
        assertEquals(Item.NO_HELMET, PlayerInventory.getEquippedItem(EquipmentSlot.HELMET),
                "Expected no helmet.");
    }

    @Test
    void testShopKeeperEncounterWithGold() {
        // find lots of money
        PlayerInventory.pickUpGold(1000);

        // try to buy a hat of style
        Shop.shopKeeperEncounter(true);

        assertEquals(Item.HAT_OF_STYLE, PlayerInventory.getEquippedItem(EquipmentSlot.HELMET),
                "Helmet was not bought or equipped.");
    }

    @Test
    void testBuyingAllShopkeeperItems() {
        PlayerInventory.pickUpGold(1000);

        Shop.goShopping(1, true);
        Shop.goShopping(2, true);
        Shop.goShopping(3, true);
        Shop.goShopping(4, true);

        assertEquals(Item.SWORD_OF_SLASHING,
                PlayerInventory.getEquippedItem(EquipmentSlot.WEAPON));

        assertEquals(Item.HAT_OF_STYLE, PlayerInventory.getEquippedItem(EquipmentSlot.HELMET));

        assertEquals(Item.POTION_OF_HEALING, PlayerInventory.getEquippedItem(EquipmentSlot.POTION));
    }

    @Test
    void testChoosingToNotBuyItem() {
        PlayerInventory.pickUpGold(1000);

        Shop.goShopping(5, true);
    }

    @Test
    void testTryToBuyItemWithNoGold() {

        PlayerInventory.initializeInventory();
        Shop.goShopping(1, true);

        assertEquals(Item.NO_WEAPON, PlayerInventory.getEquippedItem(EquipmentSlot.WEAPON),
                "Weapon was purchased with no money");
    }


}
