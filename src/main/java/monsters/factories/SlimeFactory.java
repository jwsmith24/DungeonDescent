package monsters.factories;

import character.Adventurer;
import monsters.Monster;

public class SlimeFactory extends Monster {

    /**
     * Builds a monster with Slime stats.
     */
    public SlimeFactory() {
        super("OOZE", 22, 3, 8, 0, 100);
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

