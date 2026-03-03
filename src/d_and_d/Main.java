package d_and_d;

import java.util.Scanner;

/**
 * Point d'entrée principal de l'application Donjons & Dragons.
 */
public class Main {

    /**
     * Méthode principale qui initialise et lance le jeu.
     * <p>
     * Instancie les dépendances ({@link Scanner}, {@link Menu}, {@link Dice})
     * et les injecte dans {@link Game} avant de démarrer la partie.
     * </p>
     *
     * @param args les arguments de la ligne de commande (non utilisés)
     */

    public static void main(String[] args) {
            Scanner scanner = new Scanner (System.in);
            Game game = new Game(new Menu(scanner), new Dice(), scanner);
            game.startGame();
        }

    }
