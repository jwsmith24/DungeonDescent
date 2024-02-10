package character;

/**
 * Abstract class to define the base player character before its decorated by class, race, and background modifiers.
 */
public class BasicCharacter implements Character {
    String name;
    String race;

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
   int experience;
   String playerClass;
   String specialAbility;
   String racialAbility;
   String attackType;
   String characterSheet;

    /**
     * A Player starts with all the base stats plus whatever they're named by the user.
     * @param name character name
     */
   public BasicCharacter(String name) {

       this.name = name;

       // Set base core stats
       this.attack = GameConstants.BASE_ATTACK;
       this.defence = GameConstants.BASE_DEF;
       this.hitPoints = GameConstants.BASE_HP;
       this.energy = GameConstants.BASE_ENERGY;
       this.speed = GameConstants.BASE_SPEED;

       // Set base skills
       this.dungeoneering = GameConstants.BASE_DUNGEONEERING;
       this.lockPicking = GameConstants.BASE_LOCKPICKING;
       this.athletics = GameConstants.BASE_ATHLETICS;
       this.arcana = GameConstants.BASE_ARCANA;

       this.playerClass = GameConstants.CLASSLESS;
       this.attackType = GameConstants.UNARMED_ATTACK;
       this.experience = 0;
       this.race = null;
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

    public int getExperience() {
       return experience;
    }

    @Override
    public String getSpecialAbility() {
       return specialAbility;
    }

    @Override
    public void setSpecialAbility(String specialAbility) {

    }

    @Override
    public String getRacialAbility() {
       return racialAbility;
    }

    @Override
    public void setRacialAbility(String racialAbility) {

    }

    @Override
    public String getPlayerClass() {
       return playerClass;
    }

    @Override
    public void setPlayerClass(String playerClass) {

    }

    @Override
    public String getAttackType() {
       return attackType;
    }

    @Override
    public void setAttackType(String attackType) {

    }

    @Override
    public String getPlayerRace() {
       return race;
    }
    @Override
    public String getCharacterSheet() {

       return String.format("======================\n" +
               "|\tCharacter Info\n" +
               "======================\n" +
               "| Name: %s\n" +
               "| Experience: %s\n", getName(), getExperience());


    }


}


