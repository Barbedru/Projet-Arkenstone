package menu;

import java.util.Scanner;

public class Menu {



    private Scanner scanner = new Scanner(System.in);


    //MENU PRINCIPAL

    public int mainMenu(){
        System.out.println("MAIN MENU");
        System.out.println("---------------");
        System.out.println("1. New Game");
        System.out.println("2. Quit Game");
        System.out.println("Select 1 or 2 : ");
        return scanner.nextInt();
    }

    public String choiceCharacterType(){
        System.out.println("Character Choice");
        System.out.println("Dwarf or Wizard");
        return scanner.next();
    }

    public String nameChoice(){
        System.out.println("Enter the character's name : ");
        return scanner.next();
    }


}






