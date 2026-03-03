package d_and_d.equipment;

public abstract class OffensiveEquipment {

    private String name;
    private String type;
    private int lvlAttack;

    public OffensiveEquipment (String name, String type, int lvlAttack){
        this.name = name;
        this.type = type;
        this.lvlAttack = lvlAttack;

    }
}
