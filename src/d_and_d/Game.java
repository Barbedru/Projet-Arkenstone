package d_and_d;

import d_and_d.character.Dwarf;
import d_and_d.character.Character;
import d_and_d.character.Wizard;

import java.util.Scanner;


public class Game {
    private Menu menu;
    private Dice dice;
    private Board board;
    private Character character;
    private Scanner scanner;

    public Game (Menu menu, Dice dice, Scanner scanner) {
        this.menu = menu;
        this.dice= dice;
        this.scanner = scanner;
    }

    public void startGame() {
        while (!menu.mainMenu()) {
            String type = menu.getType();
            String name = menu.getName();
            initGame(type, name);
            while (!checkWin()) {
                loop();
            }
            board.print();
            System.out.println("On a gagné !");

        }
    }

    public void initGame(String type, String name) {
        board = new Board(64);
        if(type.equals("Warrior")) {
            character = new Dwarf(name);
        } else {
            character = new Wizard(name);
        }
        board.setTile(0, character);
    }

    public void loop() {
        board.print();
        int roll = dice.roll(6);
        board.moveCharacter(roll);
        this.scanner.nextLine();
    }

    public boolean checkWin() {
        return board.getTile(63) == character;
    }


}



