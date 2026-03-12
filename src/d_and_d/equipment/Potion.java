package d_and_d.equipment;


public class Potion extends DefensiveEquipment {


    public Potion(String name, int lvlProtection) {
        super("Potion", "Potion", lvlProtection);
    }

    @Override
    public String toString() {
        return "Potion \uD83E\uDDEA " + super.toString();
    }
}