package character;

public class CharacterStats {

    // Core Stats
    private int attack;
    private int defense;
    private int hitPoints;
    private int energy;
    private int speed;
    private int luck;

    private int maxHP;


    public CharacterStats(int attack, int defense, int hitPoints, int energy, int speed, int luck) {
        this.attack = attack;
        this.defense = defense;
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


    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
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


