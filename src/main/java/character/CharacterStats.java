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



    public int getAC() {
        return this.ac;
    }



    public int getCurrentHP() {
        return currentHP;
    }


    /**
     * Zeroizes hp when hp falls below 0.
     */
    protected void zeroizeHP() {
        this.currentHP = 0;
    }

    protected void restoreHP(int amount) {
        int hpAfterHeal = currentHP + amount;

        // prevents current hp from ever going over max
        this.currentHP = Math.min(maxHP, hpAfterHeal);
    }

    /**
     * Applies damage to character.
     * @param amount of damage taken
     */
    protected void takeDamage(int amount) {
        this.currentHP -= amount;
    }

    public int getMaxHP() {
        return maxHP;
    }



    public int getEnergy() {
        return energy;
    }




    public int getSpeed() {
        return speed;
    }




    public int getLuck() {
        return luck;
    }



}


