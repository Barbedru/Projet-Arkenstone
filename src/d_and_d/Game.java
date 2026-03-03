package d_and_d;

import d_and_d.character.Dwarf;
import d_and_d.character.Character;
import d_and_d.character.Wizard;

import java.util.Scanner;


public class Game {

    private Menu menu;
    // Gère l'affichage et les entrées du menu principal.

    private Dice dice;
    // Objet permettant de lancer un dé.

    private Board board;
    // Représente le plateau de jeu.

    private Character character;
    // Le personnage contrôlé par le joueur.

    private Scanner scanner;
    // Scanner utilisé pour les pauses / entrées clavier.

    public Game (Menu menu, Dice dice, Scanner scanner) {
        // Constructeur : on injecte les dépendances
        // (bonne pratique = injection de dépendances)

        this.menu = menu;
        this.dice= dice;
        this.scanner = scanner;
    }

    public void startGame() {
        // Méthode principale qui lance le jeu.

        while (!menu.mainMenu()) {
            // Tant que l'utilisateur ne choisit pas "Quit"

            String type = menu.getType();
            // Demande le type de personnage

            String name = menu.getName();
            // Demande le nom

            initGame(type, name);
            // Initialise la partie

            while (!checkWin()) {
                loop();
                // Boucle principale du jeu
                // Continue tant que le joueur n’a pas gagné
            }

            board.print();
            // Affiche le plateau final

            System.out.println("On a gagné !");
            // Message de victoire
        }
    }

    public void initGame(String type, String name) {
        // Initialise une nouvelle partie

        board = new Board(64);
        // Création d’un plateau de 64 cases

        if(type.equals("Warrior")) {
            character = new Dwarf(name);
            // Si type = Warrior → on crée un Dwarf
        } else {
            character = new Wizard(name);
            // Sinon → Wizard par défaut
        }

        board.setTile(0, character);
        // Place le personnage sur la case 0
    }

    public void loop() {
        // Un tour de jeu

        board.print();
        // Affiche le plateau

        int roll = dice.roll(6);
        // Lance un dé à 6 faces

        board.moveCharacter(roll);
        // Déplace le personnage

        this.scanner.nextLine();
        // Pause : attend que l’utilisateur appuie sur Entrée
    }

    public boolean checkWin() {
        // Vérifie si le joueur est arrivé à la dernière case

        return board.getTile(63) == character;
        // Si la case 63 contient le personnage → victoire
    }
}



