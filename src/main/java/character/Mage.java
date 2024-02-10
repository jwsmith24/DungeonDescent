package character;

/**
 * Mage decorator class.
 */
public class Mage extends Player {

    /**
     * A Mage has a unique special and their stats don't change from the base.
     * @param name References base player object.
     */
    public Mage(String name) {

        super(name);
        this.specialAbility = GameConstants.MAGE_SPECIAL;
        this.playerClass = GameConstants.MAGE;
        this.attackType = GameConstants.MAGE_ATTACK;


    }



}