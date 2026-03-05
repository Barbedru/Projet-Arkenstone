package d_and_d.board;

//Case Vide
public class EmptyCell extends Cell {


    public EmptyCell(int position) {

        super(position);
    }



    @Override
    public String toString() {

        return "EmptyCell{} " + super.toString();
    }
}