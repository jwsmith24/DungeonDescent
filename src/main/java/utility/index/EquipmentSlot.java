package utility.index;



public enum EquipmentSlot {
    HELMET("Helmet: "),
    ARMOR("Armor: "),
    WEAPON("Weapon: "),
    OFF_HAND("Off-hand: "),
    POTION("Potion: ");

    private final String slotDescription;

    EquipmentSlot(String slotDescription) {
        this.slotDescription = slotDescription;

    }

    public String getSlotDescription() {
        return this.slotDescription;
    }

}


