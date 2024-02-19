package character;

/**
 * Builder for character stats.
 */
public class CharacterStats {

    // Core Stats
    private int attack;
    private int armorClass;
    private int currentHitPoints;
    private int energy;
    private int speed;
    private int luck;

    private int maxHitPoints;


    /**
     * Encapsulates character stats into one object.
     */
    public CharacterStats(int attack, int armorClass, int currentHitPoints,
                          int energy, int speed, int luck) {
        this.attack = attack;
        this.armorClass = armorClass;
        this.currentHitPoints = currentHitPoints;
        this.energy = energy;
        this.speed = speed;
        this.luck = luck;
        this.maxHitPoints = currentHitPoints; // max hp will be equal to starting hit points

    }

    /**
     * Builds a character stat object from an existing character.
     */
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

    /**
     * Applies the stat boost to the player's stats.
     */
    public void applyPowerStatBoost() {

        this.attack++;
        this.armorClass++;
        this.energy++;
        this.speed++;
        this.luck++;

        this.maxHitPoints = maxHitPoints + 10;
        this.currentHitPoints = currentHitPoints + 10;

    }


    public int getAttack() {
        return attack;
    }



    public int getArmorClass() {
        return this.armorClass;
    }



    public int getCurrentHitPoints() {
        return currentHitPoints;
    }


    /**
     * Zeroizes hp when hp falls below 0.
     */
    protected void zeroizeHitPoints() {
        this.currentHitPoints = 0;
    }

    protected void restoreHitPoints(int amount) {
        int hpAfterHeal = currentHitPoints + amount;

        // prevents current hp from ever going over max
        this.currentHitPoints = Math.min(maxHitPoints, hpAfterHeal);
    }

    /**
     * Applies damage to character.
     * @param amount of damage taken
     */
    protected void takeDamage(int amount) {
        this.currentHitPoints -= amount;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
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


