package monsters;

public class Slime extends Monster {

    /**
     * Builds a monster with Slime stats.
     */
    public Slime() {
        super("OOZE", 22, 3, 8, 0, 100);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {

        System.out.println("The ooze forms into a massive fist that sails in your direction!");
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

