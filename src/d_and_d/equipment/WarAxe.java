package d_and_d.equipment;

public class WarAxe extends OffensiveEquipment {

    public WarAxe(String name, int lvlAttack) {
        super("WarAxe", "Weapon", lvlAttack);
    }

    @Override
    public String toString() {
        return "WarAxe \uD83E\uDE93 " + super.toString();
    }
}
