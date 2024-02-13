package monsters.factories;

import character.Adventurer;
import monsters.Monster;

public class DragonFactory extends Monster {

    /**
     * Builds a monster with dragon stats.
     */
    public DragonFactory() {
        super("Young Red Dragon", 178, 10, 18, 5, 5900);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {

        System.out.println();
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

