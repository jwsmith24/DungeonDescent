package character;

/**
 * Builder for character stats.
 */
public class CharacterStats {

    // Core Stats
    private int attack;
    private int ac;
    private int hitPoints;
    private int energy;
    private int speed;
    private int luck;

    private int maxHP;


    public CharacterStats(int attack, int ac, int hitPoints, int energy, int speed, int luck) {
        this.attack = attack;
        this.ac = ac;
        this.hitPoints = hitPoints;
        this.energy = energy;
        this.speed = speed;
        this.luck = luck;
        this.maxHP = hitPoints; // max hp will be equal to starting hit points

    }

    public static CharacterStats statBuilder(Character character) {

        return new CharacterStats(
                character.getAttack(),
                character.getDefense(),
                character.getHitPoints(),
                character.getEnergy(),
                character.getSpeed(),
                character.getLuck()
        );


    }


    public int getAttack() {
        return attack;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }


    public int getAC() {
        return this.ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }


    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHp) {
        this.maxHP = maxHp;
    }


    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

}


