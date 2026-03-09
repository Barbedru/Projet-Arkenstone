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
        board.print();
        int roll = dice.roll(1);
        board.moveCharacter(roll, character);
        this.scanner.nextLine();
    }



    public void startGame() {
        while (!menu.displayMenu(this)) {

            String type = menu.getCharacterChoice();
            String name = menu.getName();

            initGame(type, name);
            db.createHero(character);


            menu.displayCharacter(type, name, character.getAttack(), character.getHp());


            while (!checkWin()) {
                loop();
            }

            System.out.println("Your found the Arkenstone !");
            System.out.println("Your are the King under the mountain !");
        }
    }




    public void initGame(String type, String name) {


        if (type.equals("Dwarf")) {
            character = new Dwarf(name, 5, 10);
        } else if (type.equals("Wizard")) {
            character = new Wizard(name, 8, 6);
        }

        //Création plateau
        board = new Board();

    }

    public void fight(){

    }

    public void editCharacter() {
        db.getHeroes();
        int id = menu.getHeroId();
        String type = menu.getCharacterChoice();
        String name = menu.getName();
        initGame(type, name);
        db.editHero(id, character);

    }





    public boolean checkWin() {
        return board.getPlayerPosition() == 63;
    }
}