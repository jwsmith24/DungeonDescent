package monsters;

public class MonsterStats {


    private int hp;
    private final int attackBonus;
    private final int armorClass;
    private final int speed;
    private final int experience;



    private MonsterStats(int hp, int attackBonus, int armorClass, int speed, int experience) {
        this.hp = hp;
        this.attackBonus = attackBonus;
        this.armorClass = armorClass;
        this.speed = speed;
        this.experience = experience;
    }


    /**
     * Builder for monster stats.
     */
    public static MonsterStats monsterStatBuilder(int hp, int attackBonus,
                                                  int armorClass, int speed, int experience) {

        return new MonsterStats(
                hp,
                attackBonus,
                armorClass,
                speed,
                experience
        );

    }

    public int getExperience() {
        return experience;
    }


    public int getHitPoints() {
        return hp;
    }

    ;

    /**
     * Applies damage to monster.
     */
    public void takeDamage(int amount) {
        this.hp -= amount;

    }

    public int getAttackBonus() {
        return attackBonus;
    }


    public int getArmorClass() {
        return armorClass;
    }


    public int getSpeed() {
        return speed;
    }





}
