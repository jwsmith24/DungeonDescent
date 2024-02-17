package dungeon;

import character.PlayerInventory;
import utility.index.Item;

import java.util.Scanner;

/**
 * Contains all shop-related functionality.
 */
public class Shop {

    private static final int SHOP_PRICE = 41;

    /**
     * Contains the logic for a shopkeeper encounter.
     */
    public static void shopKeeperEncounter(Scanner scanner) {

        int result;
        boolean playerDeciding = true;

        while (playerDeciding){
            System.out.println("The Shopkeeper appears!");
            System.out.println("Do you want to approach?");
            System.out.println("1 - Yes | 2 - No");

            try {
                result = scanner.nextInt();

                if(result == 1) {
                    System.out.println("The shopkeeper beckons you closer. 'Only one item', they say in a broken voice");
                    goShopping(scanner);
                    playerDeciding = false;

                    //todo implement what happens if player says no

                } else {
                    System.out.println("Enter a valid response");
                }

            } catch (Exception e) {
                System.out.println("Enter a valid response");
                scanner.nextLine();
            }

        }
    }

    public static void goShopping(Scanner scanner) {

        System.out.println("==================================");
        System.out.println("========= SHOP INVENTORY =========");
        System.out.println("==================================");

       int index = 1;
        // Iterate through the list of items and display the shop inventory.
        for (Item item : Item.values()) {

            if(item.getItemValue() == SHOP_PRICE) {

                System.out.println(index + ": " + item.getItemName() + " | "
                        + item.getItemDescription() + " | " + item.getItemValue() + " gold");
                index++;
            }

        }
        System.out.println("*");
        System.out.println("*");
        System.out.println("*");

        System.out.println("Enter the index of the item you wish to purchase || Enter 5 to leave.");

        boolean playerDeciding = true;
        int result;

        while(playerDeciding) {

            try {
                result = scanner.nextInt();
                scanner.nextLine();

                if (result == 1) {
                    transaction(Item.SWORD_OF_SLASHING);
                    playerDeciding = false;

                } else if (result == 2) {
                    transaction(Item.HELMET_OF_PROTECTION);
                    playerDeciding = false;

                } else if (result == 3) {
                    transaction(Item.POTION_OF_HEALING);
                    playerDeciding = false;

                } else if (result == 4) {
                    transaction(Item.HAT_OF_STYLE);
                    playerDeciding = false;

                }else if (result == 5) {
                    System.out.println("You begin to leave and realize the shopkeeper is nowhere to be found.");
                    playerDeciding = false;

                }else {
                    System.out.println("Enter a valid number for your item selection. Or press 5 to leave.");
                }
            } catch (Exception e) {
                System.out.println("Enter a valid selection or press 5 to leave.");
                scanner.nextLine();
            }
        }

    }


    private static void transaction(Item item) {

        // Check that player has enough gold
        if (!PlayerInventory.haveEnoughGold(item.getItemValue())) {

            System.out.println("You don't have enough gold!'");
            System.out.println("Current funds: " + PlayerInventory.currentGoldBalance());

            System.out.println("The shopkeeper seemed displeased as you were rummaging through your coins. "
                    + "When you look up, they're nowhere to be seen.");

        } else {

            // subtract funds
            PlayerInventory.spendGold(item.getItemValue());

            // equip new item
            PlayerInventory.equipItem(item.getItemType(), item, false);

            System.out.println("You look up from inspecting your new item and the shopkeeper has vanished without a trace...");

        }


    }

    private Shop() {
        // no objects here
    }





}
