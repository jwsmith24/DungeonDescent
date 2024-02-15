package dungeon;

import character.Adventurer;
import monsters.Monster;
import monsters.MonsterFactory;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;

/**
 * Director for all actions in the dungeon. Acts as the mediator to avoid tight coupling of classes. Specifically
 * Adventurer and Monster.
 */
public class DungeonMaster {

    // The dungeon master knows about the player and the monsters.
    Adventurer player;
    Monster monster;

    // DungeonMaster also knows about the player inventory and the dungeon itself which are
    // both static


















}
