package dungeon;


import character.Adventurer;
import monsters.Monster;

/**
 * This class handles combat encounters between two game entities.
 */
public class Combat {

    Adventurer player;
    Monster monster;

    /**
     * Determines if player is still alive.
     */
    private boolean isPlayerAlive(Adventurer player) {
        return player.getStats().getHitPoints() > 0;
    }

    /**
     * Determines if monster is still alive.
     */
    private boolean isMonsterAlive(Monster monster) {
        return monster.getStats().getHp() > 0;
    }

    public void fightMonster(Adventurer player, Monster monster) {

        // while both the player AND the monster are alive, continue combat.
        



    }









}
