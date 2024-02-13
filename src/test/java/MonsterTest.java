import monsters.Monster;
import monsters.MonsterFactory;
import org.junit.jupiter.api.Test;

public class MonsterTest {


    @Test
    void testMonsterFactory() {

        // Let's try making a goblin.
        Monster goblin = MonsterFactory.createMonster(MonsterFactory.MonsterType.GOBLIN);

        System.out.println(goblin.getName());

    }
}
