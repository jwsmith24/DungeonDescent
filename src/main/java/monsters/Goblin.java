package monsters;

public class Goblin extends Monster {

    /**
     * Builds a monster with goblin stats.
     */
   public Goblin() {
       super("Goblin", 7, 1, 12, 1, 50);
   }

    /**
     * Attack a player.
     */
    @Override
    public void attackText() {

        System.out.println("The goblin strikes at you with its short sword!");
    }



}
