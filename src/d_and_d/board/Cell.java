package d_and_d.board;

import d_and_d.character.Character;

/**
 * Classe abstraite représentant une case du plateau de jeu.
 * <p>
 * Chaque case possède une position et peut interagir avec le personnage
 * qui la foule. Les sous-classes ({@link EnemyCell}, {@link PotionCell}, etc.)
 * définissent le comportement spécifique de chaque type de case.
 * </p>
 */
public abstract class Cell {

    /** Position de la case sur le plateau (de 1 à 64). */
    protected int position;

    /**
     * @param position la position de la case sur le plateau
     */
    public Cell(int position) {
        this.position = position;
    }

    /**
     * Déclenche l'interaction entre cette case et le personnage qui vient d'y arriver.
     * La méthode est vide par défaut — chaque sous-classe la surcharge pour définir
     * son propre comportement (combat, ramassage d'objet, etc.).
     *
     * @param character le personnage qui arrive sur la case
     */
    protected void interact(Character character) {
    }
}