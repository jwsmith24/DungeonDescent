package monsters;

public class Skeleton extends Monster {

    /**
     * Builds a monster with skeleton stats.
     */
    public Skeleton() {
        super("Skeleton", 13, 4, 13, 1, 50);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attackText() {

        System.out.println("The skeleton swings its shattered blade at you");

    }



}
