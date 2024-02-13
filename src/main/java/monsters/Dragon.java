package monsters;

public class Dragon extends Monster {

    /**
     * Builds a monster with dragon stats.
     */
    public Dragon() {
        super("Young Red Dragon", 178, 10, 18, 5, 5900);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {

        System.out.println("The Dragon roars as the corridor erupts into flames!");
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

