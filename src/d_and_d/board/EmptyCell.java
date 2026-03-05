package d_and_d.board;
import d_and_d.character.Character;
//Case Vide
public class EmptyCell extends Cell {

    public EmptyCell(int position) {
        super(position);
    }

    @Override
    public void action(Character character) {
        System.out.println("Cell " + position + " - There's nothing here...");
        System.out.println(character.getName() + " must move" );

    }
}
