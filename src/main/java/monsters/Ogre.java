package monsters;

public class Ogre extends Monster {

    /**
     * Builds a monster with goblin stats.
     */
    public Ogre() {
        super("Ogre", 59, 6, 11, 1, 450);
    }

    /**
     * Attack a player.
     */
    @Override
    public void attackText() {

        System.out.println("The ogre attacks you with it's massive spiked club!");
    }





}
