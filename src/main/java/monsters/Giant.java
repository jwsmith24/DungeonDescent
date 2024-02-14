package monsters;

public class Giant extends Monster {

    public Giant() {
        super("Giant", 140, 11, 18, 1, 5000);
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
