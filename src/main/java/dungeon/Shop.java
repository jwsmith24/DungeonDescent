package dungeon;

import java.util.Scanner;

/**
 * Contains all shop-related functionality.
 */
public class Shop {

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
                    System.out.println("Go shopping!");
                    goShopping();
                    playerDeciding = false;

                } else {
                    System.out.println("Enter a valid response");
                }

            } catch (Exception e) {
                System.out.println("Enter a valid response");
                scanner.nextLine();
            }

        }

        ShopKeeperItems sword = ShopKeeperItems.SWORD_OF_SLASHING;
        String test = sword.itemDescription;
        String test2 = sword.itemName;
    }

    private static void goShopping() {

        System.out.println("==================================");
        System.out.println("========= SHOP INVENTORY =========");
        System.out.println("==================================");


        for (ShopKeeperItems item : ShopKeeperItems.values()) {
            System.out.println(item.itemName + " | " + item.itemDescription + " | " + item.cost + " gold");
        }

    }

    private Shop() {
        // no objects here
    }


    private enum ShopKeeperItems {
        SWORD_OF_SLASHING("Sword of Slashing", "+1 to ATK!", 30);


        private final String itemName;
        private final String itemDescription;

        private final int cost;

        ShopKeeperItems(String itemName,String itemDescription, int cost) {
            this.itemName = itemName;
            this.itemDescription = itemDescription;
            this.cost = cost;
        }




    }


}
