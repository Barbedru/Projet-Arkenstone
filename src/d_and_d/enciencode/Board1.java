//package d_and_d.board;
//
///**
// * Représente le plateau de jeu sous forme d'un tableau linéaire de cases.
// * <p>
// * Chaque case peut contenir un objet (personnage, ennemi, etc.) ou être
// * vide ({@code null}). Le plateau gère également le déplacement du personnage
// * et l'affichage de son état dans la console.
// * </p>
// */
//public class Board {
//
//    /**
//     * Tableau représentant les cases du plateau.
//     * Une case à {@code null} est considérée comme vide.
//     */
//    private Object[] board;
//
//    /**
//     * Position actuelle du personnage sur le plateau (index dans le tableau).
//     */
//    private int playerPosition;
//
//    /**
//     * Construit un plateau de jeu de la taille donnée.
//     * Toutes les cases sont initialisées à {@code null} (vides) par défaut.
//     *
//     * @param size le nombre de cases du plateau
//     */
//    public Board(int size) {
//        board = new Object[size];
//    }

//    /**
//     * Retourne l'objet présent à la position donnée.
//     *
//     * @param pos l'index de la case à consulter
//     * @return l'objet contenu dans la case, ou {@code null} si elle est vide
//     */
//    public Object getTile(int pos) {
//        return board[pos];
//    }
//
//    /**
//     * Place un objet dans la case à la position donnée.
//     *
//     * @param pos  l'index de la case cible
//     * @param tile l'objet à placer dans la case
//     */
//    public void setTile(int pos, Object tile) {
//        board[pos] = tile;
//    }

//    /**
//     * Déplace le personnage d'un certain nombre de cases vers l'avant.
//     * <p>
//     * Si le déplacement dépasse la dernière case, le personnage est
//     * repositionné sur celle-ci afin de ne pas sortir du plateau.
//     * </p>
//     *
//     * @param move le nombre de cases à avancer
//     */
//    public void moveCharacter(int move) {
//        Object character = getTile(playerPosition);
//        setTile(playerPosition, null);
//
//        playerPosition += move;
//
//        if (playerPosition >= board.length) {
//            playerPosition = board.length - 1;
//        }
//
//        setTile(playerPosition, character);
//    }

//    /**
//     * Affiche le plateau dans la console.
//     * <p>
//     * Une case vide est représentée par {@code "."}, et une case occupée
//     * affiche le résultat de {@code toString()} de l'objet qu'elle contient.
//     * </p>
//     */
//    public void print() {
//        for (int i = 0; i < board.length; i++) {
//            if (board[i] == null) {
//                System.out.print(".");
//            } else {
//                System.out.print(board[i]);
//            }
//        }
//    }
//
//}