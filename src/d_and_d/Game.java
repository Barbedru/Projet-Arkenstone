package d_and_d;

import d_and_d.character.Dwarf;
import d_and_d.character.Character;
import d_and_d.character.Wizard;

import java.util.Scanner;

/**
 * Classe principale gérant le déroulement du jeu Donjons & Dragons.
 * <p>
 * Elle orchestre les interactions entre le menu, le plateau, le dé
 * et le personnage du joueur, et contient la boucle de jeu principale.
 * </p>
 */
public class Game {

    /**
     * Gère l'affichage et les entrées du menu principal.
     */
    private Menu menu;

    /**
     * Objet permettant de lancer un dé.
     */
    private Dice dice;

    /**
     * Représente le plateau de jeu contenant les cases.
     */
    private Board board;

    /**
     * Le personnage contrôlé par le joueur.
     */
    private Character character;

    /**
     * Scanner utilisé pour lire les entrées clavier (pauses, saisies).
     */
    private Scanner scanner;

    /**
     * Construit une instance de {@code Game} en injectant les dépendances nécessaires.
     *
     * @param menu    le menu principal du jeu
     * @param dice    l'objet dé utilisé pour les lancers aléatoires
     * @param scanner le scanner pour la lecture des entrées clavier
     */
    public Game(Menu menu, Dice dice, Scanner scanner) {
        this.menu = menu;
        this.dice = dice;
        this.scanner = scanner;
    }

    /**
     * Lance et gère la boucle de jeu principale.
     * <p>
     * Tant que le joueur ne choisit pas "Quit" dans le menu, une nouvelle partie
     * est initialisée. La boucle de jeu tourne jusqu'à ce que le joueur atteigne
     * la dernière case (victoire).
     * </p>
     */
    public void startGame() {
        while (!menu.mainMenu()) {
            String type = menu.getType();
            String name = menu.getName();
            menu.displayCharacter(type, name);

            initGame(type, name);

            while (!checkWin()) {
                loop();
            }

            board.print();
            System.out.println("Found the Arkenstone !");
            System.out.println("Your are the King under the mountain !");
        }
    }

    /**
     * Initialise une nouvelle partie en créant le plateau et le personnage.
     * <p>
     * Le personnage est instancié selon le type choisi ({@code "Dwarf"} ou {@code "Wizard"}),
     * puis placé sur la case de départ (index 0) du plateau.
     * </p>
     *
     * @param type le type de personnage choisi par le joueur ({@code "Dwarf"} ou {@code "Wizard"})
     * @param name le nom du personnage choisi par le joueur
     */
    public void initGame(String type, String name) {
        board = new Board(64);

        if (type.equals("Dwarf")) {
            character = new Dwarf(name, 5, 10);
        } else if (type.equals("Wizard")) {
            character = new Wizard(name, 8, 6);
        } else {
            System.out.println("Yippee Ki-Yay");
        }

        board.setTile(0, character);
    }

    /**
     * Exécute un tour de jeu.
     * <p>
     * Affiche le plateau, lance un dé à 6 faces, déplace le personnage
     * du nombre de cases correspondant, puis attend une saisie clavier avant
     * de passer au tour suivant.
     * </p>
     */
    public void loop() {
        board.print();
        int roll = dice.roll(6);
        board.moveCharacter(roll);
        this.scanner.nextLine();
    }

    /**
     * Vérifie si le joueur a gagné la partie.
     * <p>
     * La condition de victoire est atteinte lorsque le personnage
     * se trouve sur la dernière case du plateau (index 63).
     * </p>
     *
     * @return {@code true} si le personnage est sur la case 63, {@code false} sinon
     */
    public boolean checkWin() {
        return board.getTile(63) == character;
    }
}