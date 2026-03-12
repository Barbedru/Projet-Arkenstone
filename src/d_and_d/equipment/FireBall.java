package d_and_d.equipment;

/** Sort offensif puissant. Réservé aux cases avancées du plateau. */
public class FireBall extends OffensiveEquipment {

    public FireBall(String name, int lvlAttack) {
        super(name, "Spell", lvlAttack);
    }

    @Override
    public String toString() {
        return "FireBall \uD83D\uDD25 " + super.toString();
    }
}