package dungeon;

import utility.DungeonUtil;
import utility.index.Condition;
import utility.index.PlayerSkills;

public class FalseFloorTrap extends Trap {


    private FalseFloorTrap(String name, Condition effectType, int damage,
                           PlayerSkills skillCheckType, String discoveryText,
                           String successText, String failureText, String surpriseText,
                           int difficultyCheck) {

        super(name, effectType, damage, skillCheckType, discoveryText, successText,
                failureText, surpriseText, difficultyCheck);
    }

    /**
     * Builder for the false floor trap.
     */
    public static FalseFloorTrap falseFloorTrapBuilder() {
        String discoveryText = "You see that the floor ahead of you looks spotless compared to "
                + " what you've seen in the dungeon so far.";

        String surpriseText = "All of a sudden you feel the floor drop out from under "
                + "you as you're " + "falling into the abyss. After a few seconds, you crash into "
                + "the ground a few yards ahead in the dungeon.";

        String successText = "You determine that this is a false floor and find a path around "
                + "along the side of the hallway";

        String failureText = "As you step forward you feel the ground drop out from under "
                + "you as you're " + "falling into the abyss. After a few seconds, you crash into "
                + "the ground a few yards ahead in the dungeon.";

        return new FalseFloorTrap("False Floor Trap", Condition.STUNNED,
                DungeonUtil.TRAP_DAMAGE, PlayerSkills.DUNGEONEERING,
                discoveryText, successText, failureText, surpriseText,
                DungeonUtil.TRAP_DC
        );
    }


}
