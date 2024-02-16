package monsters;

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


    /**
     * Abstract method attack to ensure each monster type overrides with their own flavor text.
     */
    public void attackText() {

        System.out.println("The monster attacks!");
    }

    //todo: model after player take damage
    public void takeDamage(int value) {
        stats.setHp(stats.getHp() - value);
    }


    /**
     * Determines if monster is still alive.
     */
    public boolean isAlive() {
        return stats.getHp() > 0;
    }

    public String getName() {
        return name;
    }


    public int getArmorClass() {
        return stats.getArmorClass();
    }

    public int getAttackBonus() {
        return stats.getAttackBonus();
    }

    public int getHP() {
        return stats.getHp();
    }

    public int getSpeed() {
        return stats.getSpeed();
    }

    public int getXP() {
        return stats.getXP();
    }




}
