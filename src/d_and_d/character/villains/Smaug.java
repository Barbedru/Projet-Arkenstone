package d_and_d.character.villains;

import d_and_d.character.Character;

/**
 * Boss final du jeu. Garde la dernière case (64) et l'Arkenstone.
 * Vaincre Smaug déclenche la condition de victoire.
 */
public class Smaug extends Character {

    public Smaug(String name, int attack, int hp) {
        super(name, "Boss", attack, hp, null);
    }

    @Override
    public String toString() {
        return "Smaug" + super.toString();
    }
}