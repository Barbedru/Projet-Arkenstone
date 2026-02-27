package characters;

public class DefensiveEquipment {
    private String type; //Shield or Potion
    private String name;
    private int defense;

    public DefensiveEquipment(String type, int defense, String name) {
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
}
