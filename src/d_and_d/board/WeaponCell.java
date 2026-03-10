package d_and_d.board;
import d_and_d.character.Character;
import d_and_d.equipment.*;


//Case Arme
public class WeaponCell extends Cell {

    private OffensiveEquipment weapons;
    private OffensiveEquipment spells;

    public WeaponCell (int position){
        super(position);
        posWeapon(position);
    }

    private void posWeapon(int position){
        switch (position){
            case 2: case 5: case 11: case 22: case 38:
                weapons = new Sword("Sword", 3);
                break;
            case 19: case 26: case 42: case 53:
                weapons = new WarAxe("WarAxe", 5);
                break;

        }
    }



    @Override
    public void interact(Character character) {
        super.interact(character);

        if (weapons instanceof Sword) {
            System.out.println("Cell " + position +  " There's something here ");
            System.out.println(character.getName() + " found Sword \uD83D\uDDE1\uFE0F ");
        } else if (weapons instanceof WarAxe) {
            System.out.println("Cell " + position +  " There's are something here ");
            System.out.println(character.getName() + " found WarAxe \uD83E\uDE93 ");

        }

    }


}
