package d_and_d.board;

import d_and_d.character.Character;
import d_and_d.character.villains.DarkWizard;
import d_and_d.character.villains.Dragon;
import d_and_d.character.villains.Gobelin;
import d_and_d.character.villains.Smaug;


//Case Ennemi
public class EnemyCell extends Cell {

    private Character villains;

    public EnemyCell(int position) {
        super(position);
        posVillain(position);

    }


    private void posVillain(int position) {
        switch (position) {
            case 3: case 6: case 9: case 12: case 15: case 18: case 21: case 24: case 27: case 30:
                villains = new Gobelin("Gobelin",1,6,null );
                break;
            case 10: case 20: case 25: case 32: case 35: case 36: case 37: case 40: case 44: case 47:
                villains = new DarkWizard("DarkWizard","DarkWizard",2,9, null );
                break;
            case 45: case 52: case 56: case 62:
                villains = new Dragon("Drake",4,15);
                break;
            case 64:
                villains = new Smaug("Smaug",8,25);
        }


    }

    @Override
    public void interact(Character character) {
        super.interact(character); // affiche les infos de base

        if (villains instanceof Gobelin) {
            System.out.println("A Goblin appears \uD83D\uDC79  Prepare for battle !  ⚔\uFE0F ");
        } else if (villains instanceof DarkWizard) {
            System.out.println("A Dark Wizard appears  \uD83E\uDDD9\uD83C\uDFFF  He's preparing a spell!  ✨ ");
        } else if (villains instanceof Dragon) {
            System.out.println("A Drake appears \uD83D\uDC32 He's rushing towards you !");
        } else if (villains instanceof Smaug) {
            System.out.println(" The ground trembles... an incandescent light suddenly appears before you!");
            System.out.println("\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25 " +
                    "SMAUG THE TERRIBLE" +
                    " \uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83D\uDD25");
            System.out.println(" My armor is worth ten shields, my fangs are swords, my claws are spears," +
                    " the strike of my tail is like lightning, my wings are like a hurricane, and my breath is deadly!");
        }

    }

}
