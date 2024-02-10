package character;

/**
 * Abstract class to define the base player character before its decorated by class, race, and background modifiers.
 */
public abstract class Player implements Character {

    Character decoratedCharacter;
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

   String playerClass;
   String specialAbility;

   String attackType;

    /**
     * A Player starts with all the base stats plus whatever they're named by the user.
     * @param name character name
     */
   public Player(String name) {

       this.name = name;

       // Set base core stats
       this.attack = GameConstants.BASE_ATTACK;
       this.defence = GameConstants.BASE_DEF;
       this.hitPoints = GameConstants.BASE_HP;
       this.energy = GameConstants.BASE_ENERGY;
       this.speed = GameConstants.BASE_SPEED;

       // Set bases kills
       this.dungeoneering = GameConstants.BASE_DUNGEONEERING;
       this.lockPicking = GameConstants.BASE_LOCKPICKING;
       this.athletics = GameConstants.BASE_ATHLETICS;
       this.arcana = GameConstants.BASE_ARCANA;

       this.playerClass = GameConstants.CLASSLESS;
       this.attackType = GameConstants.UNARMED_ATTACK;
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

    @Override
    public String getSpecialAbility() {
       return specialAbility;
    }

    @Override
    public String getPlayerClass() {
       return playerClass;
    }

    @Override
    public String getAttackType() {
       return attackType;
    }
    @Override
    public String toString() {

        return """
               ======================
               Character Info
               ======================
               Name: %s
               Class: %s
               Special Ability: %s
               ======================
               Attack Type: %s
               Attack Bonus: + %s
               ======================
               Stats
               
               
               """.formatted( getName(),getPlayerClass(), getSpecialAbility(),getAttackType(),
                getAttack());

    }

}


