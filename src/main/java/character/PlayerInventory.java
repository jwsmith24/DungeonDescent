package character;

import java.util.HashMap;

import utility.index.EquipmentSlot;

public class PlayerInventory {

    HashMap<EquipmentSlot, Equipment> inventory;


    /**
     * Equips item to slot
     */
    public void equipItem(EquipmentSlot slot, Equipment item) {
        if (!isSlotEquipped(slot)){
            inventory.put(slot, item);
        }

        //todo: logic to prompt player to choose to replace or not

    }

    /**
     * Determine if slot is already equipped or open.
     */
    public boolean isSlotEquipped(EquipmentSlot slot) {

        return inventory.containsKey(slot);
    }

    /**
     * Inventory constructor.
     */
    public PlayerInventory() {
        this.inventory = new HashMap<>();
    }
}
