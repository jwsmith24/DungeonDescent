package character;

/**
 * Abstract class to define the base player character before its decorated by class, race, and background modifiers.
 */
public abstract class Player implements Character {

   String name;
   // Core Stats
   int attack;
   int defence;
   int hitPoints;
   int energy;
   int speed;
   int dungeoneering;
   int lockPicking;
   int athletics;
   int arcana;

    /**
     * A Player starts with all the base stats plus whatever they're named by the user.
     * @param name character name
     */
   public Player(String name) {

       this.name = name;

       // Set base core stats
       this.attack = Stats.BASE_ATTACK;
       this.defence = Stats.BASE_DEF;
       this.hitPoints = Stats.BASE_HP;
       this.energy = Stats.BASE_ENERGY;
       this.speed = Stats.BASE_SPEED;

       // Set bases kills
       this.dungeoneering = Stats.BASE_DUNGEONEERING;
       this.lockPicking = Stats.BASE_LOCKPICKING;
       this.athletics = Stats.BASE_ATHLETICS;
       this.arcana = Stats.BASE_ARCANA;
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
    public int getHitPoints() {
       return hitPoints;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public int getSpeed() {
        return speed;
    }


    @Override
    public int getDungeoneering() {
       return dungeoneering;
    }

    @Override
    public int getLockPicking() {
       return lockPicking;
    }

    @Override
    public int getAthletics() {
       return athletics;
    }

    @Override
    public int getArcana() {
       return arcana;
    }

}


