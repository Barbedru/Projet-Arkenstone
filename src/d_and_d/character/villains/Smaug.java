package d_and_d.character.villains;

import d_and_d.character.Character;


public class Smaug extends Character {

    public Smaug(String name, int attack, int hp) {
        super("Smaug","Boss", 8, 25, null);
    }

    @Override
    public String toString() {

        return "Smaug" + super.toString();
    }
}
