
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import monsters.Beholder;
import monsters.DisplacerBeast;
import monsters.Dragon;
import monsters.Giant;
import monsters.Goblin;
import monsters.Monster;
import monsters.MonsterFactory;
import monsters.Ogre;
import monsters.Skeleton;
import monsters.Slime;
import monsters.Spider;

import org.junit.jupiter.api.Test;



public class MonsterTest {


    @Test
    void testGenerateSmallMonster() {
        Monster random = MonsterFactory.randomSmallMonster();

        assertTrue((random instanceof Goblin) || (random instanceof Skeleton)
                ||
                (random instanceof Slime));

    }

    @Test
    void testGenerateMediumMonster() {
        Monster random = MonsterFactory.randomMediumMonster();

        assertTrue((random instanceof Spider) || (random instanceof Ogre)
                ||
                (random instanceof DisplacerBeast));

    }

    @Test
    void testGenerateLargeMonster() {
        Monster random = MonsterFactory.randomLargeMonster();

        assertTrue((random instanceof Dragon) || (random instanceof Beholder)
                ||
                (random instanceof Giant));

    }

    @Test
    void testMonsterFactory() {

        // Make some monsters and make sure they line up with the right stats

        Monster goblin = MonsterFactory.createGoblin();
        assertEquals("Goblin", goblin.getName(), "Should be a goblin");

        Monster dragon = MonsterFactory.createDragon();
        assertEquals(18, dragon.getArmorClass(), "Wrong AC for dragon");

        Monster spider = MonsterFactory.createSpider();
        assertEquals(26, spider.getHitPoints(), "Wrong hp for spider");

        Monster slime = MonsterFactory.createSlime();
        assertEquals(1, slime.getAttackBonus(), "Wrong attack bonus");

        Monster skeleton = MonsterFactory.createSkeleton();
        assertEquals("Skeleton", skeleton.getName(), "Should be a skeleton");

        Monster ogre = MonsterFactory.createOgre();
        assertEquals("Ogre", ogre.getName(), "Should be an Ogre");

        Monster giant = MonsterFactory.createGiant();
        assertEquals("Giant", giant.getName(), "Wrong name");

        Monster beholder = MonsterFactory.createBeholder();
        assertEquals("Beholder", beholder.getName(), "Wrong name");

        Monster displacerBeast = MonsterFactory.createDisplacerBeast();
        assertEquals("Displacer Beast", displacerBeast.getName(), "Wrong name");
    }


    /**
     * Verify the appropriate strings are getting printed out.
     */
    @Test
    void testAttack() {

        // Make some monsters
        Monster[] monsters = {
                MonsterFactory.createGoblin(), MonsterFactory.createDragon(),
                MonsterFactory.createSpider(), MonsterFactory.createSlime(),
                MonsterFactory.createSkeleton(), MonsterFactory.createOgre(),
                MonsterFactory.createGiant(), MonsterFactory.createBeholder(),
                MonsterFactory.createDisplacerBeast()
        };


        // Attack each monster
        for (Monster monster : monsters) {
            monster.attackText();
        }
    }





}
