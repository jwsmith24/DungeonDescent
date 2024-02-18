package utility.index;

/**
 * Contains all game items, their descriptions, values, and bonuses.
 */
public enum Item {

    // Starting Gear
    NO_HELMET("No Helmet Equipped", "Just your head against the world.", 0, EquipmentSlot.HELMET, 0),
    NO_ARMOR("No Armor Equipped", "Just your shirt, good luck" +
            ".", 0, EquipmentSlot.ARMOR, 0),
    NO_WEAPON("No Weapon Equipped", "Just your hands, do your " +
            "worst!", 0, EquipmentSlot.WEAPON, 0),
    NO_OFF_HAND("No Off-hand Equipped", "Go find something.", 0, EquipmentSlot.OFF_HAND, 0),
    NO_POTION("No potion Equipped", "Go find one!", 0, EquipmentSlot.POTION, 0),


    // Starting weapons (assigned after character creation based on class)
    RUSTY_SWORD("Rusty Sword", "This sword has seen better days", 1, EquipmentSlot.WEAPON, 1),
    RUSTY_DAGGER("Corroded Dagger", "This dagger is on its last leg", 1, EquipmentSlot.WEAPON, 1),
    WARPED_WAND("Warped Wand", "You're not 100% sure that this isn't just a weird stick", 1, EquipmentSlot.WEAPON, 1),
    RUSTY_MACE("Rusty Mace", "Maybe pulling the first weapon you found in the chapel basement wasn't the best idea.", 1, EquipmentSlot.WEAPON, 1),


    // Potions (Only strength and def are going to be used this round)
    POTION_OF_STRENGTH("Potion of Strength", "Drink to increase attack!", 10, EquipmentSlot.POTION, 1),
    POTION_OF_SPEED("Potion of Speed", "Drink to increase speed!", 10, EquipmentSlot.POTION, 1),
    POTION_OF_ENERGY("Potion of Energy", "Drink to increase energy!", 10, EquipmentSlot.POTION, 1),
    POTION_OF_DEFENSE("Potion of Defense", "Drink to increase defense!", 10, EquipmentSlot.POTION, 1),
    POTION_OF_LUCK("Potion of Luck", "Drink to increase luck", 10, EquipmentSlot.POTION, 1),


    // ARMOR

    IRON_HELMET("Iron Helmet", "Has cool horns", 15, EquipmentSlot.HELMET, 2),


    STEEL_ARMOR("Steel Armor", "Steel armor", 50, EquipmentSlot.ARMOR, 2),
    DRAGONSCALE_ARMOR("Dragonscale Armor", "Formed from the scales of slain dragons within the dungeon", 100, EquipmentSlot.ARMOR, 3),

    ROBE_OF_THE_RED_DRAGON("Robe of the Red Dragon", "Radiates with an unnatural warmth", 100, EquipmentSlot.ARMOR, 3),
    WOODEN_SHIELD("Wooden Shield", "Looks pretty sturdy", 15, EquipmentSlot.OFF_HAND, 1),
    DRAGONSCALE_SHIELD("Dragonscale Shield", "Strong against swords AND fire!", 100, EquipmentSlot.OFF_HAND, 3),


    STEEL_SWORD("Steel Longsword", "Quality craftsmanship!", 30, EquipmentSlot.WEAPON, 3),
    MAPLE_WAND("Maple Wand", "Ornately crafted", 30, EquipmentSlot.WEAPON, 3),
    STEEL_MACE("Steel Mace", "Ready to pummel demons!", 30, EquipmentSlot.WEAPON, 3),
    GLASS_DAGGER("Glass Dagger", "Lightweight, shiny, AND greeeeeeen", 50, EquipmentSlot.WEAPON, 3),
    SUSSUR_SWORD("Sussur Sword", "Emits a faint blue aura", 60, EquipmentSlot.WEAPON, 4),


    // Shopkeeper items - filtered by unique price

    SWORD_OF_SLASHING("Sword of Slashing", "Slashes really good. +5 to ATK!", 41, EquipmentSlot.WEAPON, 5),
    HELMET_OF_PROTECTION("Helmet of Protection", "Wear for protection!", 41, EquipmentSlot.HELMET, 5),
    POTION_OF_HEALING("Potion of Healing", "Drink to restore hit points!", 41, EquipmentSlot.POTION, 5),
    HAT_OF_STYLE("Hat of Style", "You'll look super cool.", 41, EquipmentSlot.HELMET, 10);

    private final String itemName;
    private final String itemDescription;
    private final int itemValue;
    private final EquipmentSlot itemType;
    private final int bonus;

    Item(String itemName, String itemDescription, int itemValue, EquipmentSlot itemType, int bonus) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemValue = itemValue;
        this.itemType = itemType;
        this.bonus = bonus;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemValue() {
        return itemValue;
    }

    public EquipmentSlot getItemType() {
        return itemType;
    }

    public int getBonus() {
        return bonus;
    }
}
