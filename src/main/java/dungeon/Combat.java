package dungeon;

import character.Adventurer;
import character.PlayerInventory;

import java.util.Arrays;
import java.util.List;

import monsters.Monster;

import utility.DungeonUtil;
import utility.index.EquipmentSlot;
import utility.index.Item;


/**
 * This class handles combat encounters between two game entities.
 */
public class Combat {

    private final Adventurer player;
    private final Monster monster;
    private final int difficultyMod;
    private final int cycleCount;

    /**
     * Combat constructor for encounters. Sets if encounters are ran simulated or with user input.
     */
    public Combat(Adventurer player, Monster monster, int cycleCount) {
        this.player = player;
        this.monster = monster;

        // as cycle count increases, monster damage reduction decreases
        this.difficultyMod = 5 - cycleCount;
        this.cycleCount = cycleCount;
    }


    /**
     * Executes the combat sequence.
     *
     * @return if player is alive or dead after combat
     */
    public boolean combat(boolean dungeonIsScripted) {

        System.out.println("==================================");
        System.out.println("============= COMBAT! ============");
        System.out.println("==================================");

        boolean playerFirst = playerGoesFirst(); // keep out of loop to avoid regenerating init
        // scores

        monster.applyMonsterBuff(cycleCount);

        // while both the player AND the monster are alive, continue combat.
        while (player.isAlive() && monster.isAlive()) {

            // determine initiative by rolling a d20 for each entity and
            // adding speed score as a bonus

            if (playerFirst) {
                System.out.println(player.getName() + "'s turn");
                System.out.println("-------------------------------");

                // player goes first
                takePlayerTurn(dungeonIsScripted);
                System.out.println("-------------------------------");

                // end cycle if monster dies in middle of round
                if (!monster.isAlive()) {
                    break;
                }

                // then monster goes
                System.out.println(monster.getName() + "'s turn");
                System.out.println("-------------------------------");
                attackPlayer(difficultyMod);

                // end cycle if player dies
                if (!player.isAlive()) {
                    break;
                }

            } else {

                // or monster goes first
                System.out.println(monster.getName() + "'s turn");
                System.out.println("-------------------------------");
                attackPlayer(difficultyMod);
                System.out.println("-------------------------------");

                // end cycle if player dies in middle of round
                if (!player.isAlive()) {
                    break;
                }

                // then player goes
                System.out.println(player.getName() + "'s turn");
                System.out.println("-------------------------------");
                takePlayerTurn(dungeonIsScripted);

                // end cycle if monster dies in middle of round
                if (!monster.isAlive()) {
                    break;
                }
            }

        }

        // Combat ends when either the player or monster is no longer alive.
        // Return true if player is alive,
        // otherwise return false so that the main loop can end.

        return player.isAlive();

    }

    /**
     * Runs the player turn in either scripted or normal mode.
     */
    private void takePlayerTurn(boolean dungeonIsScripted) {
        // check if they're alive
        //todo: implement check for condition status like restrained,paralyzed, etc

        if (player.isAlive()) {
            // run player action based on game mode
            takePlayerAction(dungeonIsScripted);
        }

    }


    /**
     * On each turn, a player can choose an action.
     */
    private void takePlayerAction(boolean dungeonIsScripted) {

        // display options to the player for their action
        displayActionOptions();

        int playerChoice;
        // if in scripted mode, use programmed logic to decide player choice
        if (dungeonIsScripted) {
            playerChoice = decideScriptedPlayerAction();
            // otherwise get selection from the user
        } else {
            playerChoice = DungeonUtil.getUserSelection(3);

        }

        if (playerChoice == 1) {
            // basic attack
            basicAttack();


        } else if (playerChoice == 2) {
            // special ability
            useSpecialAbility();


        } else if (playerChoice == 3) {
            // try to drink a potion.
            // if it doesn't work, basic attack instead.

            if (!player.drinkPotion()) {
                basicAttack();
            }

        }

    }

    /**
     * Scripted character will try to use their special ability on bosses, use healing potion if
     * less than half hp, and otherwise basic attack.
     */
    private int decideScriptedPlayerAction() {
        List<String> bosses = Arrays.asList("Ogre", "Displacer Beast", "Giant Spider",
                "Young Red Dragon", "Beholder", "Giant");

        // use special if fighting boss
        if (bosses.contains(monster.getName()) && player.getUltimateCharges() > 0) {
            return 2;

            // use potion if hp is less than half if they have a potion to use
        } else if ((player.getCurrentHp() < (player.getMaxHp() / 2))
                && PlayerInventory.getEquippedItem(EquipmentSlot.POTION) != Item.NO_POTION) {

            return 3;

        } else {

            return 1;
        }


    }


    /**
     * Displays the options for a player's action to include their ability text.
     */
    private void displayActionOptions() {

        System.out.println("What would you like to do?");
        System.out.println("Action Options:");
        System.out.println("1. Basic Attack: "
                + player.getPlayerClass().getAttackText());
        System.out.println("2. Special Ability: "
                + player.getPlayerClass().getSpecialAbilityText());
        System.out.println("3. Drink a Potion");


    }

    /**
     * If player chooses basic attack.
     */
    private void basicAttack() {

        // if attack roll beats monster ac, apply damage
        int attackRoll = player.basicAttackRoll();

        if (attackRoll >= 20) {
            System.out.println("Critical strike!");

            monster.takeDamage(player.basicAttackCriticalStrike());

        } else if (player.basicAttackRoll() >= monster.getArmorClass()) {

            monster.takeDamage(player.basicAttackDamage());

        } else {
            System.out.println("Your attack misses the " + monster.getName() + "!");
        }

    }

    /**
     * Logic for using special ability. If player is out of ultimate charges, it does a basic attack
     * instead
     */
    private void useSpecialAbility() {

        int specialAtkDmg = player.useSpecialAttack();


        if (specialAtkDmg > 0) {
            monster.takeDamage(specialAtkDmg);

        } else {
            basicAttack();
        }

    }

    /**
     * Attack logic for the monster.
     */
    private void attackPlayer(int difficultyMod) {

        int attackRoll = DungeonUtil.rollAD20() + monster.getAttackBonus();

        // if attack roll beats player ac, player takes damage
        if (attackRoll >= player.getArmorClass()) {

            monster.attackText();
            // difficulty scales the damage down (amount decreases as cycle count increases)
            // makes sure result doesn't go below 1
            int calcDamage = Math.max(1, (DungeonUtil.rollAD10()
                    + monster.getAttackBonus()) - difficultyMod);

            player.takeDamage(calcDamage);

        } else {
            System.out.println("The " + monster.getName() + "'s attack misses!");
        }


    }


    /**
     * Determines if the player or monster won the initiative roll.
     */
    private boolean playerGoesFirst() {

        boolean playerFirst;
        int playerInit = DungeonUtil.rollAD20() + player.getSpeed();
        int monsterInit = DungeonUtil.rollAD20() + monster.getSpeed();

        System.out.println("Initiative rolls!");
        System.out.println(player.getName() + ": " + playerInit);
        System.out.println(monster.getName() + ": " + monsterInit);

        if (playerInit > monsterInit) {
            System.out.println(player.getName() + " goes first!");
            playerFirst = true;

        } else {
            System.out.println(monster.getName() + " goes first!");
            playerFirst = false;
        }

        System.out.println("===============================");

        return playerFirst;
    }


}