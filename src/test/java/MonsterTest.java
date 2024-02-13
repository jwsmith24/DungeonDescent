import monsters.Monster;
import monsters.MonsterFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MonsterTest {


    @Test
    void testMonsterFactory() {

        // Make some monsters
        Monster goblin = MonsterFactory.createMonster(MonsterFactory.MonsterType.GOBLIN);
        Monster dragon = MonsterFactory.createMonster(MonsterFactory.MonsterType.DRAGON);
        Monster spider = MonsterFactory.createMonster(MonsterFactory.MonsterType.SPIDER);
        Monster slime = MonsterFactory.createMonster(MonsterFactory.MonsterType.SLIME);
        Monster skeleton = MonsterFactory.createMonster(MonsterFactory.MonsterType.SKELETON);
        Monster ogre = MonsterFactory.createMonster(MonsterFactory.MonsterType.OGRE);


        // Make sure the stats line up
        assertEquals("Goblin", goblin.getName(),
                "Should be a goblin");
        assertEquals(26, spider.getHp(),
                "Wrong hp for spider");
        assertEquals(18, dragon.getArmorClass(),
                "Wrong AC for dragon");
        assertEquals("Skeleton", skeleton.getName(),
                "Should be a skeleton");
        assertEquals(3, slime.getAttackBonus(),
                "Wrong attack bonus");
        assertEquals("Ogre", ogre.getName(),
                "Should be an Ogre");

    }

    /**
     * If a monster is added to the enum but hasn't had functionality programmed yet.
     */
    @Test
    void testMonsterFactoryWithMonsterTypeThatDoesNotExist() {

        assertThrows(IllegalArgumentException.class, () -> {
            Monster beholder = MonsterFactory.createMonster(MonsterFactory.MonsterType.BEHOLDER);
        });

    }

    /**
     * Verify the appropriate strings are getting printed out.
     */
    @Test
    void testAttack() {
        // Make some monsters
        Monster goblin = MonsterFactory.createMonster(MonsterFactory.MonsterType.GOBLIN);
        Monster dragon = MonsterFactory.createMonster(MonsterFactory.MonsterType.DRAGON);
        Monster spider = MonsterFactory.createMonster(MonsterFactory.MonsterType.SPIDER);
        Monster slime = MonsterFactory.createMonster(MonsterFactory.MonsterType.SLIME);
        Monster skeleton = MonsterFactory.createMonster(MonsterFactory.MonsterType.SKELETON);
        Monster ogre = MonsterFactory.createMonster(MonsterFactory.MonsterType.OGRE);

        goblin.attack();
        dragon.attack();
        spider.attack();
        slime.attack();
        skeleton.attack();
        ogre.attack();
    }





}
