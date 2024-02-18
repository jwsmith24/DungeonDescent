package monsters;

public class Dragon extends Monster {

    /**
     * Builds a monster with dragon stats.
     */
    public Dragon() {
        super("Young Red Dragon", 180, 10, 18, 5, 5900);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attackText() {

        System.out.println("The Dragon roars as the corridor erupts into flames!");
    }



}

