package character;


/**
 * Warrior decorator class.
 */
public class Warrior extends BasicCharacter {

    /**
     * A Warrior has a unique special and gets a large bonus to HP and Defence.
     * @param name character name
     */
    public Warrior(String name) {
        super(name);
    }

}
