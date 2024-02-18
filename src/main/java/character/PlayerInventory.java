package character;

import utility.DungeonUtil;
import utility.index.EquipmentSlot;
import utility.index.Item;

import java.nio.charset.StandardCharsets;
import java.util.*;

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

    static int gold = 0;

    static int itemAttackBonus = 0;
    static int itemArmorBonus = 0;

    // always start with the inventory initialized
    static {
        initializeInventory();
    }

    public static boolean haveEnoughGold(int value) {
        return (gold >= value);
    }

    public static void pickUpGold(int amount) {
        gold += amount;
        System.out.println("You've picked up " + amount + " gold!");
    }

    public static int currentGoldBalance() {
        return gold;
    }

    public static void spendGold(int value) {
        gold = (gold - value);
    }


    /**
     * Used to determine if player's potion slot is filled.
     */
    private static boolean potionIsFilled() {
        // if player has a potion, return true
        return getEquippedItem(EquipmentSlot.POTION).getItemValue() != 0;

    }

    /**
     * Used at certain levels to refill player's potion if empty.
     */
    public static void findPotionOfHealing() {
        if (!potionIsFilled()) {
            System.out.println("You find a potion of healing!");
            equipItem(EquipmentSlot.POTION, Item.POTION_OF_HEALING, false);
        }
    }

    /**
     * Specific method to remove potion from inventory that bypasses the removeItem method.
     */
    public static boolean consumePotion() {
        if (potionIsFilled()) {
            inventory.put(EquipmentSlot.POTION, Item.NO_POTION);
            return true;
        }
        return false;
    }

    private PlayerInventory() {

    }

    /**
     * Calculates total attack and armor bonuses based on currently equipped items.
     */
    private static void calculateItemBonuses() {
        itemAttackBonus = 0;
        itemArmorBonus = 0;

        if (inventory != null) {

            for (Map.Entry<EquipmentSlot, Item> entry : inventory.entrySet()) {

                // if item in inventory is a weapon, increase attack bonus
                // otherwise, increase armor bonus

                if (entry.getKey().equals(EquipmentSlot.WEAPON)) {
                    itemAttackBonus = itemAttackBonus + entry.getValue().getBonus();

                } else {

                    if (!entry.getKey().equals(EquipmentSlot.POTION)) {
                        itemArmorBonus = itemArmorBonus + entry.getValue().getBonus();
                    }
                }
            }
        }
    }

    public static int getItemAttackBonus() {
        calculateItemBonuses();
        return itemAttackBonus;
    }

    public static int getItemArmorBonus() {
        calculateItemBonuses();
        return itemArmorBonus;
    }

    /**
     * Equips item to an inventory slot. If item slot is empty, equips item.
     */
    public static void equipItem(EquipmentSlot slot, Item item, boolean ignoreAlreadyEquipped) {

        if (ignoreAlreadyEquipped) {

            // override the normal game logic for the script
            Item alreadyEquipped = getEquippedItem(slot);

            if (alreadyEquipped.getItemValue() != 0) {
                System.out.println("You have unequipped " + alreadyEquipped.getItemName()
                        + " from the " + slot + " slot.");
            }


            inventory.put(slot, item); // overwrite existing item
            System.out.println("You have equipped " + getEquippedItem(slot).getItemName()
                    + " in the " + slot + " slot.");

        } else {
            // If slot is open, equip new item

            if (isSlotEmpty(slot)) {
                inventory.put(slot, item);
                System.out.println("You have equipped " + getEquippedItem(slot).getItemName()
                        + " in the " + slot + " slot.");

            } else {
                // Prompts user to replace item if applicable
                removeItem(slot, false);

                // If the slot is open now, we equip the new item, otherwise we do nothing.
                if (isSlotEmpty(slot)) {

                    inventory.put(slot, item);

                    System.out.println("You have equipped " + getEquippedItem(slot).getItemName()
                            + " in the " + slot + " slot.");
                }


            }
        }

        // recalculate item bonuses after change
        calculateItemBonuses();
    }

    /**
     * Drops a random item that fits the given equipment slot.
     */
    public static void randomLootDrop(EquipmentSlot slot) {
        ArrayList<Item> randomLootTable = new ArrayList<>();

        // pull all items of a given slot into an array list
        for (Item item : Item.values()) {

            // avoid the "NO_X" starting "items"
            if (item.getItemType() == slot && item.getItemValue() != 0) {
                randomLootTable.add(item);
            }
        }

        // roll on the loot table based on size
        int rollOnLootTable = DungeonUtil.rollRandomItem(randomLootTable.size());

        // get the item at that random index
        Item randomDrop = randomLootTable.get(rollOnLootTable);

        // equip the item
        equipItem(randomDrop.getItemType(), randomDrop, false);

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
    public static void removeItem(EquipmentSlot slot, boolean ignoreAlreadyEquipped) {

        // instead of simply removing the item from the list,
        // we want to replace it with the associated empty item constant
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        Item equippedItem = getEquippedItem(slot);

        if (inventory != null && !ignoreAlreadyEquipped) {

            // Only starting equipment has a value of 0
            if (equippedItem.getItemValue() == 0) {

                // No item equipped in this slot, inform player and move on.
                System.out.println(equippedItem.getItemName());

            } else {

                // Prompt player to choose if they want to remove item to equip new item

                System.out.println("You already have " + getEquippedItem(slot).getItemName()
                        + " equipped in the " + slot + " slot.");

                System.out.println("Would you like to replace it?");
                System.out.println("1 - Yes | 2 - No");

                while (true) {

                    try {
                        int result = scanner.nextInt();
                        scanner.nextLine();

                        if (result == 1) {

                            removeSlot(slot);
                            System.out.println("You have unequipped " + equippedItem.getItemName()
                                    + " from the " + slot + " slot.");
                            break;

                        } else if (result == 2) {
                            break;
                        }

                        System.out.println("1 - Yes | 2 - No");


                    } catch (Exception e) {
                        System.out.println("Enter a valid option");
                    }
                }
            }

        } else {
           // if we want to bypass user input for testing
            removeSlot(slot);

        }

    }


    private static void removeSlot(EquipmentSlot slot) {

        switch (slot) {

            case ARMOR: inventory.put(EquipmentSlot.ARMOR, Item.NO_ARMOR);
            case HELMET: inventory.put(EquipmentSlot.HELMET, Item.NO_HELMET);
            case WEAPON: inventory.put(EquipmentSlot.WEAPON, Item.NO_WEAPON);
            case OFF_HAND: inventory.put(EquipmentSlot.OFF_HAND, Item.NO_OFF_HAND);
            case POTION: inventory.put(EquipmentSlot.POTION, Item.NO_POTION);

            default: System.out.println("Not a valid slot");


        }
    }

    /**
     * Sets inventory to starting inventory.
     */
    public static void initializeInventory() {
        inventory.put(EquipmentSlot.HELMET, Item.NO_HELMET);
        inventory.put(EquipmentSlot.ARMOR, Item.NO_ARMOR);
        inventory.put(EquipmentSlot.WEAPON, Item.NO_WEAPON);
        inventory.put(EquipmentSlot.OFF_HAND, Item.NO_OFF_HAND);
        inventory.put(EquipmentSlot.POTION, Item.NO_POTION);
    }

    /**
     * Determine if slot is already equipped or open.
     */
    public static boolean isSlotEmpty(EquipmentSlot slot) {

        // "No armor equipped" items have value of zero
        return (inventory.get(slot).getItemValue() == 0);


    }

    /**
     * Shows which item player has equipped in a given inventory slot.
     */
    public static Item getEquippedItem(EquipmentSlot slot) {

        return inventory.get(slot);
    }


}
