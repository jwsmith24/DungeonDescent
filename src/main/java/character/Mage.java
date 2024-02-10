package character;

public class Mage extends Player {
    public Mage(String name) {
        super(name);
        this.hitPoints = 5;
    }

    @Override
    public int getAttack() {
        return super.getAttack() + 2;
    }
}