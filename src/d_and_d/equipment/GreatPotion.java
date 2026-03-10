package d_and_d.equipment;

public class GreatPotion extends DefensiveEquipment {
    public GreatPotion(String name,int lvlProtection) {
        super("Great Potion", "Potion", 5);
    }

    @Override
    public String toString() {
        return "GreatPotion ⚗\uFE0F " + super.toString();
    }
}
