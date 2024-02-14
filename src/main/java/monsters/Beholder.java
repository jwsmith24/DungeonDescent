package monsters;

public class Beholder extends Monster {


    /**
     * Builds a monster with Beholder stats.
     */
    public Beholder() {
        super("Beholder", 180, 7, 18, 5, 10000);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getXP() {
        return xp;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public int getArmorClass() {
        return armorClass;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}
