package d_and_d.equipment;


public class Sword extends OffensiveEquipment {


    public Sword(String name , int lvlAttack) {
        super("Sword", "Weapon", 3);
    }

    @Override
    public String toString() {
        return "Sword \uD83D\uDDE1\uFE0F " + super.toString();
    }
}
