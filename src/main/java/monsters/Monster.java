package monsters;

import character.Adventurer;

/**
 * Defines monster actions.
 */
public abstract class Monster {

    // Monster attributes

    protected int hp;
    protected int attackBonus;
    protected int armorClass;

    protected String name;
    protected int speed;
    protected int xp;


    /**
     * Base constructor for all monsters
     */
    public Monster(String name, int hp, int attackBonus, int armorClass, int speed, int experienceWorth) {
        this.name = name;
        this.hp = hp;
        this.attackBonus = attackBonus;
        this.armorClass = armorClass;
        this.xp = experienceWorth;
        this.speed = speed;
    }


    // Methods for all monsters

    /**
     * Attack a player.
     */
    public abstract void attack();

    public abstract String getName();
    public abstract int getXP();
    public abstract int getHp();
    public abstract int getAttackBonus();
    public abstract int getArmorClass();
    public abstract int getSpeed();




}
