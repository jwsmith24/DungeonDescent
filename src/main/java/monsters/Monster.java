package monsters;

/**
 * Defines monster actions.
 */
public abstract class Monster {

    // Monster attributes
    protected String name;
    protected MonsterStats stats;


    /**
     * Base constructor for all monsters.
     */
    public Monster(String name, int hp, int attackBonus, int armorClass,
                   int speed, int experience) {
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

    /**
     * Apply damage to monster. If the damage is fatal, display to player.
     * @param value amount of damage taken
     */
    public void takeDamage(int value) {

        stats.takeDamage(value);

        if (!isAlive()) {
            System.out.println("The damage is fatal!");
        }


    }

    /**
     * Applies cycle buff to monster.
     */
    public void applyMonsterBuff(int cycleCount) {
        stats.applyMonsterBuff(cycleCount);
    }


    /**
     * Determines if monster is still alive.
     */
    public boolean isAlive() {
        return stats.getHitPoints() > 0;
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

    public int getHitPoints() {
        return stats.getHitPoints();
    }

    public int getSpeed() {
        return stats.getSpeed();
    }

    public int getExperience() {
        return stats.getExperience();
    }




}
