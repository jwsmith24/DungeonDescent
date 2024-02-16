package monsters;

public class MonsterStats {


    private int hp;
    private final int attackBonus;
    private final int armorClass;
    private final int speed;
    private final int experience;


    public MonsterStats(int hp, int attackBonus, int armorClass, int speed, int experience) {
        this.hp = hp;
        this.attackBonus = attackBonus;
        this.armorClass = armorClass;
        this.speed = speed;
        this.experience = experience;
    }


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

    public int getXP() {
        return experience;
    }


    public int getHp() {
        return hp;
    }

    ;

    public void setHp(int hp) {
        this.hp = hp;
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
