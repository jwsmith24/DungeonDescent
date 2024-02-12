package utility.index;

/**
 * Contains all game items, their descriptions, and values.
 */
public enum Item {

    // Starting Gear
    NO_HELMET("No Helmet Equipped", "Just your head against the world.", 0),
    NO_ARMOR("No Armor Equipped", "Just your shirt, good luck" +
            ".", 0),
    NO_WEAPON("No Weapon Equipped", "Just your hands, do your " +
            "worst!", 0),
    NO_OFF_HAND("No Off-hand Equipped", "Go find something.", 0),
    NO_POTION("No potion Equipped", "Go find one!", 0),

    // Starting weapons (assigned after character creation based on class)
    RUSTY_SWORD("Rusty Sword", "This sword has seen better days", 1),
    RUSTY_DAGGER("Corroded Dagger", "This dagger is on its last leg", 1),
    WARPED_WAND("Warped Wand", "You're not 100% sure that this isn't just a weird stick", 1),
    RUSTY_MACE("Rusty Mace", "Maybe pulling the first weapon you found in the chapel basement wasn't the best idea.", 1),

   // Potions
    POTION_OF_HEALING("Potion of Healing", "Drink to restore hit points!", 10),

    // ARMOR
    HELMET_OF_PROTECTION("Helmet of Protection", "Wear for protection!", 20);



    //

    private final String itemName;
    private final String itemDescription;
    private final int itemValue;


    Item(String itemName, String itemDescription, int itemValue) {

        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemValue = itemValue;
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


    // Helmets


    // Armor


    // Weapons



    // Off-hands




    // Potions


}
