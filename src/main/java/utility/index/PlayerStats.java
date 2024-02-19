package utility.index;

/**
 * Player stat options that exist in the game.
 */
public enum PlayerStats {
    ATTACK(1),
    AC(12),
    HP(10),
    ENERGY(1),
    SPEED(1),
    LUCK(1);

    private final int baseSkill;

    PlayerStats(int baseSkill) {
        this.baseSkill = baseSkill;
    }

    public int getBaseValue() {
        return baseSkill;
    }





}
