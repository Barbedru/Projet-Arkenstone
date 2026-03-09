package d_and_d;

import java.sql.SQLException;
import java.util.Scanner;
import d_and_d.db.DatabaseConnection;

public class Main {



    public static void main(String[] args) throws SQLException {
            Scanner scanner = new Scanner (System.in);

            Game game = new Game(new Menu(scanner), new Dice(), scanner);
            game.startGame();

            DatabaseConnection db = new DatabaseConnection();
            db.getHeroes();

        }

    }
