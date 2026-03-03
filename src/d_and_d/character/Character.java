package d_and_d.character;

import d_and_d.equipment.OffensiveEquipment;

public  abstract class Character {

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


//    //GETTERS
//    public String getName() {
//        return name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public int getAttack() {
//        return attack;
//    }
//
//    public int getHp() {
//        return hp;
//    }
//
//    public OffensiveEquipment getOffensiveEquipment() {
//        return offensiveEquipment;
//    }
//
//    //SETTERS
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public void setHp(int hp) {
//        this.hp = hp;
//    }
//
//    public void setAttack(int attack) {
//        this.attack = attack;
//    }
//
//    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
//        this.offensiveEquipment = offensiveEquipment;
//    }


    //tostring

    @Override
    public String toString(){
        return " Player " ;

    }

}
