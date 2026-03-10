package d_and_d.equipment;



public class FireBall extends OffensiveEquipment {


    public FireBall(String name, int lvlAttack) {
        super("FireBall", "Spell", 7);
    }


    @Override
    public String toString() {
        return "FireBall \uD83D\uDD25 " + super.toString();
    }
}