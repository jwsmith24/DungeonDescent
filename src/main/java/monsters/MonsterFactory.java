package monsters;


import java.util.Random;

/**
 * Instead of creating factory classes for each monster type, I've simplified the design so the client just has to
 * call the MonsterFactory method createMonster with the type of monster provided by the nested enum, MonsterType.
 *
 * <P>The monster factory is also capable of providing a random small, random medium, or random large monster.</P>
 */
public class MonsterFactory {

    // Random for monster gen
    private static final Random RANDOM = new Random();


    /**
     *
     */
    public static Monster createMonster(MonsterType monsterType) {

        switch (monsterType) {

            case GOBLIN:
                return new Goblin();
            case SKELETON:
                return new Skeleton();
            case SPIDER:
                return new Spider();
            case SLIME:
                return new Slime();
            case OGRE:
                return new Ogre();
            case DRAGON:
                return new Dragon();
            case BEHOLDER:
                return new Beholder();
            case DISPLACER_BEAST:
                return new DisplacerBeast();
            default:
                throw new IllegalArgumentException("Monster type not supported yet: " + monsterType);
        }

    }

    public enum MonsterType {

        // Small monsters
        GOBLIN,
        SKELETON,
        SLIME,

        // Medium monsters
        SPIDER,
        DISPLACER_BEAST,
        OGRE,
        WEREWOLF,

        // Large monsters
        BEHOLDER,
        GIANT,
        DRAGON;



    }

    public static Monster randomSmallMonster() {

        // pull the small monsters into an array
        MonsterType[] smallMonsters = {MonsterType.SKELETON, MonsterType.GOBLIN, MonsterType.SLIME};

        // select a random number bounded by the size of the array
        int randomMonsterIndex = RANDOM.nextInt(smallMonsters.length);

        // return a monster that is the type at the random index
        return createMonster(smallMonsters[randomMonsterIndex]);

    }

    public static Monster randomMediumMonster() {
        // pull the small monsters into an array
        MonsterType[] mediumMonsters = {MonsterType.SPIDER, MonsterType.OGRE, MonsterType.DISPLACER_BEAST};

        // select a random number bounded by the size of the array
        int randomMonsterIndex = RANDOM.nextInt(mediumMonsters.length);

        // return a monster that is the type at the random index
        return createMonster(mediumMonsters[randomMonsterIndex]);
    }

    public static Monster randomLargeMonster() {
        // pull the small monsters into an array
        MonsterType[] largeMonsters = {MonsterType.DRAGON, MonsterType.BEHOLDER, MonsterType.GIANT};

        // select a random number bounded by the size of the array
        int randomMonsterIndex = RANDOM.nextInt(largeMonsters.length);

        // return a monster that is the type at the random index
        return createMonster(largeMonsters[randomMonsterIndex]);
    }



    private MonsterFactory() {
        // Don't want any monster factory objects.
    }

}
