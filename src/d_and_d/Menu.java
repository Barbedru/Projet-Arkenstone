package d_and_d;

import java.util.Scanner;


public class Menu {
    private Scanner scanner;


    public Menu(Scanner scanner) {

        this.scanner = scanner;
    }



    public boolean displayMenu(Game game) {
        System.out.println("""        
                MAIN MENU
                ---------
                1 - New Game
                2 - Edit Hero
                3 - Quit Game
                """);

        int input = scanner.nextInt();
       scanner.nextLine();

        switch (input) {
            case 1:
                return false;
            case 2:
                game.editCharacter();  // ← on appelle la méthode de Game
                return displayMenu(game);
            case 3:
                return true;
            default:
                return displayMenu(game);
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


    public int getHeroId() {
        System.out.println("Enter the ID of the hero to edit :");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
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


