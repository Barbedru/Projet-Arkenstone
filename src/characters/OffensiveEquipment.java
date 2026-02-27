package characters;

public class OffensiveEquipment {
    private String type; //Weapon or Spell
    private String name;
    private int attack;

    public OffensiveEquipment(String type, int attackLevel, String name) {
        this.type = type;
        this.name = name;
        this.attack = attack;
    }

    //Getters
    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPv() {
        return attack;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }
}
