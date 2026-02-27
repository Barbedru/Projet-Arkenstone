package characters;

public class Character {
    private String type; //Dwarf or Wizard
    private String name;
    private int attack;
    private int pv;

    //Constructeur
    public Character(String type, String name, int healthLevel, int attackLevel) {
        this.type = type;
        this.name = name;
        this.attack = attack;
        this.pv = pv;

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

    public int getAttack() {
        return pv;
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

    public void setPv(int pv){
        this.pv = pv;
    }

    //tostring

    @Override
    public String toString(){
        return "Character" + "type = " + type + " "
                + " name = " + name + " "
                + " attack = " + attack + " "
                + " pv = " + pv + " ";

    }
}
