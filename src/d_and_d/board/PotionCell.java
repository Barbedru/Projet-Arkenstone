package d_and_d.board;
import d_and_d.character.Character;
//Case Potion
public class PotionCell extends Cell {

    public PotionCell(int position) {

        super(position);
    }

    @Override
    public void action(Character character) {

        System.out.println("Cell " + position + " There's are something here ");
        System.out.println(character.getName() + " found a potion ! ");

    }
}