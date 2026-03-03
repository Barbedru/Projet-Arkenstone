package d_and_d.character;

import d_and_d.equipment.OffensiveEquipment;

public class Character {
    //Dwarf or Wizard or Gobelin or Smaug
    private String name;
    private String type;
    private int attack;
    private int hp;
    private OffensiveEquipment offensiveEquipment;


    //Constructeur
    public Character(String name, String type ) {
        this.name = name;
        this.type = type;

    }




    //tostring

    @Override
    public String toString(){
        return " Player " ;

    }
}
