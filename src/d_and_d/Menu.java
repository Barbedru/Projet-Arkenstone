package d_and_d;
// Définit le package dans lequel se trouve la classe.

import java.util.Scanner;
// Importe la classe Scanner pour lire les entrées clavier.

public class Menu {

    private Scanner scanner;
    // Déclaration d’un attribut Scanner pour lire les entrées utilisateur.

    public Menu(Scanner scanner) {
        this.scanner = scanner;
        // Constructeur : permet d’initialiser le scanner
        // en le recevant depuis l’extérieur.
    }


    public boolean mainMenu() {
        // Méthode qui affiche le menu principal.
        // Retourne un boolean :
        // - false = continuer le jeu
        // - true = quitter le jeu
        System.out.println("""        
                MAIN MENU
                ---------
                1 - New Game
                2 - Edit character
                3 - Quit Game
                """);

        int input = scanner.nextInt();
        // Lit un entier entré par l'utilisateur.
        scanner.nextLine();
        // Vide le buffer pour éviter les problèmes de lecture
        // lors d’un prochain nextLine().

        switch (input) {
            case 1:
                return false;
            // Si l'utilisateur choisit 1 → lancer une nouvelle partie
            // On retourne false pour continuer le programme.
            case 2:
                System.out.println("WIP");
                return mainMenu();
            // Rappelle la méthode pour réafficher le menu.
            case 3:
                return true;
            // Quitter le jeu (on retourne true).
            default:
                System.out.println("Yippee Ki-Yay");
                return mainMenu();
            // On relance le menu.
        }
    }

        public String getType() {
            // Demande à l'utilisateur de choisir un type de personnage.
            System.out.println("Make choice between Dwarf or Wizard");
            return scanner.nextLine();
            // Retourne la chaîne entrée par l'utilisateur.
        }

        public String getName () {
            System.out.println("Name it");
            // Demande à l'utilisateur de donner un nom au personnage.
            return scanner.nextLine();
            // Retourne le nom entré.
        }
    }










