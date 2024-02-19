import dungeon.DungeonMaster;
import org.junit.jupiter.api.Test;

public class DungeonMasterTest {

    @Test
    void testScriptedGameLoop() {
        DungeonMaster.setIsScripted(true);
        DungeonMaster.runDungeon();
    }
}
