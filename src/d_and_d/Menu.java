package d_and_d;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }


    public boolean mainMenu() {
        System.out.println("""        
                MAIN MENU
                ---------
                1 - New Game
                2 - Edit character
                3 - Quit Game
                """);

        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1:
                return false;
            case 2:
                System.out.println("WIP");
                return mainMenu();
            case 3:
                return true;
            default:
                System.out.println("Yippee Ki-Yay");
                return mainMenu();
        }
    }

        public String getType() {
            System.out.println("Make choice between Dwarf or Wizard");
            return scanner.nextLine();
        }

        public String getName () {
            System.out.println("Name it");
            return scanner.nextLine();
        }
    }










