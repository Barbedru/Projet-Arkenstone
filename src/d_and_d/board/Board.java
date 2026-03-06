package d_and_d.board;

import d_and_d.character.Character;
import java.util.ArrayList;



public class Board {

    private ArrayList<Cell> board;
    private int playerPosition;

    public Board() {
        board = new ArrayList<>();

        //position initiale du Joueur
        playerPosition = -1;


        board.add(new EmptyCell(1));
        board.add(new EnemyCell(2));
        board.add(new WeaponCell(3));
        board.add(new PotionCell(4));

        board.add(new EmptyCell(5));
        board.add(new EmptyCell(6));
        board.add(new EmptyCell(7));
        board.add(new EmptyCell(8));
        board.add(new EmptyCell(9));
        board.add(new EmptyCell(10));
        board.add(new EmptyCell(11));
        board.add(new EmptyCell(12));
        board.add(new EmptyCell(13));
        board.add(new EmptyCell(14));
        board.add(new EmptyCell(15));
        board.add(new EmptyCell(16));
        board.add(new EmptyCell(17));
        board.add(new EmptyCell(18));
        board.add(new EmptyCell(19));
        board.add(new EmptyCell(20));
        board.add(new EmptyCell(21));
        board.add(new EmptyCell(22));
        board.add(new EmptyCell(23));
        board.add(new EmptyCell(24));

        board.add(new EmptyCell(25));
        board.add(new EmptyCell(26));
        board.add(new EmptyCell(27));
        board.add(new EmptyCell(28));
        board.add(new EmptyCell(29));
        board.add(new EmptyCell(30));
        board.add(new EmptyCell(31));
        board.add(new EmptyCell(32));

        board.add(new EmptyCell(33));
        board.add(new EmptyCell(34));
        board.add(new EmptyCell(35));
        board.add(new EmptyCell(36));
        board.add(new EmptyCell(37));
        board.add(new EmptyCell(38));
        board.add(new EmptyCell(39));
        board.add(new EmptyCell(40));

        board.add(new EmptyCell(41));
        board.add(new EmptyCell(42));
        board.add(new EmptyCell(43));
        board.add(new EmptyCell(44));
        board.add(new EmptyCell(45));
        board.add(new EmptyCell(46));
        board.add(new EmptyCell(47));
        board.add(new EmptyCell(48));
        board.add(new EmptyCell(49));
        board.add(new EmptyCell(50));
        board.add(new EmptyCell(51));
        board.add(new EmptyCell(52));
        board.add(new EmptyCell(53));
        board.add(new EmptyCell(54));
        board.add(new EmptyCell(55));
        board.add(new EmptyCell(56));

        board.add(new EmptyCell(57));
        board.add(new EmptyCell(58));
        board.add(new EmptyCell(59));
        board.add(new EmptyCell(60));
        board.add(new EmptyCell(61));
        board.add(new EmptyCell(62));
        board.add(new EmptyCell(63));
        board.add(new EmptyCell(64));

    }


    //Méthode moveCharacter
    public void moveCharacter(int move, Character character) {

        playerPosition += move;

        if (playerPosition >= board.size()) {
            playerPosition = board.size() - 1;
        }

        Cell currentCell = board.get(playerPosition);

        currentCell.action(character);
    }


    public int getPlayerPosition() {
        return playerPosition;

    }

    public void print() {
        for (int i = -1; i < board.size(); i++) {
            if (i == playerPosition) {
                System.out.print("\uD83C\uDF7A"); // affiche le joueur
            } else {
                System.out.print(".");// affiche les cases
            }
        }
        System.out.println();
    }


}