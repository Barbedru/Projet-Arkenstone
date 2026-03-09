package d_and_d.character.villains;

import d_and_d.character.Character;

import d_and_d.equipment.OffensiveEquipment;

public class DarkWizard extends Character {


    public DarkWizard(String name, String type, int attack, int hp, OffensiveEquipment offensiveEquipment) {
        super(name, "DarkWizard", 2, 9, null);
    }


    @Override
    public String toString() {
        return "DarkWizard{} " + super.toString();
    }
}

