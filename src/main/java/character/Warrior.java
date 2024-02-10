package character;


/**
 * Warrior decorator class.
 */
public class Warrior extends Player {

    /**
     * A Warrior has a unique special and gain bonuses to HP and Defence.
     * @param name character name
     */
    public Warrior(String name) {
        super(name);

        this.playerClass = GameConstants.WARRIOR;
        this.hitPoints = 15;
        this.defence = 15;
        this.specialAbility = GameConstants.WARRIOR_SPECIAL;
        this.attackType = GameConstants.WARRIOR_ATTACK;
    }
}
