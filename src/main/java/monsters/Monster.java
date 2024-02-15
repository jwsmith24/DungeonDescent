package monsters;

import character.Adventurer;

/**
 * Defines monster actions.
 */
public abstract class Monster {

    // Monster attributes
    protected String name;
    protected MonsterStats stats;



    /**
     * Base constructor for all monsters
     */
    public Monster(String name, int hp, int attackBonus, int armorClass, int speed, int experience) {
        this.name = name;
        this.stats = MonsterStats.monsterStatBuilder(hp, attackBonus, armorClass,
                speed, experience);
    }


    // Methods for all monsters

    /**
     * Abstract method attack to ensure each monster type overrides with their own
     * flavor text.
     */
    public abstract void attack();


    public String getName() {
        return name;
    }
    public MonsterStats getStats() {
        return stats;
    }





}
