import monsters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonsterTest {


    @Test
    void testGenerateSmallMonster() {
        Monster random = MonsterFactory.randomSmallMonster();

        assertTrue((random instanceof Goblin) || (random instanceof Skeleton) ||
                (random instanceof Slime));

    }

    @Test
    void testGenerateMediumMonster() {
        Monster random = MonsterFactory.randomMediumMonster();

        assertTrue((random instanceof Spider) || (random instanceof Ogre) ||
                (random instanceof DisplacerBeast));

    }

    @Test
    void testGenerateLargeMonster() {
        Monster random = MonsterFactory.randomLargeMonster();

        assertTrue((random instanceof Dragon) || (random instanceof Beholder) ||
                (random instanceof Giant));

    }

    @Test
    void testMonsterFactory() {

        // Make some monsters
        Monster goblin = MonsterFactory.createGoblin();
        Monster dragon = MonsterFactory.createDragon();
        Monster spider = MonsterFactory.createSpider();
        Monster slime = MonsterFactory.createSlime();
        Monster skeleton = MonsterFactory.createSkeleton();
        Monster ogre = MonsterFactory.createOgre();
        Monster giant = MonsterFactory.createGiant();
        Monster beholder = MonsterFactory.createBeholder();
        Monster displacerBeast = MonsterFactory.createDisplacerBeast();


        // Make sure the stats line up
        assertEquals("Goblin", goblin.getName(),
                "Should be a goblin");
        assertEquals(26, spider.getHP(),
                "Wrong hp for spider");
        assertEquals(18, dragon.getArmorClass(),
                "Wrong AC for dragon");
        assertEquals("Skeleton", skeleton.getName(),
                "Should be a skeleton");
        assertEquals(1, slime.getAttackBonus(),
                "Wrong attack bonus");
        assertEquals("Ogre", ogre.getName(),
                "Should be an Ogre");
        assertEquals("Giant", giant.getName(),
                "Wrong name");
        assertEquals("Beholder", beholder.getName(),
                "wrong name");
        assertEquals("Displacer Beast", displacerBeast.getName(),
                "Wrong name");

    }


    /**
     * Verify the appropriate strings are getting printed out.
     */
    @Test
    void testAttack() {

        // Make some monsters
        Monster goblin = MonsterFactory.createGoblin();
        Monster dragon = MonsterFactory.createDragon();
        Monster spider = MonsterFactory.createSpider();
        Monster slime = MonsterFactory.createSlime();
        Monster skeleton = MonsterFactory.createSkeleton();
        Monster ogre = MonsterFactory.createOgre();
        Monster giant = MonsterFactory.createGiant();
        Monster beholder = MonsterFactory.createBeholder();
        Monster displacerBeast = MonsterFactory.createDisplacerBeast();

        goblin.attackText();
        dragon.attackText();
        spider.attackText();
        slime.attackText();
        skeleton.attackText();
        ogre.attackText();
        giant.attackText();
        beholder.attackText();
        displacerBeast.attackText();
    }





}
