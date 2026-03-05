package d_and_d.character;


import d_and_d.equipment.OffensiveEquipment;

public class Dwarf extends Character {


    public Dwarf(String name, int attack, int hp) {

        super(name, "Dwarf", 5 , 10, null);
    }


    @Override
    public String toString() {
        return "Dwarf{} " + super.toString();
    }

}