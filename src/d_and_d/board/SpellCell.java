package d_and_d.board;

import d_and_d.character.Character;
import d_and_d.equipment.FireBall;
import d_and_d.equipment.Lightning;
import d_and_d.equipment.OffensiveEquipment;

public class SpellCell extends Cell {
    private OffensiveEquipment spells;

    public SpellCell(int position) {
        super(position);
        posSpell(position);

    }

    private void posSpell(int position) {
        switch (position) {
            case 1: case 4: case 8: case 17: case 23:
                spells = new Lightning("Lightning", 2);
                break;
            case 48: case 49:
                spells = new FireBall("FireBall", 7);
                break;
        }
    }

    @Override
    public void interact(Character character) {
        super.interact(character);

        if (spells instanceof Lightning) {
            System.out.println("Cell " + "" + position + " " +  "There's something here ");

            System.out.println(character.getName() + " found Lightning ⚡ ");
        } else if (spells instanceof FireBall) {
            System.out.println("Cell " + "" + position + " " + "There's are something here ");
            System.out.println(character.getName() + " found FireBall  ");
        }

    }
}