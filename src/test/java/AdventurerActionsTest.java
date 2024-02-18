import character.PlayerInventory;
import org.junit.jupiter.api.Test;
import utility.DungeonUtil;
import utility.index.Condition;
import utility.index.EquipmentSlot;
import utility.index.Item;
import utility.index.PlayerSkills;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for player actions in the dungeon (in and out of combat).
 */
public class AdventurerActionsTest extends AdventurerTests {


    @Test
    void testCheckLevelUpWithNotEnoughXP() {
        player.checkLevelUp();

        assertEquals(1, player.getLevel());
    }

    @Test
    void testCheckLevelUpWithEnoughXP() {
        player.gainBossXP();

        player.checkLevelUp();

        assertEquals(2, player.getLevel());
    }

    @Test
    void testBasicAttackDamage() {
        int result = player.basicAttackDamage();

        assertTrue(result > player.getAttack() + player.getLevel());
    }

    @Test
    void testBasicAttackRoll() {
        int result = player.basicAttackRoll();

        assertTrue(result > player.getAttack() + player.getLevel());
    }
    @Test
    void testGainSmallXP() {
        player.gainSmallXP();

        assertEquals(DungeonUtil.SMALL_XP, player.getCurrentXP(),
                "Wrong amount of xp applied");
    }

    @Test
    void testGainMediumXP() {
        player.gainMediumXP();

        assertEquals(DungeonUtil.MED_XP, player.getCurrentXP(),
                "Wrong amount of xp applied");
    }

    @Test
    void testGainBossXP() {
        player.gainBossXP();

        assertEquals(DungeonUtil.BOSS_XP, player.getCurrentXP(),
                "Wrong amount of xp applied");
    }


    @Test
    void testPowerBoost() {

        player.applyPower();

        assertEquals(13, player.getAC(),
                "AC not increased");

        assertEquals(20, player.getCurrentHP(),
                "Player hp not increased");
    }

    /**
     * Test to ensure damage is applied properly and doesn't reduce max hp.
     */
    @Test
    void testTakeDamage() {

        // test player starts with 10 hp
        player.takeDamage(2);

        assertEquals(8, player.getCurrentHP(),
                "HP not reduced properly");

        assertEquals(10, player.getMaxHP(),
                "Max HP changed");
    }

    @Test
    void testTakeDamagePastZero() {
        player.takeDamage(100);

        // player HP should still only be at 0
        assertEquals(0, player.getCurrentHP());
    }

    @Test
    void testDrinkPotionWithoutOneEquipped() {

        PlayerInventory.initializeInventory();

        player.drinkPotion();

        assertEquals(10, player.getCurrentHP(),
                "HP changed even though potion slot was empty");


    }


    /**
     * Checks that healing potion applies health, doesn't raise the max hp, and doesn't go over max
     * hp
     */
    @Test
    void testDrinkPotionWithOneEquipped() {

        PlayerInventory.equipItem(EquipmentSlot.POTION, Item.POTION_OF_HEALING, true);

        // deal 3 damage
        player.takeDamage(3);

        player.drinkPotion();

        assertTrue(player.getCurrentHP() > 7,
                "No healing was applied");

        assertEquals(10, player.getMaxHP(),
                "Max HP increased");

        assertTrue(player.getCurrentHP() <= player.getMaxHP(),
                "HP has exceeded max HP");
    }


    @Test
    void testTakeLongRest() {

        // beat up the player
        player.takeDamage(8);
        player.applyCondition(Condition.POISONED);

        // take a long rest and everything should clear
        player.takeLongRest();

        assertEquals(player.getMaxHP(), player.getCurrentHP(),
                "Player is not at max HP");
        assertFalse(player.hasCondition(Condition.POISONED),
                "Player's condition was not removed");


    }

    @Test
    void testIsPlayerAlive() {
        // player should start alive
        assertTrue(player.isAlive(), "Player should be alive");

        // beat up the player
        player.takeDamage(8);
        assertTrue(player.isAlive(), "Player should be alive");

        // kill the player
        player.takeDamage(50);
        assertFalse(player.isAlive(), "Player should be dead");
    }

    @Test
    void testHealPlayer() {
        player.takeDamage(3);
        player.healPlayer(3);
        assertEquals(10, player.getCurrentHP());

        // make sure can't over heal
        player.healPlayer(500);
        assertEquals(10, player.getCurrentHP());
    }

    @Test
    void rollASkillCheck() {

        assertTrue(player.rollSkillCheck(PlayerSkills.ARCANA) > player.getArcana());
        assertTrue(player.rollSkillCheck(PlayerSkills.ATHLETICS) > player.getAthletics());
        assertTrue(player.rollSkillCheck(PlayerSkills.HISTORY) > player.getHistory());
        assertTrue(player.rollSkillCheck(PlayerSkills.DUNGEONEERING) > player.getDungeoneering());
        assertTrue(player.rollSkillCheck(PlayerSkills.LOCK_PICKING) > player.getLockPicking());
    }

    @Test
    void useSpecialAttackWithFullUltimateCharges() {
        assertTrue(player.useSpecialAttack() > 0,
                "No special damage was applied.");
    }

    @Test
    void useSpecialAttackWithNoUltimateCharges() {

        player.spendUltimateCharge();
        player.spendUltimateCharge();

        assertEquals(0, player.useSpecialAttack(),
                "special attack damage applied without any charges");
    }



    @Test
    void testSpendingUltimateChargesWithCharges() {
        assertTrue(player.spendUltimateCharge(),
                "Player not starting with at least one ult charge");
    }
    @Test
    void testSpendingUltimateChargeWithNoCharges() {
        player.spendUltimateCharge();
        player.spendUltimateCharge();


        assertFalse(player.spendUltimateCharge(),
        "player's ult charges are not being spent");
    }

}
