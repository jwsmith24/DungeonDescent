package monsters;

public class Spider extends Monster {

    /**
     * Builds a monster with spider stats.
     */
    public Spider() {
        super("Giant Spider", 26, 5, 14, 2, 200);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {
        System.out.println("The spider lunges at you to take a massive bite!");

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

