package monsters;

public class MonsterStats {


    private int hp;
    private int attackBonus;
    private int armorClass;
    private int speed;
    private int experience;


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

    ;

    public void setXP(int experience) {
        this.experience = experience;
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

    ;

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getArmorClass() {
        return armorClass;
    }

    ;

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getSpeed() {
        return speed;
    }

    ;

    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
