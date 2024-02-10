package character;

public class Wizard extends Player {
    public Wizard(String name) {
        super(name);
    }

    @Override
    public int getAttack() {
        return super.getAttack() + 2;
    }
}