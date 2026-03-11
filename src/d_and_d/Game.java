package d_and_d;

import d_and_d.board.Board;
import d_and_d.character.Character;
import d_and_d.character.heros.Dwarf;
import d_and_d.character.heros.Wizard;
import d_and_d.db.DatabaseConnection;

import java.util.Scanner;


public class Game {

    private Menu menu;
    private Dice dice;
    private Board board;
    private Character character;
    private Scanner scanner;
    private DatabaseConnection db;




    public Game(Menu menu, Dice dice, Scanner scanner) {
        this.menu = menu;
        this.dice = dice;
        this.scanner = scanner;
        this.db = new DatabaseConnection();
    }

    public void loop() {
        System.out.println(character.getName() + " => a " + character.getType() + " with attack " +
                            character.getAttack() + "🗡️" + " and hp " + character.getHp() + "❤️ ");
        board.print();
        int roll = dice.roll(6);
        board.moveCharacter(roll, character);
        this.scanner.nextLine();
    }



    public void startGame() {
        while (!menu.displayMenu(this)) {

            Boolean isWizard = menu.getCharacterChoice(this);
            String type = isWizard ? "Wizard" : "Dwarf";

            String name = menu.getName();

            initGame(type, name);
            db.createHero(character);
            menu.displayCharacter(type, character.getName(), character.getAttack(), character.getHp());


            while (!checkWin()) {
                loop();
            }

            System.out.println("You defeated Smaug and found the Arkenstone !");
            System.out.println("Your are the King under the mountain !");
        }
    }




    public void initGame(String type, String name) {


        if (type.equals("Dwarf")) {
            character = new Dwarf(name, 5, 10);
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
                    "     ||   '---'    '.___>\n");
        } else if (type.equals("Wizard")) {
            character = new Wizard(name, 8, 6);
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
                    "                 '.   '  \\\\:                         :.''\n" +
                    "                  .:..... \\\\:       :            ..''\n" +
                    "                 '._____|'.\\\\......'''''''.:..'''\n" +
                    "                            \\\\\n");
        }

        //Création plateau
        board = new Board();

    }



    public void editCharacter() {
        db.getHeroes();
        int id = menu.getHeroId();
        Boolean isWizard = menu.getCharacterChoice(this);
        String type = isWizard ? "Wizard" : "Dwarf";
        String name = menu.getName();
        initGame(type, name);
        db.editHero(id, character);

    }



    public boolean checkWin() {
        return board.getPlayerPosition() == 63;
    }
}