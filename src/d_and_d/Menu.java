package d_and_d;

import java.util.Scanner;

/**
 * Gère toutes les interactions textuelles avec le joueur.
 * <p>
 * Cette classe est responsable de l'affichage des menus,
 * de la saisie des choix, et de la présentation des personnages.
 * Elle ne contient aucune logique de jeu — elle délègue tout à {@link Game}.
 * </p>
 */
public class Menu {

    private Scanner scanner;

    /**
     * @param scanner le scanner partagé pour lire les entrées clavier
     */
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Affiche le menu principal et redirige vers l'action choisie.
     * En cas de saisie invalide, le menu se réaffiche (appel récursif).
     *
     * @param game l'instance de jeu sur laquelle appeler les actions
     */
    public void displayMenu(Game game) {
        System.out.println("""
                                                             _______________________
                   _______________________-------------------                       `\\
                 /:--__                                                              |
                ||< > |                                   ___________________________/
                | \\__/_________________-------------------                         |
                |                                                                  |
                 |                                MENU                              |
                 |                                                                  |
                 |                            1 - NEW GAME                          |
                  |                           2 - EDIT HERO                          |
                  |                           3 - QUIT GAME                          |
                  |                                                                  |
                  |                                                                  |
                   |                                                                 |
                   |                                                                  |
                   |                                                                 |
                  |                                              ____________________|_
                  |  ___________________-------------------------                      `\\
                  |/`--_                                                                 |
                  ||[ ]||                                            ___________________/
                   \\===/___________________--------------------------
                
               
                """);

        int input = scanner.nextInt();
        scanner.nextLine(); // vide le buffer après nextInt()

        switch (input) {
            case 1:
                game.startNewGame();
                break;
            case 2:
                game.editCharacter();
                break;
            case 3:
                game.quit();
                break;
            default:
                // Saisie invalide : on réaffiche le menu
                displayMenu(game);
        }
    }

