package d_and_d.board;

import d_and_d.character.Character;


//Case Ennemi
public class EnemyCell extends Cell {

    private Character villains;

    public EnemyCell(int position) {
        super(position);

    }


    @Override
    public void action(Character character) {
        System.out.println("⚔\uFE0F Cell " + position + " - BASTON !");
        System.out.println(character.getName() + " fights " + villains.getName() + " !");
    }
}
