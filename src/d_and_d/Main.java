package d_and_d;

import java.util.Scanner;

/**
 * Point d'entrée du jeu Arkenstone.
 * Initialise les composants principaux et lance la boucle de jeu.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // On injecte le même Scanner dans Menu et Game pour éviter les conflits de lecture
        Game game = new Game(new Menu(scanner), new Dice(), scanner);
        game.startGame();
    }

}