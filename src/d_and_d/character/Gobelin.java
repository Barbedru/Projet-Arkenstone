package d_and_d.character;

public class Gobelin extends Character {

    public Gobelin (String name, int attack, int hp) {

        super(name, "Gobelin", 1, 6, null);
    }

    @Override
    public String toString() {

        return "Gobelin" + super.toString();
    }
}
