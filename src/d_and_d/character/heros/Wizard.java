package d_and_d.character.heros;

import d_and_d.character.Character;

/**
 * Héros de type Mage : puissant mais fragile.
 * Stats de base : attaque 8, HP 6.
 * Recommandé pour les joueurs offensifs.
 */
public class Wizard extends Character {

    public Wizard(String name, int attack, int hp) {
        super(name, "Wizard", attack, hp, null);
    }
}