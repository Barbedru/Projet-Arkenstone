package d_and_d.board;

import d_and_d.character.Character;
import java.util.ArrayList;

/**
 * Représente le plateau de jeu sous forme d'une liste linéaire de cases.
 * <p>
 * Le plateau contient 64 cases (indices 0 à 63), chacune étant un type de {@link Cell}
 * différent (ennemi, potion, arme, vide). Le joueur commence hors plateau (position -1)
 * et avance case par case jusqu'à la dernière.
 * </p>
 */
public class Board {

    private ArrayList<Cell> board;
    private int playerPosition; // position actuelle du joueur dans la liste (index)

    /**
     * Construit le plateau et place toutes les cases dans l'ordre.
     * La position de départ est -1 (avant la première case).
     */
    public Board() {

        board = new ArrayList<>();
        playerPosition = -1; // -1 = le joueur n'est pas encore entré sur le plateau

        /* --- Cases 1 à 10 --- */
        board.add(new SpellCell(1));
        board.add(new WeaponCell(2));
        board.add(new EnemyCell(3));
        board.add(new SpellCell(4));
        board.add(new WeaponCell(5));
        board.add(new EnemyCell(6));
        board.add(new PotionCell(7));
        board.add(new SpellCell(8));
        board.add(new EnemyCell(9));
        board.add(new EnemyCell(10));

        /* --- Cases 11 à 20 --- */
        board.add(new WeaponCell(11));
        board.add(new EnemyCell(12));
        board.add(new PotionCell(13));
        board.add(new EmptyCell(14));
        board.add(new EnemyCell(15));
        board.add(new EmptyCell(16));
        board.add(new SpellCell(17));
        board.add(new EnemyCell(18));
        board.add(new WeaponCell(19));
        board.add(new EnemyCell(20));

        /* --- Cases 21 à 30 --- */
        board.add(new EnemyCell(21));
        board.add(new WeaponCell(22));
        board.add(new SpellCell(23));
        board.add(new EnemyCell(24));
        board.add(new EnemyCell(25));
        board.add(new WeaponCell(26));
        board.add(new EnemyCell(27));
        board.add(new PotionCell(28));
        board.add(new EmptyCell(29));
        board.add(new EnemyCell(30));

        /* --- Cases 31 à 40 --- */
        board.add(new PotionCell(31));
        board.add(new EnemyCell(32));
        board.add(new PotionCell(33));
        board.add(new EmptyCell(34));
        board.add(new EnemyCell(35));
        board.add(new EnemyCell(36));
        board.add(new EnemyCell(37));
        board.add(new WeaponCell(38));
        board.add(new PotionCell(39));
        board.add(new EnemyCell(40));

        /* --- Cases 41 à 50 --- */
        board.add(new PotionCell(41));
        board.add(new WeaponCell(42));
        board.add(new PotionCell(43));
        board.add(new EnemyCell(44));
        board.add(new EnemyCell(45));
        board.add(new EmptyCell(46));
        board.add(new EnemyCell(47));
        board.add(new SpellCell(48));
        board.add(new SpellCell(49));
        board.add(new EmptyCell(50));

        /* --- Cases 51 à 60 --- */
        board.add(new EmptyCell(51));
        board.add(new EnemyCell(52));
        board.add(new WeaponCell(53));
        board.add(new EmptyCell(54));
        board.add(new EmptyCell(55));
        board.add(new EnemyCell(56));
        board.add(new EmptyCell(57));
        board.add(new EmptyCell(58));
        board.add(new EmptyCell(59));
        board.add(new EmptyCell(60));

        /* --- Cases 61 à 64 (fin du plateau, Smaug en case 64) --- */
        board.add(new EmptyCell(61));
        board.add(new EnemyCell(62));
        board.add(new EmptyCell(63));
        board.add(new EnemyCell(64)); // Smaug — boss final
    }

    /**
     * Déplace le personnage de {@code move} cases vers l'avant,
     * puis déclenche l'interaction avec la case d'arrivée.
     * Si le déplacement dépasse la dernière case, on se bloque sur la dernière.
     *
     * @param move      le nombre de cases à avancer (résultat du dé)
     * @param character le héros à déplacer
     */
    public void moveCharacter(int move, Character character) {
        playerPosition = playerPosition + move;

        // On ne peut pas sortir du plateau
        try {
            board.get(playerPosition);
        } catch (IndexOutOfBoundsException e) {
            playerPosition = board.size() - 1;
        }

        Cell currentCell = board.get(playerPosition);
        currentCell.interact(character); // chaque case a son propre comportement
    }

    /**
     * Retourne la position actuelle du joueur sur le plateau.
     *
     * @return l'index de la case courante (entre -1 et 63)
     */
    public int getPlayerPosition() {
        return playerPosition;
    }

    /**
     * Affiche le plateau dans la console sous forme d'une ligne de points,
     * avec l'emoji 🍺 à la position actuelle du joueur.
     */
    public void print() {
        // On itère de -1 (position de départ) jusqu'à la fin du plateau
        for (int i = -1; i < board.size(); i++) {
            if (i == playerPosition) {
                System.out.print("\uD83C\uDF7A"); // 🍺 position du joueur
            } else {
                System.out.print("."); // case non occupée
            }
        }
        System.out.println();
    }
}