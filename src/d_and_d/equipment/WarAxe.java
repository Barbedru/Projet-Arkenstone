package d_and_d.equipment;

/** Arme puissante. Bonus d'attaque élevé, disponible en milieu/fin de plateau. */
public class WarAxe extends OffensiveEquipment {

    public WarAxe(String name, int lvlAttack) {
        super(name, "Weapon", lvlAttack);
    }

    @Override
    public String toString() {
        return "WarAxe \uD83E\uDE93 " + super.toString();
    }
}