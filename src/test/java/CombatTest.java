import static org.junit.jupiter.api.Assertions.assertEquals;

import character.PlayerInventory;
import org.junit.jupiter.api.Test;
import utility.index.EquipmentSlot;
import utility.index.Item;


public class CombatTest extends AdventurerTests {



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
        // equip starting items
        PlayerInventory.initializeInventory();

        // equip a rare item
        PlayerInventory.equipItem(EquipmentSlot.ARMOR, Item.ROBE_OF_THE_RED_DRAGON,
                false);

        // update player scores
        player.updateItemBonuses();


        // armor bonus should increase by 3
        assertEquals(Item.ROBE_OF_THE_RED_DRAGON.getBonus(), PlayerInventory.getItemArmorBonus(),
                "Wrong armor bonus applied");


        player.takeDamage(3);
        assertEquals(player.getMaxHp() - 1, player.getCurrentHp(),
                "Damage was not reduced by the proper amount. Minimum damage is always 1.");
    }



    @Test
    void testArmorBonusDamageReductionWithMultiplePiecesOfGear() {

        PlayerInventory.initializeInventory();

        PlayerInventory.equipItem(EquipmentSlot.ARMOR, Item.ROBE_OF_THE_RED_DRAGON,
                false);
        PlayerInventory.equipItem(EquipmentSlot.HELMET, Item.IRON_HELMET,
                false);

        int totalBonus = PlayerInventory.getEquippedItem(EquipmentSlot.ARMOR).getBonus()
                +
                PlayerInventory.getEquippedItem(EquipmentSlot.HELMET).getBonus();

        System.out.println(totalBonus);

        assertEquals(totalBonus, PlayerInventory.getItemArmorBonus(),
                "Item bonuses don't add up.");


        player.updateItemBonuses();
        player.takeDamage(totalBonus);
        assertEquals(player.getMaxHp() - 1, player.getCurrentHp(),
                "Bonus not properly applied. Minimum damage is always at least 1.");
    }

    @Test
    void testDrinkAPotionWithPotion() {
        PlayerInventory.initializeInventory();
        PlayerInventory.findPotionOfHealing();

        player.takeDamage(1);
        player.drinkPotion();

        assertEquals(player.getMaxHp(), player.getCurrentHp(),
                "Error drinking potion");
    }



}
