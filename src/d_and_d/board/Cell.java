package d_and_d.board;



public abstract class Cell {

    private int position;

    public Cell(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }




    @Override
    public String toString() {
        return "Cell{" +
                "position=" + position +
                '}';
    }


}
