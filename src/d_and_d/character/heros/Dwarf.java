package d_and_d.character.heros;

import d_and_d.character.Character;

/**
 * Héros de type Nain : robuste mais peu offensif.
 * Stats de base : attaque 5, HP 10.
 * Recommandé pour les joueurs qui préfèrent encaisser les coups.
 */
public class Dwarf extends Character {

    public Dwarf(String name, int attack, int hp) {
        super(name, "Dwarf", attack, hp, null);
    }
}