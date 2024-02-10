package character;

/**
 * Thief decorator class.
 */
public class Thief extends BasicCharacter {

    /**
     * A Thief has a unique special and gets a small bonus to HP and Defence.
     * @param name character name
     */
    public Thief(String name) {
        super(name);

        this.playerClass = GameConstants.THIEF;
        this.hitPoints = getHitPoints() + GameConstants.THIEF_BONUS;
        this.defence = getDefense() + GameConstants.THIEF_BONUS;
        this.specialAbility = GameConstants.THIEF_SPECIAL;
        this.attackType = GameConstants.THIEF_ATTACK;
    }
}
