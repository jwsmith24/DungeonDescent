package character;

public class Priest extends BasicCharacter {
    /**
     * A Priest has a unique special and gets a small bonus to HP and Defence.
     */
    public Priest(String name) {
        super(name);

        this.playerClass = GameConstants.PRIEST;
        this.hitPoints = getHitPoints() + GameConstants.PRIEST_BONUS;
        this.defence = getHitPoints() + GameConstants.PRIEST_BONUS;
        this.specialAbility = GameConstants.PRIEST_SPECIAL;
        this.attackType = GameConstants.PRIEST_ATTACK;
    }
}
