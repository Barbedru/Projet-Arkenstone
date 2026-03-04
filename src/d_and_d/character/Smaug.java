package d_and_d.character;

public class Smaug extends Character {

    public Smaug(String name, int attack, int hp) {
        super(name,"Smaug", attack, hp);
    }

    @Override
    public String toString() {
        return "Smaug" + super.toString();
    }
}
