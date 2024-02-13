package monsters;

public class Ogre extends Monster {

    /**
     * Builds a monster with goblin stats.
     */
    public Ogre() {
        super("Ogre", 59, 6, 11, 1, 450);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {

        System.out.println("The ogre attacks you with it's massive spiked club!");
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
