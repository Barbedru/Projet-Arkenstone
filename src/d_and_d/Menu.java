package d_and_d;

import d_and_d.equipment.OffensiveEquipment;

import java.util.Calendar;
import java.util.Scanner;


public class Menu {
    private Scanner scanner;


    public Menu(Scanner scanner) {

        this.scanner = scanner;
    }



    public boolean displayMenu() {
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
                return displayMenu();
            case 3:
                return true;
            default:
                System.out.println("Yippee Ki-Yay");
                return displayMenu();
        }
    }


    public String getCharacterChoice() {
        System.out.println("""
                Make choice between : 
                The Dwarf \uD83C\uDF7A  
                The Wizard \uD83E\uDDD9\u200D♂\uFE0F
                """);
        return scanner.nextLine();
    }


    public String getName() {
        System.out.println("Name it");
        return scanner.nextLine();
    }



    public void displayCharacter(String type, String name, int attack, int hp) {

        //printf → Permet d’afficher du texte formaté.
//        %n → Retour à la ligne (portable entre systèmes).
//        %s → Placeholder pour une chaîne de caractères.
        System.out.printf("%n>>> %s the %s is ready for adventure !%n", name, type);
        //Premier %s → name
       //Deuxième %s → type
        System.out.println(name + " => a " + type + " with attack " + attack + "\uD83D\uDDE1\uFE0F" + ", and hp " + hp + "❤\uFE0F " );
    }


    }


