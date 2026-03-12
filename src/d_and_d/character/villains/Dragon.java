package d_and_d.character.villains;

import d_and_d.character.Character;

/**
 * Ennemi avancé. Puissant et résistant,
 * il garde les cases de fin de plateau avant Smaug.
 */
public class Dragon extends Character {

    public Dragon(String name, int attack, int hp) {
        super(name, "Dragon", attack, hp, null);
    }
}