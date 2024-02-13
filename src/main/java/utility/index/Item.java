package utility.index;

import dungeon.Shop;

/**
 * Contains all game items, their descriptions, and values.
 */
public enum Item {

    // Starting Gear
    NO_HELMET("No Helmet Equipped", "Just your head against the world.", 0, EquipmentSlot.HELMET),
    NO_ARMOR("No Armor Equipped", "Just your shirt, good luck" +
            ".", 0, EquipmentSlot.ARMOR),
    NO_WEAPON("No Weapon Equipped", "Just your hands, do your " +
            "worst!", 0, EquipmentSlot.WEAPON),
    NO_OFF_HAND("No Off-hand Equipped", "Go find something.", 0, EquipmentSlot.OFF_HAND),
    NO_POTION("No potion Equipped", "Go find one!", 0, EquipmentSlot.POTION),


    // Starting weapons (assigned after character creation based on class)
    RUSTY_SWORD("Rusty Sword", "This sword has seen better days", 1, EquipmentSlot.WEAPON),
    RUSTY_DAGGER("Corroded Dagger", "This dagger is on its last leg", 1, EquipmentSlot.WEAPON),
    WARPED_WAND("Warped Wand", "You're not 100% sure that this isn't just a weird stick", 1, EquipmentSlot.WEAPON),
    RUSTY_MACE("Rusty Mace", "Maybe pulling the first weapon you found in the chapel basement wasn't the best idea.", 1, EquipmentSlot.WEAPON),


    // Potions
    POTION_OF_STRENGTH("Potion of Strength", "Drink to increase attack!", 10, EquipmentSlot.POTION),
    POTION_OF_SPEED("Potion of Speed", "Drink to increase speed!", 10, EquipmentSlot.POTION),
    POTION_OF_ENERGY("Potion of Energy", "Drink to increase energy!", 10, EquipmentSlot.POTION),
    POTION_OF_DEFENSE("Potion of Defense", "Drink to increase defense!", 10, EquipmentSlot.POTION),
    POTION_OF_LUCK("Potion of Luck", "Drink to increase luck", 10, EquipmentSlot.POTION),


    // ARMOR

    IRON_HELMET("Iron Helmet", "Has cool horns", 15, EquipmentSlot.ARMOR),


    STEEL_ARMOR("Steel Armor", "Steel armor", 50, EquipmentSlot.ARMOR),
    DRAGONSCALE_ARMOR("Dragonscale Armor", "Formed from the scales of slain dragons within the dungeon", 100, EquipmentSlot.ARMOR),


    WOODEN_SHIELD("Wooden Shield", "Looks pretty sturdy", 15, EquipmentSlot.OFF_HAND),
    DRAGONSCALE_SHIELD("Dragonscale Shield", "Strong against swords AND fire!", 100, EquipmentSlot.OFF_HAND),


    STEEL_SWORD("Steel Longsword", "Quality craftsmanship!", 30, EquipmentSlot.WEAPON),
    MAPLE_WAND("Maple Wand", "Ornately crafted", 30, EquipmentSlot.WEAPON),
    STEEL_MACE("Steel Mace", "Ready to pummel demons!", 30, EquipmentSlot.WEAPON),
    GLASS_DAGGER("Glass Dagger", "Lightweight, shiny, AND greeen", 50, EquipmentSlot.WEAPON),


    // Shopkeeper items - filtered by unique price

    SWORD_OF_SLASHING("Sword of Slashing", "Slashes really good. +1 to ATK!", 41, EquipmentSlot.WEAPON),
    HELMET_OF_PROTECTION("Helmet of Protection", "Wear for protection!", 41, EquipmentSlot.HELMET),
    POTION_OF_HEALING("Potion of Healing", "Drink to restore hit points!", 41, EquipmentSlot.POTION),
    HAT_OF_STYLE("Hat of Style", "You'll look super cool.", 41, EquipmentSlot.HELMET);





    //

    private final String itemName;
    private final String itemDescription;
    private final int itemValue;
    private final EquipmentSlot itemType;


    Item(String itemName, String itemDescription, int itemValue, EquipmentSlot itemType) {

        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemValue = itemValue;
        this.itemType = itemType;
    }


    public String getItemName() {
        return this.itemName;
    }
    public String getItemDescription() {
        return this.itemDescription;
    }

    public int getItemValue() {
        return this.itemValue;
    }

    public EquipmentSlot getItemType() {
        return this.itemType;
    }



}
