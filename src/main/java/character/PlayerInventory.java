package character;

import java.util.HashMap;
import java.util.Map;

import utility.index.EquipmentSlot;

/**
 * Functionality for player inventory management.
 *
 * <p>There is no backpack feature yet so if an item is not equipped to the character,
 * it is assumed to be dropped.</p>
 */
public class PlayerInventory {

    Map<EquipmentSlot, Equipment> inventory;


    /**
     * Equips item to an inventory slot.
     */
    public void equipItem(EquipmentSlot slot, Equipment item) {
        if (!isSlotEquipped(slot)){
            inventory.put(slot, item);
        }

        //todo: logic to prompt player to choose to replace or not

    }

    public void displayInventory() {

        System.out.println("Inventory");

        for (Map.Entry<EquipmentSlot, Equipment> entry : inventory.entrySet()) {
            System.out.println(entry.getKey().getSlotDescription() + entry.getValue().itemDescription);
        }

    }

    /**
     * Removes an item from an inventory slot.
     */
    public void removeItem(EquipmentSlot slot, Equipment item) {
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
    public Equipment getEquippedItem(EquipmentSlot slot) {
        return inventory.get(slot);
    }

    /**
     * Inventory constructor.
     */
    public PlayerInventory() {
        this.inventory = new HashMap<>();
    }
}
