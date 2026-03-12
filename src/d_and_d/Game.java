package d_and_d;

import d_and_d.board.Board;
import d_and_d.character.Character;
import d_and_d.character.heros.Dwarf;
import d_and_d.character.heros.Wizard;
import d_and_d.db.DatabaseConnection;

import java.util.Scanner;

/**
 * Contrôleur principal du jeu Arkenstone.
 * <p>
 * Orchestre le déroulement d'une partie : création du personnage,
 * initialisation du plateau, boucle de jeu et condition de victoire.
 * C'est ici que toutes les classes se connectent entre elles.
 * </p>
 */
public class Game {

    private Menu menu;
    private Dice dice;
    private Board board;
    private Character character;  // le héros choisi par le joueur
    private Scanner scanner;
    private DatabaseConnection db;

    /**
     * Construit une instance de Game avec ses dépendances.
     *
     * @param menu    le menu qui gère les interactions avec le joueur
     * @param dice    le dé utilisé pour les déplacements
     * @param scanner le scanner partagé pour lire les entrées clavier
     */
    public Game(Menu menu, Dice dice, Scanner scanner) {
        this.menu = menu;
        this.dice = dice;
        this.scanner = scanner;
        this.db = new DatabaseConnection();
    }

    /**
     * Point d'entrée du jeu : affiche le menu principal.
     * Le menu redirige ensuite vers startNewGame(), editCharacter() ou quit().
     */
    public void startGame() {
        menu.displayMenu(this);
    }

    /**
     * Exécute un tour de jeu complet :
     * affiche l'état du héros, affiche le plateau, lance le dé,
     * déplace le personnage, puis attend que le joueur appuie sur Entrée.
     */
    public void loop() {
        // Affichage de l'état courant du héros
        System.out.println(character.getName() + " => a " + character.getType() + " with attack " +
                character.getAttack() + "🗡️" + " and hp " + character.getHp() + "❤️ ");
        System.out.println("Dice value: " + dice.roll(6));

        board.print();

        // roll(6) → le dé donne une valeur random entre 1 et 6
        int roll = dice.roll(6);
        board.moveCharacter(roll, character);

        // Pause : le joueur appuie sur Entrée pour continuer
        this.scanner.nextLine();
    }

    /**
     * Lance une nouvelle partie :
     * choix du personnage, saisie du nom, initialisation, sauvegarde en BDD,
     * puis boucle jusqu'à la victoire.
     */
    public void startNewGame() {

        /* --- Choix et création du personnage --- */
        boolean isWizard = menu.getCharacterChoice(this);
        String type = isWizard ? "Wizard" : "Dwarf";
        String name = menu.getName();

        initGame(type, name);

        // Sauvegarde du héros en base de données dès le début de la partie
        db.createHero(character);
        menu.displayCharacter(type, character.getName(), character.getAttack(), character.getHp());

        /* --- Boucle principale : tourne jusqu'à ce que le joueur atteigne la case 63 --- */
        while (!checkWin()) {
            loop();
        }

        System.out.println("You defeated Smaug and found the Arkenstone !");
        System.out.println("Your are the King under the mountain !");
    }

    /**
     * Initialise le personnage et le plateau selon le type choisi.
     * Affiche l'ASCII art du personnage sélectionné.
     *
     * @param type le type de héros ("Dwarf" ou "Wizard")
     * @param name le nom saisi par le joueur
     */
    public void initGame(String type, String name) {

        /* --- Création du personnage selon le type choisi --- */
        if (type.equals("Dwarf")) {
            character = new Dwarf(name, 5, 10); // Nain : peu d'attaque, robuste
            System.out.println("             _.-;-._\n" +
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
                    "     ||   '---'    '.___>\n");

        } else if (type.equals("Wizard")) {
            character = new Wizard(name, 8, 6); // Mage : puissant mais fragile
            System.out.println("                                  ....\n" +
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
                    "                 '.   '  \\\\:                         :.'' \n" +
                    "                  .:..... \\\\:       :            ..''\n" +
                    "                 '._____|'.\\\\......'''''''.:..'''\n" +
                    "                            \\\\\n");
        }

        /* --- Création du plateau de jeu --- */
        board = new Board();
    }

    /**
     * Permet de modifier un héros existant en base de données.
     * Affiche la liste des héros, demande l'ID à modifier,
     * puis réinitialise le jeu avec le nouveau personnage.
     */
    public void editCharacter() {
        db.getHeroes(); // affiche la liste pour que le joueur choisisse un ID
        int id = menu.getHeroId();
        boolean isWizard = menu.getCharacterChoice(this);
        String type = isWizard ? "Wizard" : "Dwarf";
        String name = menu.getName();
        initGame(type, name);
        db.editHero(id, character); // met à jour le héros en BDD
    }

    /**
     * Vérifie si le joueur a atteint la dernière case du plateau (index 63).
     *
     * @return true si le joueur est en position 63, false sinon
     */
    public boolean checkWin() {
        return board.getPlayerPosition() == 63; // index 63 = dernière case (64ème)
    }

    /**
     * Quitte proprement le jeu en fermant le scanner et en arrêtant la JVM.
     */
    public void quit() {
        System.out.println("Goodbye !");
        scanner.close();
        System.exit(0);
    }
}