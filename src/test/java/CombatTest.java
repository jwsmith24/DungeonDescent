import character.PlayerInventory;
import org.junit.jupiter.api.Test;
import utility.index.EquipmentSlot;
import utility.index.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CombatTest extends AdventurerTests{



    @Test
    void testDisplayActionOptions() {


    }


    @Test
    void testBasicAttack() {


    }

    @Test
    void testSpecialAbility() {

    }



    @Test
    void testArmorBonusDamageReductionWithGear() {

        // equip a rare item
        PlayerInventory.equipItem(EquipmentSlot.ARMOR, Item.ROBE_OF_THE_RED_DRAGON, false);
       // update player scores
        player.updateItemBonuses();


        // armor bonus should increase by 3
        assertEquals(Item.ROBE_OF_THE_RED_DRAGON.getBonus(), PlayerInventory.getItemArmorBonus(),
                "Wrong armor bonus applied");

        player.takeDamage(3);
        assertEquals(player.getMaxHP(), player.getCurrentHP(),
                "Damage was not reduced by the proper amount");
    }

    @Test
    void testArmorBonusDamageReductionWithMultiplePiecesOfGear() {
        PlayerInventory.equipItem(EquipmentSlot.ARMOR, Item.ROBE_OF_THE_RED_DRAGON,false);
        PlayerInventory.equipItem(EquipmentSlot.HELMET, Item.IRON_HELMET, false);

        int totalBonus = PlayerInventory.getEquippedItem(EquipmentSlot.ARMOR).getBonus() +
                PlayerInventory.getEquippedItem(EquipmentSlot.HELMET).getBonus();

        System.out.println(totalBonus);

        assertEquals(totalBonus, PlayerInventory.getItemArmorBonus(),
                "Item bonuses don't add up.");


        player.updateItemBonuses();
        player.takeDamage(totalBonus);
        assertEquals(player.getMaxHP(), player.getCurrentHP(),
                "Bonus not properly applied");
    }



}
