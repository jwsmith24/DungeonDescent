package dungeon;

import character.Adventurer;
import character.PlayerInventory;
import monsters.Monster;
import monsters.MonsterFactory;
import utility.CharacterBuilder;
import utility.Dice;
import utility.index.EquipmentSlot;
import utility.index.Item;
import utility.index.PlayerClass;

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
     * Uses the Character Builder class to allow the user to build their chracter.
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
    // make UI prettier
    // adding some more flavor text
    // xp gain from killing monsters and spending it on ability score increases.


    private static void runDungeonCycle() {

        int level = 1;
        Combat dungeonCombat;
        boolean playerIsAlive = true;

        // extra shot of buffs to start off the cycle
        player.applyPower();

        while (level <= 10 && playerIsAlive) {

            // roll a d20 each floor for chance at finding loot
            int lootChance = Dice.rollAD20();

            // At level 5, fight a medium monster
            Monster monster;

            if (level == 5) {

                // applies a stacking buff every 5 floors
                player.applyPower();

                // Set active monster to a random medium monster
                monster = MonsterFactory.randomMediumMonster();
                System.out.println("A " + monster.getName() + " appears!\n");

                // go to combat
                dungeonCombat = new Combat(player, monster, cycleCount);

                // combat resolves into a boolean that's true if player is alive or false if they died.
                playerIsAlive = dungeonCombat.combat();

                // Chance to find the shopkeeper or loot lying around
                if (playerIsAlive && (lootChance) > 15) {

                    Shop.shopKeeperEncounter(scanner);

                } else if (playerIsAlive && (lootChance > 10)) {
                    System.out.println("The monster leaves behind some loot!");

                }

                System.out.println("Want to take a long rest? You have X/3 remaining");

            } else {

                // set active monster to a random small monster
                monster = MonsterFactory.randomSmallMonster();
                System.out.println("A " + monster.getName() + " appears!");

                // go to combat
                dungeonCombat = new Combat(player, monster, cycleCount);
                // combat resolves into a boolean that's true if player is alive or false if they died.
                playerIsAlive = dungeonCombat.combat();

                // As long as the player is still alive, they get a chance to find loot.
                if (playerIsAlive && lootChance > 12) {
                    System.out.println("The monsters leaves behind some loot!");
                }


            }
            level++;
            dungeonLevel++;
        }

        // after the 10th level, increase cycle count (which modifies monster difficulty)
        cycleCount++;

    }

    private static void runMagicDungeonCycle() {

    }

}





















