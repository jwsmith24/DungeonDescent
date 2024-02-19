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

    private static Monster monster;
    private static boolean dungeonIsScripted;

    // DungeonMaster also knows about the player inventory and the dungeon itself which are
    // both static

    private static int dungeonLevel = 1;
    private static int cycleCount = 1;

    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);


    public static void setIsScripted(boolean dungeonIsScripted) {

        DungeonMaster.dungeonIsScripted = dungeonIsScripted;
    }


    /**
     * Uses the Character Builder class to allow the user to build their character. Once character
     * is created, initialize inventory.
     */
    private static void spawnCharacter() {
        player = CharacterBuilder.createCharacter();
        player.regainUltimate();
    }

    /**
     * Runs the dungeon with scripted inputs for grading/demonstration.
     *
     * <p>If the player dies, they restart at the beginning of the dungeon. They lose their gold
     * but maintain their level and equipment.</p>
     */
    private static void runScriptedDungeon() {

        System.out.println("Welcome to the scripted version of Dungeon Descent!");

        System.out.println("You'll be watching a pre-generated character as they"
                + " navigate the dungeon.");

        System.out.println("The character is programmed to "
                + "\n- Use their special ability if they have charges available on a boss fight"
                + "\n- Use their healing potion if below half hp" + "\n- Use their basic attack.");

        System.out.println("If the player dies, they'll respawn at the beginning of the dungeon. "
                + "They'll lose" + "their gold but will maintain their level and equipment "
                + "allowing them to get stronger.");

        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        // set active player to the generated character
        player = CharacterBuilder.createScriptedCharacter();

        // display basic character info and give starter weapon
        runTutorial();


        // start scripted player off with potion
        PlayerInventory.findPotionOfHealing();

        boolean play = true;

        while (play) {

            // run dungeon cycles
            while (cycleCount <= 4 && player.isAlive()) {

                runDungeonCycle();
            }
            // if player finishes the dungeon alive, display complete message!
            if (player.isAlive()) {
                dungeonComplete();
                play = false;
                // otherwise display the recap
            } else {
                dungeonRecap();

                // prompt player to reset or quit
                if (promptReset()) {

                    // if player chooses to reset, reset dungeon level and cycle count
                    // apply long rest, reset inventory, start with potion and nice weapon
                    cycleCount = 0;
                    dungeonLevel = 0;
                    player.takeLongRest();
                    PlayerInventory.initializeInventory();
                    PlayerInventory.findPotionOfHealing();
                    PlayerInventory.equipItem(EquipmentSlot.WEAPON, Item.SUSSUR_SWORD,
                            true);
                }
            }
        }

    }

    /**
     * Give player option to reset game and try again or quit.
     */
    private static boolean promptReset() {
        System.out.println("You died, but this is not the end!");
        System.out.println("Lose your gold and gear, but keep your power and start again.");
        System.out.println("You'll definitely get it this time.");

        System.out.println("Press 1 to Reset | 2 to Quit");

        boolean continuePlaying = true;
        boolean playerDeciding = true;

        while (playerDeciding) {


            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    playerDeciding = false;

                } else if (choice == 2) {
                    playerDeciding = false;

                    continuePlaying = false;

                } else {
                    System.out.println("Enter 1 or 2");
                }

            } catch (Exception e) {
                System.out.println("Invalid entry, enter a 1 or 2");
            }
        }

        return continuePlaying;
    }

    /**
     * Runs either the scripted or non-scripted version based on user input in main.
     */
    public static void runDungeon() {

        if (dungeonIsScripted) {
            runScriptedDungeon();

        } else {
            runNormalDungeon();
        }
    }


    // Each floor has one fight and a chance to find some loot or a shop
    private static void runNormalDungeon() {

        // Create character
        spawnCharacter();

        // run tutorial and give starting weapon based on class
        runTutorial();

        // run dungeon cycles
        while (cycleCount <= 4 && player.isAlive()) {

            runDungeonCycle();
        }


        // after player dies, display a recap
        dungeonRecap();

    }


    private static void runTutorial() {
        DungeonUtil.printSpacer();
        // Porc the Orc Warrior uses sword strike to attack!
        System.out.println(player.getName() + " the " + player.getPlayerRace() + " "
                + player.getPlayerClass() + " uses " + player.getPlayerClass().getAttackText()
                + " to attack!");

        // determine starting weapon based on class
        Item startingWeapon = giveStartingWeapon();

        System.out.println("Upon entering the dungeon, you find a chest containing a "
                + startingWeapon.getItemName());
        System.out.println(startingWeapon.getItemDescription());

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


    /**
     * Asks the user if they want to take a long rest and execute if yes. Runs in either normal or
     * scripted mode.
     */
    private static void promptLongRest(boolean dungeonIsScripted) {
        System.out.println("Do you want to take a long rest?");
        System.out.println("1 - Yes | 2 - No");


        if (dungeonIsScripted) {

            System.out.println("You decide to take a long rest");
            player.takeLongRest();

        } else {

            boolean playerDeciding = true;
            int result;

            while (playerDeciding) {

                try {
                    result = scanner.nextInt();
                    scanner.nextLine();

                    if (result == 1) {
                        player.takeLongRest();
                        playerDeciding = false;

                    } else if (result == 2) {
                        // skip long rest
                        System.out.println("Long rest skipped");
                        playerDeciding = false;
                    }

                } catch (Exception e) {
                    System.out.println("Input invalid - Enter 1 or 2");
                }


            }
        }


    }

    /**
     * Runs the minor boss level. If player succeeds, awards bonus xp and a random helmet drop.
     *
     * @return boolean isPlayerAlive
     */
    private static boolean runMediumMonsterFloor(Adventurer player, int cycleCount) {

        // applies a stacking buff every 5 floors
        player.applyPower();

        // Set active monster to a random medium monster
        monster = MonsterFactory.randomMediumMonster();

        DungeonUtil.printSpecialWrapper();
        System.out.println("A " + monster.getName() + " appears!\n");
        DungeonUtil.printSpecialWrapper();

        // go to combat
        Combat dungeonCombat = new Combat(player, monster, cycleCount);

        // combat resolves into a boolean that's true if player is alive or false if they died.
        boolean playerIsAlive;
        playerIsAlive = dungeonCombat.combat(dungeonIsScripted);

        // Chance to find the shopkeeper or loot lying around
        int lootChance = DungeonUtil.rollAD20();
        if (playerIsAlive && (lootChance) > 15) {

            Shop.shopKeeperEncounter(dungeonIsScripted);

        } else if (playerIsAlive && (lootChance > 10)) {
            System.out.println("The " + monster.getName() + " leaves behind some loot!");
            PlayerInventory.randomLootDrop(EquipmentSlot.HELMET, dungeonIsScripted);
        }

        // If player is alive at the end of encounter, apply XP and give option to long rest.
        if (playerIsAlive) {
            player.gainMediumXp();
            PlayerInventory.findPotionOfHealing();
            lootTheRoom();
            promptLongRest(dungeonIsScripted);
        }

        return playerIsAlive;
    }


    /**
     * Helper method to run the small monster encounter every minor level.
     *
     * @return if player is still alive at the end of the encounter
     */
    private static boolean runSmallMonsterFloor(Adventurer player, int cycleCount) {



        // set active monster to a random small monster
        monster = MonsterFactory.randomSmallMonster();

        DungeonUtil.printSpecialWrapper();
        System.out.println("A " + monster.getName() + " appears!");
        DungeonUtil.printSpecialWrapper();

        // go to combat
        Combat dungeonCombat = new Combat(player, monster, cycleCount);

        // combat resolves into a boolean that's true if player is alive or false if they died.
        boolean playerIsAlive;
        playerIsAlive = dungeonCombat.combat(dungeonIsScripted);

        // As long as the player is still alive, they get a chance to find loot.
        int lootChance = DungeonUtil.rollAD20(); // roll a d20 for chance at finding loot
        if (playerIsAlive && lootChance > 12) {
            System.out.println("The " + monster.getName() + " leaves behind some loot!");
            lootTheRoom();
        } else if (lootChance > 10) {

            PlayerInventory.findPotionOfHealing();
        }

        // If player is alive at the end of encounter, apply XP.
        if (playerIsAlive) {
            player.gainSmallXp();
        }

        return playerIsAlive;
    }

    /**
     * Runs the medium monster floor.
     *
     * @return if player is still alive at the end of the encounter
     */
    private static boolean runBossMonsterFloor(Adventurer player, int cycleCount) {


        // applies a stacking buff every 5 floors
        player.applyPower();

        // Set active monster to a random medium monster
        monster = MonsterFactory.randomLargeMonster();

        DungeonUtil.printSpecialWrapper();
        System.out.println("A " + monster.getName() + " appears!\n");
        DungeonUtil.printSpecialWrapper();

        // go to combat
        Combat dungeonCombat = new Combat(player, monster, cycleCount);

        // combat resolves into a boolean that's true if player is alive or false if they died.
        boolean playerIsAlive;
        playerIsAlive = dungeonCombat.combat(dungeonIsScripted);

        // If player is alive at the end of encounter; apply XP, random loot, option to shop
        // give option to long rest, find new potion if empty.
        if (playerIsAlive) {
            player.gainBossExperience();
            PlayerInventory.findPotionOfHealing();
            PlayerInventory.randomLootDrop(EquipmentSlot.ARMOR, dungeonIsScripted);
            lootTheRoom();
            Shop.shopKeeperEncounter(dungeonIsScripted);
            promptLongRest(dungeonIsScripted);
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

        // traps to use for the cycle
        Trap teleportTrap = TeleportTrap.teleportTrapBuilder();
        Trap falseFloorTrap = FalseFloorTrap.falseFloorTrapBuilder();

        int level = 1;

        boolean playerIsAlive = true;

        // extra shot of buffs to start off the cycle
        player.applyPower();

        while (level <= 10 && playerIsAlive) {

            if (level == 3) {

                runTrap(teleportTrap);

            } else if (level == 5) {
                // run minor boss encounter
                playerIsAlive = runMediumMonsterFloor(player, cycleCount);


            } else if (level == 7) {

                runTrap(falseFloorTrap);

                // run major boss encounter
            } else if (level == 10) {
                playerIsAlive = runBossMonsterFloor(player, cycleCount);

                // otherwise run normal floor with small monster
            } else {
                playerIsAlive = runSmallMonsterFloor(player, cycleCount);

            }

            // if player is still alive after combat cycle, update stats and move on!
            if (playerIsAlive) {

                player.updateItemBonuses(); // update item bonuses
                player.checkLevelUp(); // check for level up
                levelRecap(); // display updates to player

                level++;
                dungeonLevel++;
            }

        }

        // If player is still alive after the 10th level,
        // increase cycle count (which modifies monster difficulty)
        if (playerIsAlive) {
            cycleCount++;
        }


    }

    private static void runTrap(Trap trap) {

        DungeonUtil.printSpacer();

        // prompt player there is something interesting ahead
        trap.displayDiscoveryText();

        // roll a skill check that corresponds to the trap's check

        // if player passes, they avoid the trap and get some xp
        int skillCheck = player.rollSkillCheck(trap.getSkillCheckType());

        if (trap.doesPlayerBeatArmorClass(skillCheck)) {

            trap.displaySuccessText();
            player.gainMediumXp();

            // if player fails: display failure, deal damage, and apply condition

        } else {
            trap.displayFailureText();
            player.takeDamage(trap.getDamage());
            player.applyCondition(trap.getEffectType());
        }


    }


    /**
     * Displays important info to player at the end of the level.
     */
    private static void levelRecap() {

        System.out.println("***********************************************************");

        System.out.println("*                    Level Recap                          *");

        System.out.printf("*   Dungeon Level: %d                                      *%n",
                dungeonLevel);

        System.out.printf("*   Dungeon Cycle: %d                                      *%n",
                cycleCount);

        System.out.printf("*   Player Level:  %d                                      *%n",
                player.getLevel());

        System.out.printf("*   Player HP:     %d/%d                                   *%n",
                player.getCurrentHp(), player.getMaxHp());

        System.out.printf("*   Player XP:     %d/%d                                   *%n",
                player.getCurrentXp(), player.nextLevelXp());

        System.out.printf("*   Player Gold:   %d                                      *%n",
                PlayerInventory.currentGoldBalance());

        System.out.println("***********************************************************");

    }

    private static void dungeonRecap() {
        System.out.println("**********************************************************");

        System.out.println("*                    Dungeon Recap                        *");

        System.out.printf("*   Dungeon Progress: Level %d                             *%n",
                dungeonLevel);

        System.out.printf("*   Dungeon Cycle:          %d                             *%n",
                cycleCount);

        System.out.printf("*   Player Level:           %d                             *%n",
                player.getLevel());

        System.out.printf("*   Player Gold:            %d                             *%n",
                PlayerInventory.currentGoldBalance());

        System.out.printf("*   Killed By:              %s                             *%n",
                monster.getName());

        System.out.println("**********************************************************");

    }

    private static void dungeonComplete() {

        System.out.println("*********************************");
        System.out.println("           D U N G E O N         ");
        System.out.println("          C O M P L E T E        ");
        System.out.println("*********************************");
    }


    /**
     * Handles random gold drops and adding to inventory at the end of a room. Adds luck score to
     * amount of gold found.
     */
    private static void lootTheRoom() {
        int goldFound = DungeonUtil.rollAD20() + player.getLuck();
        PlayerInventory.pickUpGold(goldFound);
    }


}





















