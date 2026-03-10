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



        board.add(new SpellCell(1));
        board.add(new WeaponCell(2));
        board.add(new EnemyCell(3));
        board.add(new SpellCell(4));
        board.add(new WeaponCell(5));
        board.add(new EnemyCell(6));
        board.add(new PotionCell(7));
        board.add(new SpellCell(8));
        board.add(new EnemyCell(9));
        board.add(new EnemyCell(10));


        board.add(new WeaponCell(11));
        board.add(new EnemyCell(12));
        board.add(new PotionCell(13));
        board.add(new EmptyCell(14));
        board.add(new EnemyCell(15));
        board.add(new EmptyCell(16));
        board.add(new SpellCell(17));
        board.add(new EnemyCell(18));
        board.add(new WeaponCell(19));
        board.add(new EnemyCell(20));

        board.add(new EnemyCell(21));
        board.add(new WeaponCell(22));
        board.add(new SpellCell(23));
        board.add(new EnemyCell(24));
        board.add(new EnemyCell(25));
        board.add(new WeaponCell(26));
        board.add(new EnemyCell(27));
        board.add(new PotionCell(28));
        board.add(new EmptyCell(29));
        board.add(new EnemyCell(30));

        board.add(new PotionCell(31));
        board.add(new EnemyCell(32));
        board.add(new PotionCell(33));
        board.add(new EmptyCell(34));
        board.add(new EnemyCell(35));
        board.add(new EnemyCell(36));
        board.add(new EnemyCell(37));
        board.add(new WeaponCell(38));
        board.add(new PotionCell(39));
        board.add(new EnemyCell(40));

        board.add(new PotionCell(41));
        board.add(new WeaponCell(42));
        board.add(new PotionCell(43));
        board.add(new EnemyCell(44));
        board.add(new EnemyCell(45));
        board.add(new EmptyCell(46));
        board.add(new EnemyCell(47));
        board.add(new SpellCell(48));
        board.add(new SpellCell(49));
        board.add(new EmptyCell(50));

        board.add(new EmptyCell(51));
        board.add(new EnemyCell(52));
        board.add(new WeaponCell(53));
        board.add(new EmptyCell(54));
        board.add(new EmptyCell(55));
        board.add(new EnemyCell(56));
        board.add(new EmptyCell(57));
        board.add(new EmptyCell(58));
        board.add(new EmptyCell(59));
        board.add(new EmptyCell(60));

        board.add(new EmptyCell(61));
        board.add(new EnemyCell(62));
        board.add(new EmptyCell(63));
        board.add(new EnemyCell(64));

    }


    //Méthode moveCharacter
    public void moveCharacter(int move, Character character) {

        playerPosition = playerPosition + move;

        if (playerPosition >= board.size()) {
            playerPosition = board.size() - 1;
        }

        Cell currentCell = board.get(playerPosition);

        currentCell.interact(character);
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