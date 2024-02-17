package dungeon;


import character.Adventurer;

import monsters.Monster;

import utility.DungeonUtil;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


/**
 * This class handles combat encounters between two game entities.
 */
public class Combat {

    private final Adventurer player;
    private final Monster monster;
    private final Scanner playerInput = new Scanner(System.in, StandardCharsets.UTF_8);
    private final int difficultyMod;

    public Combat(Adventurer player, Monster monster, int cycleCount) {
        this.player = player;
        this.monster = monster;
        // as cycle count increases, monster damage reduction decreases
        this.difficultyMod = 5 - cycleCount;
    }


    /**
     * Executes the combat sequence.
     *
     * @return if player is alive or dead after combat
     */
    public boolean combat() {

        System.out.println("==================================");
        System.out.println("============= COMBAT! ============");
        System.out.println("==================================");

        boolean playerFirst = playerGoesFirst(); // keep out of loop to avoid regenerating init
        // scores

        // while both the player AND the monster are alive, continue combat.
        while (player.isAlive() && monster.isAlive()) {


            // determine initiative by rolling a d20 for each entity and adding speed score as a bonus

            if (playerFirst) {
                System.out.println(player.getName() + "'s turn");
                System.out.println("-------------------------------");

                // player goes first
                takePlayerTurn();
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
                takePlayerTurn();

                // end cycle if monster dies in middle of round
                if (!monster.isAlive()) {
                    break;
                }
            }

        }

        // Combat ends when either the player or monster is no longer alive. Return true if player is alive,
        // otherwise return false so that the main loop can end.

        return player.isAlive();

    }


    private void takePlayerTurn() {
        // check if they're alive
        //todo: implement check for condition status like restrained,paralyzed, etc
        if (player.isAlive()) {
            takePlayerAction();
            //takePlayerBonusAction();
        }
    }


    /**
     * On each turn, a player can choose an action
     */
    private void takePlayerAction() {

        // display options to the player for their action
        displayActionOptions();


        boolean playerDeciding = true;

        while (playerDeciding) {

            System.out.println("Enter the number corresponding to your choice:");


            try {

                if (playerInput.hasNextLine()) {
                    int playerChoice = playerInput.nextInt();
                    playerInput.nextLine();

                    if (playerChoice == 1) {
                        // basic attack
                        basicAttack();
                        playerDeciding = false;


                    } else if (playerChoice == 2) {
                        // special ability
                        useSpecialAbility();
                        playerDeciding = false;


                    } else if (playerChoice == 3) {
                        // drink a potion
                        player.drinkPotion();

                        playerDeciding = false;

                    } else {
                        System.out.println("Enter a valid selection.");

                    }

                }

            } catch (Exception e) {
                System.out.println("Enter a valid selection");
                playerInput.nextLine();

            }
        }

    }


    /**
     * Displays the options for a player's action to include their ability text.
     */
    private void displayActionOptions() {

        System.out.println("What would you like to do?");
        System.out.println("Action Options:");
        System.out.println("1. Basic Attack: " + player.getPlayerClass().getAttackText());
        System.out.println("2. Special Ability: " + player.getPlayerClass().getSpecialAbilityText());
        System.out.println("3. Drink a Potion");


    }

    /**
     * If player chooses basic attack.
     */
    private void basicAttack() {

        // roll a d20 and add player attack bonus + level
        int attackRoll = DungeonUtil.rollAD20() + player.getAttack() + player.getLevel();

        System.out.println("\nYou attack with: " + player.getPlayerClass().getAttackText());

        // Attack roll = d20 + attack bonus, damage roll = d10 + attack bonus
        if (attackRoll >= monster.getArmorClass()) {

            int result = DungeonUtil.rollAD10() + player.getAttack() + player.getLevel();

            System.out.println("You hit the " + monster.getName() + " for " + result + " damage!");

            monster.takeDamage(result);

        } else {
            System.out.println("Your attack misses the " + monster.getName() + "!");
        }

    }

    /**
     * Logic for using special ability
     */
    private void useSpecialAbility() {

        // character needs to have enough ultimate charges
        if (player.spendUltimateCharge()) {

            DungeonUtil.printSpecialWrapper();
            System.out.println("You use: " + player.getPlayerClass().getSpecialAbilityText());
            DungeonUtil.printSpecialWrapper();

            // special deals double damage and is guaranteed to hit
            int result = 2 * (DungeonUtil.rollAD10() + player.getAttack());
            monster.takeDamage(result);

            System.out.println("You hit the " + monster.getName() + " for " + result + " damage!");
        }


    }


    /**
     * Attack logic for the monster.
     */
    private void attackPlayer(int difficultyMod) {

        int attackRoll = DungeonUtil.rollAD20() + monster.getAttackBonus();

        // if attack roll beats player ac, player takes damage
        if (attackRoll >= player.getAC()) {

            monster.attackText();
            // difficulty scales the damage down (amount decreases as cycle count increases)
            // makes sure result doesn't go below 1
            int calcDamage = Math.max(1, (DungeonUtil.rollAD10() + monster.getAttackBonus()) - difficultyMod);
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
