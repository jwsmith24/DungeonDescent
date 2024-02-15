package monsters;

public class Spider extends Monster {

    /**
     * Builds a monster with spider stats.
     */
    public Spider() {
        super("Giant Spider", 26, 5, 14, 2, 200);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attack() {
        System.out.println("The spider lunges at you to take a massive bite!");

    }



}

