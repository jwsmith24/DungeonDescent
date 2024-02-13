package monsters.factories;

import character.Adventurer;
import monsters.Monster;

public class GoblinFactory extends Monster {

    /**
     * Builds a monster with goblin stats.
     */
   public GoblinFactory() {
       super("Goblin", 7, 1, 15, 1, 50);
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
