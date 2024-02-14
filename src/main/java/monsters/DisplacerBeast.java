package monsters;

public class DisplacerBeast extends Monster {


    /**
     * Builds a monster with displacer beast stats.
     */
    public DisplacerBeast() {
        super("Displacer Beast", 85, 6, 13, 7, 700);
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
