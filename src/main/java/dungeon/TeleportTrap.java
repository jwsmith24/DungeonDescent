package dungeon;

import utility.DungeonUtil;
import utility.index.Condition;
import utility.index.PlayerSkills;

public class TeleportTrap extends Trap {


    private TeleportTrap(Condition effectType, int damage, PlayerSkills skillCheckType,
                         String discoveryText, String successText, String failureText, String surpriseText) {
        super(effectType, damage, skillCheckType, discoveryText, successText, failureText, surpriseText);
    }

    public static TeleportTrap teleportTrapBuilder() {

        String discoveryText = "You spot a glowing blue ring covering the ground ahead. It gives off"
                + " a mysterious glow";

        String surpriseText = "You realize that you've stepped inside a glowing blue circle that has " +
                " covered the ground. Instantly, you are teleported to small room filled with BEES! "
                + "You're stung multiple times before you find the door that leads out to the hallway "
                + "on the other side of the teleportation circle";

        String successText = "You sense that this is teleportation magic and that nothing good" +
                " awaits you on the other side. You jump over the circle.";

        String failureText = "Allured by the magical glow, you step into the circle. Instantly, you " +
                "are teleported to small room filled with BEES! You're stung multiple times before" +
                "you find the door that leads out to the hallway on the other side of the teleportation" +
                "circle";


        return new TeleportTrap(Condition.POISONED, DungeonUtil.TRAP_DAMAGE, PlayerSkills.ARCANA, discoveryText,
                successText, failureText, surpriseText
        );
    }


}
