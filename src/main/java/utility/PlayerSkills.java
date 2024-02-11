package utility;

/**
 * Character skill options.Could have methods to calculate skill modifications based on dungeon
 * events.
 */
public enum PlayerSkills {

    DUNGEONEERING,
    LOCK_PICKING,
    ATHLETICS,
    ARCANA,
    HISTORY;

    private static final int BASE_SKILL_VALUE = 1;

    public int getBaseValue() {
        return BASE_SKILL_VALUE;
    }



}
