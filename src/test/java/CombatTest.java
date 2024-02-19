import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import character.PlayerInventory;
import dungeon.Combat;
import org.junit.jupiter.api.Test;
import utility.index.EquipmentSlot;
import utility.index.Item;


public class CombatTest extends AdventurerTests {


    Combat dungeonCombat;

    @Test
    void testBotDisplayActionsAndBasicAttack() {

        dungeonCombat = new Combat(player, goblin, 1);
        dungeonCombat.combat(true);

    }


    @Test
    void testBotSpecialAbilityWithCharges() {

        player.applyPower();
        player.applyPower();
        player.applyPower();

        // scripted character should be using special ability on any boss
        dungeonCombat = new Combat(player, giantSpider, 1);
        dungeonCombat.combat(true);

        // make sure player used at least 1 ultimate charge as long as they're alive
        if (player.isAlive()) {
            assertTrue(player.getUltimateCharges() < player.getEnergy());
        }


    }

    @Test
    void testBotSpecialAbilityWithoutCharges() {

        // highest number of charges a player can start with is 3
        player.spendUltimateCharge();
        player.spendUltimateCharge();
        player.spendUltimateCharge();

        // scripted character should be using special ability on any boss
        dungeonCombat = new Combat(player, giantSpider, 1);
        dungeonCombat.combat(true);

    }

    @Test
    void testBotDrinkPotionWithPotion() {
        // player should use potion of healing if below half hp

        // level player up to make sure goblin doesn't kill them on the first hit
        player.applyPower();
        player.applyPower();
        player.applyPower();

        player.takeDamage((player.getMaxHp() / 2) + 1);
        PlayerInventory.findPotionOfHealing();

        dungeonCombat = new Combat(player, goblin, 1);
        dungeonCombat.combat(true);


        // just in case player dies in freak test case
        if (player.isAlive()) {
            assertEquals(Item.NO_POTION, PlayerInventory.getEquippedItem(EquipmentSlot.POTION),
                    "Player did not use potion below half hp");
        }

    }


    @Test
    void testBotDrinkPotionWithoutPotion() {
        player.applyPower();
        player.applyPower();

        // player should use potion of healing if below half hp
        player.takeDamage((player.getMaxHp() / 2) + 1);

        dungeonCombat = new Combat(player, goblin, 1);
        dungeonCombat.combat(true);

        // just in case player dies in freak test case
        if (player.isAlive()) {
            assertEquals(Item.NO_POTION, PlayerInventory.getEquippedItem(EquipmentSlot.POTION),
                    "Player did not use potion below half hp");
        }

    }

    @Test
    void testBotDrinkPotionAboveHalfHitPoints() {
        // give player a potion, but they shouldn't use it above half hp
        PlayerInventory.findPotionOfHealing();

        dungeonCombat = new Combat(player, goblin, 1);
        dungeonCombat.combat(true);

        if (player.isAlive()) {
            assertEquals(Item.POTION_OF_HEALING,
                    PlayerInventory.getEquippedItem(EquipmentSlot.POTION),
                    "Potion of healing used");
        }


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
