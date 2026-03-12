package d_and_d.character.villains;

import d_and_d.character.Character;
import d_and_d.equipment.OffensiveEquipment;

/**
 * Ennemi de base du jeu. Faible attaque et peu de HP.
 * Apparaît sur les premières cases pour initier le joueur au combat.
 */
public class Gobelin extends Character {

    public Gobelin(String name, int attack, int hp, OffensiveEquipment offensiveEquipment) {
        super(name, "Gobelin", attack, hp, offensiveEquipment);
    }

    @Override
    public String toString() {
        return "Gobelin" + super.toString();
    }
}