    /**
     * Affiche les deux personnages disponibles côte à côte et retourne le choix.
     * En cas de saisie invalide, la méthode se rappelle elle-même.
     *
     * @param game l'instance de jeu (utilisée en cas d'appel récursif)
     * @return false pour Dwarf, true pour Wizard
     */
    public boolean getCharacterChoice(Game game) {

        // ASCII art brut du Nain et du Mage, stockés en String pour être splitté ligne par ligne
        String dwarfRaw =
                "             _.-;-._\n" +
                        "            ;_.JL___; \n" +
                        "            F\"-/\\_-7L\n" +
                        "            | a/ e | \\\n" +
                        "           ,L,c;,.='/;,\n" +
                        "        _,-;;S:;:S;;:' '--._\n" +
                        "       ;. \\;;s:::s;;: .'   /\\\n" +
                        "      /  \\  ;::::;;  /    /  \\\n" +
                        "     / ,  k ;S';;'S.'    j __,l\n" +
                        "  ,---/| /  /S   /S '.   |'   ;\n" +
                        " ,Ljjj |/|.' s .' s   \\  L    |\n" +
                        " LL,_ ]( \\    /    '.  '.||   ;\n" +
                        " |\\ > /  ;-.'_.-.___\\.-'(|==\"(\n" +
                        " JJ,\" /   |_  [   ]     _]|   /\n" +
                        "  LL\\/   ,' '--'-'-----'  \\  ( \n" +
                        "  ||     ;      |          |  >\n" +
                        "  JJ     |      |\\         |,/\n" +
                        "   LL    |      ||       ' | \n" +
                        "   ||    |      ||       . |\n" +
                        "   JJ    /_     ||       ;_|\n" +
                        "    LL   L \"==='|i======='_|\n" +
                        "    ||    i----' '-------';\n" +
                        "    JJ    ';-----.------,-'\n" +
                        "     LL     L_.__J,'---;'\n" +
                        "     ||      |   ,|    (\n" +
                        "     JJ     .'=  (|  ,_|\n" +
                        "      LL   /    .'L_    \\\n" +
                        "      ||   '---'    '.___>";

        String wizardRaw =
                "                                  ....\n" +
                        "                                .'' .'''\n" +
                        ".                             .'   :\n" +
                        "\\\\                          .:    :\n" +
                        " \\\\                        _:    :       ..----.._\n" +
                        "  \\\\                    .:::.....:::.. .'         ''.\n" +
                        "   \\\\                 .'  #-. .-######'     #        '.\n" +
                        "    \\\\                 '.##'/ ' ################       :\n" +
                        "     \\\\                  #####################         :\n" +
                        "      \\\\               ..##.-.#### .''''###'.._        :\n" +
                        "       \\\\             :--:########:            '.    .' :\n" +
                        "        \\\\..__...--.. :--:#######.'   '.         '.     :\n" +
                        "        :     :  : : '':'-:'':'::        .         '.  .'\n" +
                        "        '---'''..: :    ':    '..'''.      '.        :'\n" +
                        "           \\\\  :: : :     '      ''''''.     '.      .:\n" +
                        "            \\\\ ::  : :     '            '.      '      :\n" +
                        "             \\\\::   : :           ....' ..:       '     '.\n" +
                        "              \\\\::  : :    .....####\\\\ .~~.:.             :\n" +
                        "               \\\\':.:.:.:'#########.===. ~ |.'-.   . '''.. :\n" +
                        "                \\\\    .'  ########## \\ \\ _.' '. '-.       '''.\n" +
                        "                :\\\\  :     ########   \\ \\      '.  '-.        :\n" +
                        "               :  \\\\'    '   #### :    \\ \\      :.    '-.      :\n" +
                        "              :  .'\\\\   :'  :     :     \\ \\       :      '-.    :\n" +
                        "             : .'  .\\\\  '  :      :     :\\ \\       :        '.   :\n" +
                        "             ::   :  \\\\'  :.      :     : \\ \\      :          '. :\n" +
                        "             ::. :    \\\\  : :      :    ;  \\ \\     :           '.:\n" +
                        "              : ':    '\\\\ :  :     :     :  \\:\\     :        ..'\n" +
                        "                 :    ' \\\\ :        :     ;  \\|      :   .'''\n" +
                        "                 '.   '  \\\\:                         :.''\n" +
                        "                  .:..... \\\\:       :            ..''\n" +
                        "                 '._____|'.\\\\......'''''''.:..'''\n" +
                        "                            \\\\";

        /* --- Affichage côte à côte : on découpe chaque art en lignes,
               puis on les imprime en colonnes avec printf --- */
        String[] dwarf  = dwarfRaw.split("\n");
        String[] wizard = wizardRaw.split("\n");

        int nbLignes = Math.max(dwarf.length, wizard.length);
        int largeur  = 45; // largeur de la colonne gauche (Nain)

        System.out.println();
        System.out.printf("%-" + largeur + "s    %s%n", "   1 - The Dwarf 🍺", "   2 - The Wizard 🧙");
        System.out.printf("%-" + largeur + "s    %s%n", "   ─────────────────", "   ──────────────────");

        for (int i = 0; i < nbLignes; i++) {
            // Si un art est plus court que l'autre, on complète avec une ligne vide
            String ligneGauche = (i < dwarf.length)  ? dwarf[i]  : "";
            String ligneDroite = (i < wizard.length) ? wizard[i] : "";
            System.out.printf("%-" + largeur + "s    %s%n", ligneGauche, ligneDroite);
        }

        System.out.println("\nYour choice (1 or 2) : ");
        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1: return false;  // Dwarf
            case 2: return true;   // Wizard
            default: return getCharacterChoice(game); // saisie invalide → on recommence
        }
    }

    /**
     * Demande et retourne le nom saisi par le joueur.
     *
     * @return le nom du héros
     */
    public String getName() {
        System.out.println("Name it");
        return scanner.nextLine();
    }

    /**
     * Demande et retourne l'ID du héros à modifier.
     *
     * @return l'identifiant BDD du héros
     */
    public int getHeroId() {
        System.out.println("Enter the ID of the hero to edit :");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    /**
     * Affiche la fiche récapitulative du personnage créé, puis une pause visuelle.
     *
     * @param type   le type du personnage ("Dwarf" ou "Wizard")
     * @param name   le nom du personnage
     * @param attack les points d'attaque
     * @param hp     les points de vie
     */
    public void displayCharacter(String type, String name, int attack, int hp) {
        // %n → retour à la ligne portable, %s → placeholder String
        System.out.printf("%n>>> %s the %s is ready for adventure !%n", name, type);
        System.out.println(name + " => a " + type + " with attack " + attack + "\uD83D\uDDE1\uFE0F" + " and hp " + hp + "❤\uFE0F ");

        // Pause visuelle avant de lancer la partie
        System.out.println("""
                .
                .
                .
                .
                """);
    }

}