package monsters.factories;

import character.Adventurer;
import monsters.Monster;

public class SkeletonFactory extends Monster {

    /**
     * Builds a monster with skeleton stats.
     */
    public SkeletonFactory() {
        super("Skeleton", 13, 4, 13, 1, 50);
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
