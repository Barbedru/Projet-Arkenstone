package d_and_d;

import java.util.Scanner;

/**
 * Classe gérant l'affichage des menus et les interactions avec le joueur.
 * <p>
 * Elle centralise toutes les saisies utilisateur nécessaires au démarrage
 * et à la configuration d'une partie.
 * </p>
 */
public class Menu {

    /**
     * Scanner utilisé pour lire les entrées clavier de l'utilisateur.
     */
    private Scanner scanner;

    /**
     * Construit un {@code Menu} en injectant le scanner de lecture.
     *
     * @param scanner le scanner permettant de lire les entrées utilisateur
     */
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Affiche le menu principal et traite le choix de l'utilisateur.
     * <p>
     * Les options disponibles sont :
     * <ul>
     *   <li>1 — Nouvelle partie : retourne {@code false} pour continuer</li>
     *   <li>2 — Éditer le personnage (non implémenté) : réaffiche le menu</li>
     *   <li>3 — Quitter : retourne {@code true} pour stopper le jeu</li>
     * </ul>
     * Toute saisie invalide réaffiche le menu.
     * </p>
     *
     * @return {@code true} si le joueur souhaite quitter, {@code false} sinon
     */
    public boolean mainMenu() {
        System.out.println("""        
                MAIN MENU
                ---------
                1 - New Game
                2 - Edit character
                3 - Quit Game
                """);

        int input = scanner.nextInt();
        scanner.nextLine(); // Vide le buffer après nextInt()

        switch (input) {
            case 1:
                return false;
            case 2:
                System.out.println("WIP");
                return mainMenu();
            case 3:
                return true;
            default:
                System.out.println("Yippee Ki-Yay");
                return mainMenu();
        }
    }

    /**
     * Demande au joueur de choisir un type de personnage.
     *
     * @return le type de personnage saisi ({@code "Dwarf"} ou {@code "Wizard"})
     */
    public String getType() {
        System.out.println("Make choice between Dwarf or Wizard");
        return scanner.nextLine();
    }

    /**
     * Demande au joueur de saisir un nom pour son personnage.
     *
     * @return le nom du personnage saisi par le joueur
     */
    public String getName() {
        System.out.println("Name it");
        return scanner.nextLine();
    }


    public void displayCharacter(String type, String name) {

        System.out.printf("%n>>> %s the %s is ready for adventure !%n", name, type);
    }


}