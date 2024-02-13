package monsters;

public class Goblin extends Monster {

    /**
     * Builds a monster with goblin stats.
     */
   public Goblin() {
       super("Goblin", 7, 1, 15, 1, 50);
   }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {

        System.out.println("The goblin strikes at you with its short sword!");
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
