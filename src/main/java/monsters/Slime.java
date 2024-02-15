package monsters;

public class Slime extends Monster {

    /**
     * Builds a monster with Slime stats.
     */
    public Slime() {
        super("OOZE", 22, 3, 8, 0, 100);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {

        System.out.println("The ooze forms into a massive fist that sails in your direction!");
    }



}

