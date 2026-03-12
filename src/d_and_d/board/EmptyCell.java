package d_and_d.board;

import d_and_d.character.Character;

/**
 * Case vide : aucun objet, aucun ennemi.
 * Le personnage doit simplement continuer sa route.
 */
public class EmptyCell extends Cell {

    public EmptyCell(int position) {
        super(position);
    }

    @Override
    public void interact(Character character) {
        System.out.println("There's nothing here  \uD83E\uDDB4\uD83E\uDDB4\uD83E\uDDB4  ....");
        System.out.println(character.getName() + " must move");
    }
}