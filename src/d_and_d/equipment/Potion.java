package d_and_d.equipment;

/** Petite potion de soin. Restaure un faible nombre de HP. */
public class Potion extends DefensiveEquipment {

    public Potion(String name, int lvlProtection) {
        super(name, "Potion", lvlProtection);
    }

    @Override
    public String toString() {
        return "Potion \uD83E\uDDEA " + super.toString();
    }
}