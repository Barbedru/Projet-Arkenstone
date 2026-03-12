package d_and_d.equipment;

public class Lightning extends OffensiveEquipment {
    public Lightning(String name, int lvlAttack) {
        super("Lightning", "Weapon", lvlAttack);
    }

    @Override
    public String toString() {
        return "Lightning ⚡ " + super.toString();
    }
}
