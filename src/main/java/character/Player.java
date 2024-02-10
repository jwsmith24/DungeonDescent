package character;

/**
 * Abstract class to define the base player character before its decorated.
 */
public abstract class Player implements Character{

   String name;
   int attack;
   int defence;
   int hitPoints;
   int energy;
   int speed;

   public Player(String name) {

       this.name = name;
       this.attack = Stats.BASE_ATTACK;
       this.defence = Stats.BASE_DEF;
       this.hitPoints = Stats.BASE_HP;
       this.energy = Stats.BASE_ENERGY;
       this.speed = Stats.BASE_SPEED;
   }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defence;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}


