package game;

import menu.Menu;
import characters.Character;
import characters.OffensiveEquipment;
import characters.DefensiveEquipment;
import java.awt.*;

public class Game {

    private Menu menu = new Menu();

    public void startGame(){

        int choiceMenu = menu.mainMenu();

        if (choiceMenu == 1){
            choiceCharacter();
        }else {
            System.out.println(" See you soon :'( ");
        }

    }

    private String choiceCharacter() {

        String choiceHero = menu.choiceCharacterType();

        if (choiceHero.equals("Dwarf")) {
            System.out.println("You choose the Dwarf!");
            nameHero(choiceHero);
        } else if (choiceHero.equals("Wizard")) {
            System.out.println("You choose the Wizard!");
            nameHero(choiceHero);
        } else {
            System.out.println("Error ! Enter Dwarf or Wizard");
            choiceCharacter();
        }
        return choiceHero;
    }

    public void nameHero(String choiceHero){

        String heroName = menu.nameChoice();

        if (choiceHero.equals("Dwarf")) {
            System.out.println("Your Hero is named " + heroName + " and its characteristics are: " + dwarf);
        } else if (choiceHero.equals("Wizard")) {
            System.out.println("Your Hero is named " + heroName + " and its characteristics are: " + wizard);
        }


    }












//---------------  CHARACTERS ---------------//
//HERO
Character dwarf = new Character("Dwarf", " ", 5,10 );


Character wizard = new Character("Wizard", " ", 8, 6);

//VILLAIN
Character gobelin = new Character("Gobelin", "Gobelin", 1, 6);

Character smaug = new Character("Smaug", "Smaug", 4,15);


//---------------  OFFENSIVE STUFF ---------------//
//WEAPONS
OffensiveEquipment axe = new OffensiveEquipment("Weapon", "Axe",5);

OffensiveEquipment sword = new OffensiveEquipment("Weapon", "Sword",3);

//SPELLS
OffensiveEquipment fireBall = new OffensiveEquipment("Spell", "FireBall",7);

OffensiveEquipment lightning = new OffensiveEquipment("Spell", "",2);


//---------------  DEFENSIVE STUFF ---------------//
//POTION
DefensiveEquipment potion = new DefensiveEquipment("Potion", "Potion",2);

DefensiveEquipment great_potion = new DefensiveEquipment("Potion", "Great potion", 5);

DefensiveEquipment shield = new DefensiveEquipment("Shield", "Wooden shield",3);



}


