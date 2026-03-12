package d_and_d.equipment;

/** Arme de base. Attaque modérée, trouvée dès le début du plateau. */
public class Sword extends OffensiveEquipment {

    public Sword(String name, int lvlAttack) {
        super(name, "Weapon", lvlAttack);
    }

    @Override
    public String toString() {
        return "Sword \uD83D\uDDE1\uFE0F " + super.toString();
    }
}