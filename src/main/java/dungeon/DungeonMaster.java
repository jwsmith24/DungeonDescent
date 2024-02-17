package dungeon;

import character.Adventurer;
import character.PlayerInventory;
import monsters.Monster;
import monsters.MonsterFactory;
import utility.CharacterBuilder;
import utility.DungeonUtil;
import utility.index.EquipmentSlot;
import utility.index.Item;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Director for all actions in the dungeon. Acts as the mediator to avoid tight coupling of classes.
 * Specifically Adventurer and Monster.
 */
public class DungeonMaster {

    // The dungeon master knows about the player and the monsters.
    private static Adventurer player;

    // DungeonMaster also knows about the player inventory and the dungeon itself which are
    // both static

    private static int dungeonLevel = 1;
    private static int cycleCount = 1;

    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);


    /**
     * Uses the Character Builder class to allow the user to build their character.
     */
    private static void spawnCharacter() {
        player = CharacterBuilder.createCharacter();
    }


    // Each floor has one fight and a chance to find some loot or a shop
    public static void runDungeon() {
        // welcome text
        displayWelcomeText();

        // Create character
        spawnCharacter();

        // run tutorial and give starting weapon based on class
        runTutorial();

        // start the dungeon
        runDungeonCycle();


        // run cycle 2 (BOSS) - BEHOLDER
        // run cycle 3
        // run cycle 4 (FINAL BOSS) - DRAGON

    }

    private static void displayWelcomeText() {
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*            Welcome to Dungeon Descent!              *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
    }


    private static void runTutorial() {
        DungeonUtil.printSpacer();
        // Porc the Orc Warrior uses sword strike to attack!
        System.out.println(player.getName() + " the " + player.getPlayerRace() + " " + player.getPlayerClass() + " uses " + player.getPlayerClass().getAttackText() + " to attack!");

        // determine starting weapon based on class
        Item startingWeapon = giveStartingWeapon();

        System.out.println("Upon entering the dungeon, you find a chest containing a " + startingWeapon.getItemName());

        // equip starting weapon
        PlayerInventory.equipItem(EquipmentSlot.WEAPON, startingWeapon, true);
        //PlayerInventory.equipItem(EquipmentSlot.WEAPON, Item.SWORD_OF_SLASHING);


    }

    private static Item giveStartingWeapon() {

        Item startingWeapon;

        switch (player.getPlayerClass()) {

            case MAGE:
                startingWeapon = Item.WARPED_WAND;
                break;

            case PRIEST:
                startingWeapon = Item.RUSTY_MACE;
                break;

            case WARRIOR:
                startingWeapon = Item.RUSTY_SWORD;
                break;

            case THIEF:
                startingWeapon = Item.RUSTY_DAGGER;
                break;

            default:
                startingWeapon = Item.NO_WEAPON;
        }


        return startingWeapon; // so we can display what it is
    }

    //todo:
    // implement looting/finding new items,
    // implement traps that apply conditions
    //


    /**
     * Asks the user if they want to take a long rest and execute if yes.
     */
    private static void promptLongRest() {
        System.out.println("Do you want to take a long rest?");
        int result = scanner.nextInt();
        scanner.nextLine();

        if (result == 1) {
            player.takeLongRest();
        }


    }

    /**
     * Helper method to run the medium monster encounter every major level.
     *
     * @return boolean isPlayerAlive
     */
    private static boolean runMediumMonsterFloor(Adventurer player, int cycleCount) {
        boolean playerIsAlive;
        int lootChance = DungeonUtil.rollAD20();

        // applies a stacking buff every 5 floors
        player.applyPower();

        // Set active monster to a random medium monster
        Monster monster = MonsterFactory.randomMediumMonster();

        DungeonUtil.printSpecialWrapper();
        System.out.println("A " + monster.getName() + " appears!\n");
        DungeonUtil.printSpecialWrapper();

        // go to combat
        Combat dungeonCombat = new Combat(player, monster, cycleCount);

        // combat resolves into a boolean that's true if player is alive or false if they died.
        playerIsAlive = dungeonCombat.combat();

        // Chance to find the shopkeeper or loot lying around
        if (playerIsAlive && (lootChance) > 15) {

            Shop.shopKeeperEncounter(scanner);

        } else if (playerIsAlive && (lootChance > 10)) {
            System.out.println("The " + monster.getName() + " leaves behind some loot!");
            lootTheRoom();
        }

        // If player is alive at the end of encounter, apply XP and give option to long rest.
        if (playerIsAlive) {
            player.gainMediumXP();
            promptLongRest();
        }

        return playerIsAlive;
    }


    /**
     * Helper method to run the small monster encounter every minor level.
     *
     * @return if player is still alive at the end of the encounter
     */
    private static boolean runSmallMonsterFloor(Adventurer player, int cycleCount) {
        boolean playerIsAlive;
        int lootChance = DungeonUtil.rollAD20(); // roll a d20 each floor for chance at finding loot

        // set active monster to a random small monster
        Monster monster = MonsterFactory.randomSmallMonster();

        DungeonUtil.printSpecialWrapper();
        System.out.println("A " + monster.getName() + " appears!");
        DungeonUtil.printSpecialWrapper();

        // go to combat
        Combat dungeonCombat = new Combat(player, monster, cycleCount);

        // combat resolves into a boolean that's true if player is alive or false if they died.
        playerIsAlive = dungeonCombat.combat();

        // As long as the player is still alive, they get a chance to find loot.
        if (playerIsAlive && lootChance > 12) {
            System.out.println("The " + monster.getName() + " leaves behind some loot!");
            lootTheRoom();
        }

        // If player is alive at the end of encounter, apply XP.
        if (playerIsAlive) {
            player.gainSmallXP();
        }

        return playerIsAlive;
    }

    /**
     * Runs the medium monster floor.
     *
     * @return if player is still alive at the end of the encounter
     */
    private static boolean runBossMonsterFloor(Adventurer player, int cycleCount) {
        boolean playerIsAlive;
        int lootChance = DungeonUtil.rollAD20();

        // applies a stacking buff every 5 floors
        player.applyPower();

        // Set active monster to a random medium monster
        Monster monster = MonsterFactory.randomLargeMonster();

        DungeonUtil.printSpecialWrapper();
        System.out.println("A " + monster.getName() + " appears!\n");
        DungeonUtil.printSpecialWrapper();

        // go to combat
        Combat dungeonCombat = new Combat(player, monster, cycleCount);

        // combat resolves into a boolean that's true if player is alive or false if they died.
        playerIsAlive = dungeonCombat.combat();

        // If player is alive at the end of encounter, apply XP, option to shop
        // and give option to long rest.
        if (playerIsAlive) {
            player.gainBossXP();
            Shop.shopKeeperEncounter(scanner);
            promptLongRest();
        }

        return playerIsAlive;
    }

    /**
     * Logic for running a dungeon cycle that consists of 10 levels.
     *
     * <p>Levels 3 and 7 are trap levels. </p>
     *
     * <p>Levels 5 and 10 are medium boss and large boss respectively.</p>
     *
     * <p>All other levels are small monster encounters.</p>
     */
    private static void runDungeonCycle() {

        int level = 1;

        boolean playerIsAlive = true;

        // extra shot of buffs to start off the cycle
        player.applyPower();

        while (level <= 10 && playerIsAlive) {

            if (level == 3) {
                System.out.println("It's a trap!");

            } else if (level == 5) {

                playerIsAlive = runMediumMonsterFloor(player, cycleCount);

                // run boss floor at level 10
            } else if (level == 7) {
                System.out.println("It's a trap!");

                // cycle boss
            } else if (level == 10) {
                playerIsAlive = runBossMonsterFloor(player, cycleCount);

                // otherwise run normal floor with small monster
            } else {
                playerIsAlive = runSmallMonsterFloor(player, cycleCount);

            }

            // if player is still alive after combat cycle, clean up level and move on
            if (playerIsAlive) {
                // check for level up and display recap to player at end of the level
                player.checkLevelUp();
                levelRecap();

                level++;
                dungeonLevel++;
            }

        }

        // after the 10th level, increase cycle count (which modifies monster difficulty)
        cycleCount++;

    }


    /**
     * Displays important info to player at the end of the level.
     */
    private static void levelRecap() {

        DungeonUtil.printSpacer();

        System.out.println("*******************************************************");
        System.out.println("*                    Level Recap                      *");
        System.out.printf("*   Dungeon Level: %d                                  *\n", dungeonLevel);
        System.out.printf("*   Player Level: %d                                   *\n", player.getLevel());
        System.out.printf("*   Player HP: %d/%d                                  *\n", player.getCurrentHP(), player.getMaxHP());
        System.out.printf("*   Player XP: %d/%d                                    *\n", player.getCurrentXP(), player.nextLevelXP());
        System.out.printf("*   Player Gold: %d                                    *\n", PlayerInventory.currentGoldBalance());
        System.out.println("*******************************************************");

        DungeonUtil.printSpacer();
    }


    /**
     * Handles random gold drops and adding to inventory at the end of a room. Adds luck score
     * to amount of gold found.
     */
    private static void lootTheRoom() {
        int goldFound = DungeonUtil.rollAD20() + player.getLuck();
        PlayerInventory.pickUpGold(goldFound) ;
    }


}





















