package d_and_d;

import d_and_d.board.Board;
import d_and_d.character.Dwarf;
import d_and_d.character.Character;
import d_and_d.character.Wizard;

import java.util.Scanner;


public class Game {


    private Menu menu;

    private Dice dice;

    private Board Board;

    private Character character;

    private Scanner scanner;




    public Game(Menu menu, Dice dice, Scanner scanner) {
        this.menu = menu;
        this.dice = dice;
        this.scanner = scanner;
    }




    public void startGame() {
        while (!menu.displayMenu()) {
            String type = menu.getCharacterChoice();
            String name = menu.getName();
            menu.displayCharacter(type, name);

            initGame(type, name);

            while (!checkWin()) {
                loop();
            }

            Board.print();
            System.out.println("Your found the Arkenstone !");
            System.out.println("Your are the King under the mountain !");
        }
    }




    public void initGame(String type, String name) {
        Board = new Board();

        if (type.equals("Dwarf")) {
            character = new Dwarf(name, 5, 10);
        } else if (type.equals("Wizard")) {
            character = new Wizard(name, 8, 6);
        }

    }


    public void loop() {
        Board.print();
        int roll = dice.roll(1);
        Board.moveCharacter(roll);
        this.scanner.nextLine();
    }



    public boolean checkWin() {
        return Board.getPlayerPosition() == 63;
    }
}