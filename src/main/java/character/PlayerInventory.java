package character;

import java.util.HashMap;
import java.util.Map;

import utility.index.EquipmentSlot;
import utility.index.Item;

/**
 * Functionality for player inventory management.
 *
 * <p>There is no backpack feature yet so if an item is not equipped to the character,
 * it is assumed to be dropped.</p>
 */
public class PlayerInventory {

    Map<EquipmentSlot, Item> inventory;


    /**
     * Equips item to an inventory slot.
     */
    public void equipItem(EquipmentSlot slot, Item item) {
        if (!isSlotEquipped(slot)){
            inventory.put(slot, item);
        }

        //todo: logic to prompt player to choose to replace or not

    }

    /**
     * Sets inventory to starting inventory.
     */
    private void initializeInventory() {
        inventory.put(EquipmentSlot.HELMET, Item.NO_HELMET);
        inventory.put(EquipmentSlot.ARMOR, Item.NO_ARMOR);
        inventory.put(EquipmentSlot.WEAPON, Item.NO_WEAPON);
        inventory.put(EquipmentSlot.OFF_HAND,Item.NO_OFF_HAND);
        inventory.put(EquipmentSlot.POTION, Item.POTION_OF_HEALING);
    }

    public void displayInventory() {

        System.out.println("==================================");
        System.out.println("\t\t\tInventory");
        System.out.println("==================================");

        try {
            for (Map.Entry<EquipmentSlot, Item> entry : inventory.entrySet()) {
                System.out.println(entry.getKey().getSlotDescription() + entry.getValue().getItemName());
            }

        } catch (NullPointerException e) {
            System.out.println("No inventory was found");
        }


    }

    /**
     * Removes an item from an inventory slot.
     */
    public void removeItem(EquipmentSlot slot, Item item) {
        inventory.remove(slot);
    }

    /**
     * Determine if slot is already equipped or open.
     */
    public boolean isSlotEquipped(EquipmentSlot slot) {

        return inventory.containsKey(slot);
    }

    /**
     * Shows which item player has equipped in a given inventory slot.
     */
    public Item getEquippedItem(EquipmentSlot slot) {

        return inventory.get(slot);
    }

    /**
     * Constructs inventory with starting items.
     */
    public PlayerInventory() {
        this.inventory = new HashMap<>();
        this.initializeInventory();
    }
}
