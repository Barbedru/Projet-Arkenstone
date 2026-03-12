package d_and_d.board;

import d_and_d.Color;
import d_and_d.character.Character;
import d_and_d.equipment.*;

/**
 * Case Arme : contient une arme offensive que le héros peut ramasser.
 * L'Épée est l'arme de base, la Hache de Guerre est plus puissante
 * et apparaît en milieu/fin de plateau.
 */
public class WeaponCell extends Cell {

    private OffensiveEquipment weapons; // l'arme contenue dans cette case

    public WeaponCell(int position) {
        super(position);
        posWeapon(position);
    }

    /**
     * Assigne le type d'arme selon la position de la case.
     *
     * @param position la position de la case
     */
    private void posWeapon(int position) {
        switch (position) {
            case 2: case 5: case 11: case 22: case 38:
                weapons = new Sword("Sword", 3);    // épée standard
                break;
            case 19: case 26: case 42: case 53:
                weapons = new WarAxe("WarAxe", 5);  // hache de guerre, plus puissante
                break;
        }
    }

    @Override
    public void interact(Character character) {
        super.interact(character);

        if (weapons instanceof Sword) {
            System.out.println("Cell " + position + " — There's something here ");
            System.out.println("   .\n" +
                    "  / \\\n" +
                    "  | |\n" +
                    "  | |\n" +
                    "  |.|\n" +
                    "  |.|\n" +
                    "  |:|\n" +
                    "  |:|\n" +
                    "`--8--'\n" +
                    "   8\n" +
                    "   O\n");
            System.out.println(character.getName() + " found Sword ! ");

        } else if (weapons instanceof WarAxe) {
            System.out.println("Cell " + position + " — There's something here ");
            System.out.println(Color.SILVER_BRIGHT + "  ,:\\      /:\n" +
                    " //  \\_()_/  \\\\\n" +
                    "||   |    |   ||\n" +
                    "||   |    |   ||\n" +
                    "||   |____|   ||\n" +
                    " \\\\  / || \\  //\n" +
                    "  `:/  ||  \\;'\n" +
                    "       ||\n" +
                    "       ||\n" +
                    "       XX\n" +
                    "       XX\n" +
                    "       XX\n" +
                    "       XX\n" +
                    "       OO\n" +
                    "       `'\n" + Color.RESET);
            System.out.println(character.getName() + " found WarAxe ! ");
        }
    }
}