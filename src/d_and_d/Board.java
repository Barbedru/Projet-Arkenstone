package d_and_d;

public class Board {

    private Object[] board;
    // Tableau représentant le plateau de jeu.
    // Chaque case peut contenir un objet (personnage, ennemi, etc.)
    // ou être null (case vide).

    private int characterPosition;
    // Stocke la position actuelle du personnage sur le plateau.

    public Board(int size) {
        board = new Object[size];
        // Constructeur : crée un plateau de la taille donnée.
        // Toutes les cases sont initialisées à null par défaut.
    }

    public Object getTile(int pos) {
        // Retourne l’objet présent à la position donnée.
        return board[pos];
    }

    public void setTile(int pos, Object tile) {
        // Place un objet dans une case donnée.
        board[pos] = tile;
    }

    public void moveCharacter(int move) {
        // Déplace le personnage d’un certain nombre de cases.

        Object character = getTile(characterPosition);
        // Récupère le personnage à sa position actuelle.

        setTile(characterPosition, null);
        // Vide l’ancienne case (le personnage quitte la case).

        characterPosition += move;
        // Met à jour la position en ajoutant le déplacement.

        if (characterPosition >= board.length) {
            characterPosition = board.length - 1;
        }
        // Empêche le personnage de sortir du plateau.
        // S’il dépasse la taille, on le place sur la dernière case.

        setTile(characterPosition, character);
        // Place le personnage sur sa nouvelle case.
    }

    public void print() {
        // Affiche le plateau dans la console.

        for (int i = 0; i < board.length; i++) {
            if (board[i] == null) {
                System.out.print(".");
                // "." représente une case vide.
            } else {
                System.out.print(board[i]);
                // Affiche l’objet contenu dans la case.
                // (utilise automatiquement toString())
            }
        }
    }
}





