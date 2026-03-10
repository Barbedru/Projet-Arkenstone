package d_and_d.board;

import d_and_d.character.Character;


public abstract class Cell {

    protected int position;

    public Cell(int position) {

        this.position = position;
    }


    protected void interact(Character character) {
    }

}