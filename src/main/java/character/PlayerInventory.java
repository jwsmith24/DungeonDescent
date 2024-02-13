package character;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import utility.index.EquipmentSlot;
import utility.index.Item;

/**
 * Functionality for player inventory management.
 *
 * <p>There is no backpack feature yet so if an item is not equipped to the character,
 * it is assumed to be dropped.</p>
 *
 * <P>Designed to be a static entity since there is only ever one player.</P>
 */
public class PlayerInventory {

    static HashMap<EquipmentSlot, Item> inventory = new HashMap<>();

    static int gold;

    public static boolean haveEnoughGold(int value) {
        return (gold >= value);
    }

    public static int acquireGold() {

        return gold;
    }

    public static void spendGold(int value) {
        gold = (gold - value);
    }
    private PlayerInventory() {

    }
    /**
     * Equips item to an inventory slot.
     */
    public static void equipItem(EquipmentSlot slot, Item item) {

        inventory.put(slot, item);


        //todo: logic to prompt player to choose to replace or not

    }

    /**
     * Sets inventory to starting inventory.
     */
    public static void initializeInventory() {
        inventory.put(EquipmentSlot.HELMET, Item.NO_HELMET);
        inventory.put(EquipmentSlot.ARMOR, Item.NO_ARMOR);
        inventory.put(EquipmentSlot.WEAPON, Item.NO_WEAPON);
        inventory.put(EquipmentSlot.OFF_HAND,Item.NO_OFF_HAND);
        inventory.put(EquipmentSlot.POTION, Item.NO_POTION);
    }

    public static void displayInventory() {

        System.out.println("==================================");
        System.out.println("========= YOUR INVENTORY =========");
        System.out.println("==================================");

        if (inventory != null) {
            for (Map.Entry<EquipmentSlot, Item> entry : inventory.entrySet()) {
                System.out.println(entry.getKey().getSlotDescription() + entry.getValue().getItemName());
            }
        }


    }

    /**
     * Removes an item from an inventory slot.
     */
    public static void removeItem(EquipmentSlot slot) {

        // instead of simply removing the item from the list,
        // we want to replace it with the associated empty item constant
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        Item equippedItem = getEquippedItem(slot);

        if (inventory != null) {

            // Only starting equipment has a value of 0
            if (equippedItem.getItemValue() == 0) {
                // No item equipped in this slot, inform player and move on
                System.out.println(equippedItem.getItemName());

            } else {
                System.out.println("You already have equipment in this slot: \n");
                System.out.println("EQUIPPED: " + slot.getSlotDescription() + equippedItem.getItemName());

                System.out.println("Would you like to replace it?");
                System.out.println("Enter 1 - Yes or 2 - No");

                while(true){
                    try {
                        int input = scanner.nextInt();

                        if (input == 1) {
                            //replace it
                            break;

                        } else if (input == 2){
                            // Do nothing and move on
                            break;

                        }
                    }catch (IllegalArgumentException e) {
                        System.out.println("Enter a valid option");
                    }
                }
            }


        }

        scanner.close();

    }

    /**
     * Determine if slot is already equipped or open.
     * // todo: rework this to make sense
     */
    public static boolean isSlotEquipped(EquipmentSlot slot) {

        return inventory.containsKey(slot);
    }

    /**
     * Shows which item player has equipped in a given inventory slot.
     */
    public static Item getEquippedItem(EquipmentSlot slot) {

        return inventory.get(slot);
    }


}
