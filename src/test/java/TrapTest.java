import dungeon.FalseFloorTrap;
import dungeon.TeleportTrap;
import dungeon.Trap;
import org.junit.jupiter.api.Test;
import utility.DungeonUtil;
import utility.index.Condition;
import utility.index.PlayerSkills;

import static org.junit.jupiter.api.Assertions.*;

public class TrapTest extends AdventurerTests {


    Trap teleportTrap = TeleportTrap.teleportTrapBuilder();
    Trap falseFloorTrap = FalseFloorTrap.falseFloorTrapBuilder();


    @Test
    void testBuildTeleportTrap() {

        assertEquals(Condition.POISONED, teleportTrap.getEffectType(),
                "Wrong effect type applied");

    }

    /**
     * Test display functionality.
     */
    @Test
    void testDisplayFunctions() {

        teleportTrap.displayDiscoveryText();
        teleportTrap.displaySuccessText();
        teleportTrap.displayFailureText();
    }

    /**
     * Ensures traps are using the constant trap damage value even if it changes.
     */
    @Test
    void testTrapDamageOutput() {
        assertEquals(DungeonUtil.TRAP_DAMAGE, teleportTrap.getDamage(),
                "Trap damage differs from constant value");

        assertEquals(DungeonUtil.TRAP_DAMAGE, falseFloorTrap.getDamage(),
                "Trap damage differs from constant value");
    }

    @Test
    void testGetCorrectSkillCheck() {
        assertEquals(PlayerSkills.ARCANA, teleportTrap.getSkillCheckType(),
                "Wrong skill check");
    }

    @Test
    void testCorrectTrapDC() {
        assertEquals(DungeonUtil.TRAP_DC, teleportTrap.getDifficultyCheck(),
                "Incorrect trap DC");

        assertEquals(DungeonUtil.TRAP_DC, falseFloorTrap.getDifficultyCheck(),
                "Incorrect trap DC");
    }

    @Test
    void testFailingDC() {
        int result = DungeonUtil.TRAP_DC - 1;

        assertFalse(teleportTrap.doesPlayerBeatAC(result));

    }

    @Test
    void testPassingDC() {
        int result = DungeonUtil.TRAP_DC + 1;

        assertTrue(teleportTrap.doesPlayerBeatAC(result));
    }


}
