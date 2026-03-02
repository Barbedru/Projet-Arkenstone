package characters;

public class DefensiveEquipment {
    private String type; //Shield or Potion
    private String name;
    private int defense;

    public DefensiveEquipment(String type, String name, int defense) {
        this.type = type;
        this.name = name;
        this.defense = defense;
    }

    //Getters
    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPv() {
        return defense;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAttack(int attack){
        this.defense = attack;
    }


    //tostring

    @Override
    public String toString(){
        return "DefensiveEquipment" + "type = " + type + " " + " name = " + name + " "  + " defense = " + defense + " ";

    }

}
