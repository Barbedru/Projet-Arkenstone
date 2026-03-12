package d_and_d.equipment;

/** Sort offensif faible. Premier sort disponible, utile en début de jeu. */
public class Lightning extends OffensiveEquipment {

    public Lightning(String name, int lvlAttack) {
        super(name, "Spell", lvlAttack);
    }

    @Override
    public String toString() {
        return "Lightning ⚡ " + super.toString();
    }
}