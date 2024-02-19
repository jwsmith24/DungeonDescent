package dungeon;

import static utility.DungeonUtil.getUserInput;

import character.PlayerInventory;
import utility.index.Item;


/**
 * Contains all shop-related functionality.
 */
public class Shop {

    private static final int SHOP_PRICE = 41;

    /**
     * Contains the logic for a shopkeeper encounter. Runs either in normal or scripted mode.
     */
    public static void shopKeeperEncounter(boolean dungeonIsScripted) {

        int selection;
        System.out.println("The Shopkeeper appears!");
        System.out.println("Do you want to approach?");
        System.out.println("1 - Yes | 2 - No");

        if (dungeonIsScripted) {
            runNormalShopkeeperEncounter(1, true);

        } else {
            selection = getUserInput(2);

            runNormalShopkeeperEncounter(selection, false);
        }

    }

    private static void runNormalShopkeeperEncounter(int selection, boolean dungeonIsScripted) {

        if (selection == 1) {

            System.out.println("The shopkeeper beckons you closer. "
                    + "'Only one item', they say in a broken voice");

            displayShopInventory();

            System.out.println("Enter the index of the item you wish to purchase "
                    + "|| Enter 5 to leave.");

            int shopChoice;

            // choose the hat of style if running in scripted mode
            if (dungeonIsScripted) {
                shopChoice = 4;

            } else {
                // get selection from user
                shopChoice = getUserInput(5);
            }

            // process the transaction
            goShopping(shopChoice, dungeonIsScripted);


        } else if (selection == 2) {
            System.out.println("The shopkeeper stares at your with cold eyes.");
            System.out.println("Fine then.");

        }


    }


    private static void displayShopInventory() {
        System.out.println("Current Gold: " + PlayerInventory.currentGoldBalance());

        System.out.println("==================================");
        System.out.println("========= SHOP INVENTORY =========");
        System.out.println("==================================");

        int index = 1;
        // Iterate through the list of items and display the shop inventory.
        for (Item item : Item.values()) {

            if (item.getItemValue() == SHOP_PRICE) {

                System.out.println(index + ": " + item.getItemName() + " | "
                        + item.getItemDescription() + " | " + item.getItemValue() + " gold");
                index++;
            }

        }
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");
    }

    /**
     * Handles shopping in either scripted or non-scripted mode.
     */
    public static void goShopping(int selection, boolean dungeonIsScripted) {


        if (selection == 1) {
            transaction(Item.SWORD_OF_SLASHING, dungeonIsScripted);


        } else if (selection == 2) {
            transaction(Item.HELMET_OF_PROTECTION, dungeonIsScripted);


        } else if (selection == 3) {
            transaction(Item.POTION_OF_HEALING, dungeonIsScripted);


        } else if (selection == 4) {
            transaction(Item.HAT_OF_STYLE, dungeonIsScripted);


        } else if (selection == 5) {
            System.out.println("You begin to leave and realize the shopkeeper "
                    + "is nowhere to be found.");

        }

    }

    /**
     * Processes an item transaction if the player has enough gold. Compatible with
     * scripted and non-scripted mode.
     */
    private static void transaction(Item item, boolean dungeonIsScripted) {

        // Check that player has enough gold
        if (!PlayerInventory.haveEnoughGold(item.getItemValue())) {

            System.out.println("You don't have enough gold!'");
            System.out.println("Current funds: " + PlayerInventory.currentGoldBalance());

            System.out.println("The shopkeeper seemed displeased as "
                    + "you were rummaging through your coins. "
                    + "When you look up, they're nowhere to be seen.");

        } else {

            // subtract funds
            PlayerInventory.spendGold(item.getItemValue());

            // equip new item
            PlayerInventory.equipItem(item.getItemType(), item, dungeonIsScripted);

            System.out.println("You look up from inspecting your new item and the shopkeeper"
                    + " has vanished without a trace...");

        }


    }

    private Shop() {
        // no objects here
    }


}
