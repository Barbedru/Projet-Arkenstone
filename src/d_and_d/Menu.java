package d_and_d;

import java.util.Scanner;


public class Menu {
    private Scanner scanner;


    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }



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
        scanner.nextLine();

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
                displayMenu(game);
        }
    }


    public boolean getCharacterChoice(Game game) {

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
                        " ||\\ > /  ;-.'_.-.___\\.-'(|==\"(\n" +
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

        // Split sur les \n → on obtient un vrai String[] ligne par ligne
        String[] dwarf  = dwarfRaw.split("\n");
        String[] wizard = wizardRaw.split("\n");

        int nbLignes = Math.max(dwarf.length, wizard.length);
        int largeur  = 45; // ajuste selon la largeur max du nain

        System.out.println();
        System.out.printf("%-" + largeur + "s    %s%n", "   1 - The Dwarf 🍺", "   2 - The Wizard 🧙");
        System.out.printf("%-" + largeur + "s    %s%n", "   ─────────────────", "   ──────────────────");

        for (int i = 0; i < nbLignes; i++) {
            String ligneGauche = (i < dwarf.length)  ? dwarf[i]  : "";
            String ligneDroite = (i < wizard.length) ? wizard[i] : "";
            System.out.printf("%-" + largeur + "s    %s%n", ligneGauche, ligneDroite);
        }

        System.out.println("\nYour choice (1 or 2) : ");
        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1: return false;
            case 2: return true;
            default: return getCharacterChoice(game);
        }
    }


    public String getName() {
        System.out.println("Name it");
        return scanner.nextLine();

    }


    public int getHeroId() {
        System.out.println("Enter the ID of the hero to edit :");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }



    public void displayCharacter(String type, String name, int attack, int hp) {

        //printf → Permet d’afficher du texte formaté.
//        %n → Retour à la ligne (portable entre systèmes).
//        %s → Placeholder pour une chaîne de caractères.
        System.out.printf("%n>>> %s the %s is ready for adventure !%n", name, type);
        //Premier %s → name
        //Deuxième %s → type
        System.out.println(name + " => a " + type + " with attack " + attack + "\uD83D\uDDE1\uFE0F" + " and hp " + hp + "❤\uFE0F " );
        System.out.println("""
                .
                .
                .
                .
                """);
    }


}