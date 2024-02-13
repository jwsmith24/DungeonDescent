package monsters;


/**
 * Instead of creating factory classes for each monster type, I've simplified the design so the client just has to
 * call the MonsterFactory method createMonster with the type of monster provided by the nested enum, MonsterType.
 */
public class MonsterFactory {

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
            default:
                throw new IllegalArgumentException("Monster type not supported: " + monsterType);
        }

    }

    public enum MonsterType {

        // Small monsters
        GOBLIN,
        SKELETON,
        SPIDER,

        // Medium monsters
        SLIME,
        OGRE,

        // Large monsters
        BEHOLDER,
        DRAGON;



    }

    private MonsterFactory() {
        // Don't want any monster factory objects.
    }

}
