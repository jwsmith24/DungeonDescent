package monsters;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Instead of creating factory classes for each monster type, I've simplified the design so the client just has to
 * call the MonsterFactory method createMonster with the type of monster provided by the nested enum, MonsterType.
 *
 * <P>The monster factory is also capable of providing a random small, random medium, or random large monster.</P>
 */
public class MonsterFactory {

    // Random for monster gen
    private static final Random RANDOM = new Random();

    private static final List<Supplier<Monster>> smallMonsters = new ArrayList<>();
    private static final List<Supplier<Monster>> mediumMonsters = new ArrayList<>();
    private static final List<Supplier<Monster>> largeMonsters = new ArrayList<>();



    // Initialize the array list of factory methods
    static {

            smallMonsters.add(MonsterFactory::createGoblin);
            smallMonsters.add(MonsterFactory::createSkeleton);
            smallMonsters.add(MonsterFactory::createSlime);

            mediumMonsters.add(MonsterFactory::createOgre);
            mediumMonsters.add(MonsterFactory::createDisplacerBeast);
            mediumMonsters.add(MonsterFactory::createSpider);

            largeMonsters.add(MonsterFactory::createDragon);
            largeMonsters.add(MonsterFactory::createBeholder);
            largeMonsters.add(MonsterFactory::createGiant);
    };




    public static Monster createGoblin() {
        return new Goblin();
    }

    public static Monster createSkeleton() {
        return new Skeleton();
    }

    public static Monster createSpider() {
        return new Spider();
    }

    public static Monster createSlime() {
        return new Slime();
    }

    public static Monster createOgre() {
        return new Ogre();
    }

    public static Monster createDragon() {
        return new Dragon();
    }

    public static Monster createBeholder() {
        return new Beholder();
    }

    public static Monster createDisplacerBeast() {
        return new DisplacerBeast();
    }

    public static Monster createGiant() {
        return new Giant();
    }



    public static Monster randomSmallMonster() {

        // select a random number bounded by the size of the list
        int randomMonsterIndex = RANDOM.nextInt(smallMonsters.size());

        // call the factory method for the monster at the random index
        return smallMonsters.get(randomMonsterIndex).get();
    }

    public static Monster randomMediumMonster() {

        // select a random number bounded by the size of the list
        int randomMonsterIndex = RANDOM.nextInt(mediumMonsters.size());

        // call the factory method for the monster at the random index
        return mediumMonsters.get(randomMonsterIndex).get();
    }

    public static Monster randomLargeMonster() {

        // select a random number bounded by the size of the list
        int randomMonsterIndex = RANDOM.nextInt(largeMonsters.size());

        // call the factory method for the monster at the random index
        return largeMonsters.get(randomMonsterIndex).get();
    }


    private MonsterFactory() {
        // Don't want any monster factory objects.
    }

}
