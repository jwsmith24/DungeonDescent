package character;

/**
 * Builder for character stats.
 */
public class CharacterStats {

    // Core Stats
    private int attack;
    private int ac;
    private int currentHP;
    private int energy;
    private int speed;
    private int luck;

    private int maxHP;


    public CharacterStats(int attack, int ac, int currentHP, int energy, int speed, int luck) {
        this.attack = attack;
        this.ac = ac;
        this.currentHP = currentHP;
        this.energy = energy;
        this.speed = speed;
        this.luck = luck;
        this.maxHP = currentHP; // max hp will be equal to starting hit points

    }

    public static CharacterStats statBuilder(Character character) {
        // copy all the character stats and return a new character with the copied stats
        // Ensures complete separation for the adventurer object

        Character copy = new BasicCharacter(character);
        int atk = copy.getAttack();
        int def = copy.getDefense();
        int hp = copy.getHitPoints();
        int eng = copy.getEnergy();
        int speed = copy.getSpeed();
        int luck = copy.getLuck();


        return new CharacterStats(atk, def, hp, eng, speed, luck);

    }
    public void applyPowerStatBoost() {

        this.attack++;
        this.ac++;
        this.energy++;
        this.speed++;
        this.luck++;

        this.maxHP = maxHP + 10;
        this.currentHP = currentHP + 10;

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


    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int hitPoints) {
        this.currentHP = hitPoints;
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


