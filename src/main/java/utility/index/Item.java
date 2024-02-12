package utility.index;

/**
 * Contains all game items, their descriptions, and values.
 */
public enum Item {

    NO_HELMET("No Helmet", "Just your head against the world.", 0),
    NO_ARMOR("No Armor", "Just your shirt, good luck" +
            ".", 0),
    NO_WEAPON("No Weapon", "Just your hands, do your " +
            "worst!", 0),
    NO_OFF_HAND("No Off-hand", "Go find something.", 0),
    POTION_OF_HEALING("Potion of Healing", "Drink to restore hit points!", 10);

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
