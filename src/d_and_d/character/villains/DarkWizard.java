package d_and_d.character.villains;

import d_and_d.character.Character;
import d_and_d.equipment.OffensiveEquipment;

/**
 * Ennemi intermédiaire. Plus résistant que le Gobelin,
 * il apparaît en milieu de plateau pour augmenter la difficulté.
 */
public class DarkWizard extends Character {

    public DarkWizard(String name, String type, int attack, int hp, OffensiveEquipment offensiveEquipment) {
        super(name, "DarkWizard", attack, hp, offensiveEquipment);
    }

    @Override
    public String toString() {
        return "DarkWizard{} " + super.toString();
    }
}