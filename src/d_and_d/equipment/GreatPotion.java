package d_and_d.equipment;

/** Grande potion de soin. Restaure un nombre élevé de HP, disponible sur les cases avancées. */
public class GreatPotion extends DefensiveEquipment {

    public GreatPotion(String name, int lvlProtection) {
        super(name, "Potion", lvlProtection);
    }

    @Override
    public String toString() {
        return "GreatPotion ⚗\uFE0F " + super.toString();
    }
}