package d_and_d.board;
import d_and_d.character.Character;
//Case Arme
public class WeaponCell extends Cell {

    private String weaponName;

    public WeaponCell(int position) {
        super(position);
        //this.weaponName = weaponName;
    }

    @Override
    public void action(Character character) {
        System.out.println("Cell " + position + " There's are something here ");
        System.out.println(character.getName() + " found a weapon ! ");
    }
}