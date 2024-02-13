package monsters;

public class Skeleton extends Monster {

    /**
     * Builds a monster with skeleton stats.
     */
    public Skeleton() {
        super("Skeleton", 13, 4, 13, 1, 50);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {

        System.out.println("The skeleton swings its shattered blade at you");

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
