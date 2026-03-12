package d_and_d.board;

import d_and_d.Color;
import d_and_d.character.Character;
import d_and_d.character.villains.DarkWizard;
import d_and_d.character.villains.Dragon;
import d_and_d.character.villains.Gobelin;
import d_and_d.character.villains.Smaug;

/**
 * Case Ennemi : contient un villain dont le type dépend de la position sur le plateau.
 * <p>
 * Les ennemis sont répartis par difficulté croissante :
 * Gobelin (début), DarkWizard (milieu), Dragon (fin), Smaug (boss final case 64).
 * </p>
 */
public class EnemyCell extends Cell {

    private Character villains; // l'ennemi qui occupe cette case

    /**
     * Construit la case et assigne automatiquement le bon ennemi selon la position.
     *
     * @param position la position de la case sur le plateau
     */
    public EnemyCell(int position) {
        super(position);
        posVillain(position); // détermine quel ennemi placer ici
    }

    /**
     * Assigne l'ennemi approprié selon la position de la case.
     * Les positions sont fixes et définissent la progression de difficulté.
     *
     * @param position la position de la case
     */
    private void posVillain(int position) {
        switch (position) {
            // Gobelins : premières cases, ennemi faible pour débuter
            case 3: case 6: case 9: case 12: case 15: case 18: case 21: case 24: case 27: case 30:
                villains = new Gobelin("Gobelin", 1, 6, null);
                break;
            // Mages Noirs : milieu de parcours, plus résistants
            case 10: case 20: case 25: case 32: case 35: case 36: case 37: case 40: case 44: case 47:
                villains = new DarkWizard("DarkWizard", "DarkWizard", 2, 9, null);
                break;
            // Dragons : fin de parcours, ennemis puissants
            case 45: case 52: case 56: case 62:
                villains = new Dragon("Drake", 4, 15);
                break;
            // Smaug : boss final, dernière case
            case 64:
                villains = new Smaug("Smaug", 8, 25);
        }
    }

    /**
     * Affiche l'ASCII art coloré de l'ennemi et un message d'apparition.
     *
     * @param character le héros qui arrive sur la case
     */
    @Override
    public void interact(Character character) {
        super.interact(character);

        if (villains instanceof Gobelin) {
            System.out.println(Color.RED + "          .    .\n" +
                    "          |\\   |\\\n" +
                    "       _..;|;__;|;\n" +
                    "     ,'   ';` \\';`-.\n" +
                    "     7;-..     :   )\n" +
                    ".--._)|   `;==,|,=='\n" +
                    " `\\`@; \\_ `<`G,\" G).\n" +
                    "   `\\/-;,(  )  .>. )\n" +
                    "       < ,-;'-.__.;'\n" +
                    "        `\\_ `-,__,'\n" +
                    "           `-..,;,>\n" +
                    "              `;;;;\n" +
                    "               `  `\n" + Color.RESET);
            System.out.println("Cell " + position + " — A Goblin appears !  Prepare for battle !  ⚔\uFE0F ");
            System.out.println();

        } else if (villains instanceof DarkWizard) {
            System.out.println(Color.PURPLE +
                    "  .||,       /_ _\\\\     \n" +
                    " \\.`',/      |'L'| |    \n" +
                    " = ,. =      | -,| L    \n" +
                    " / || \\    ,-'\\\"/,'`.   \n" +
                    "   ||     ,'   `,,. `.  \n" +
                    "   ,|____,' , ,;' \\| |  \n" +
                    "  (3|\\    _/|/'   _| |  \n" +
                    "   ||/,-''  | >-'' _,\\\\ \n" +
                    "   ||'      ==\\ ,-'  ,' \n" +
                    "   ||       |  V \\ ,|   \n" +
                    "   ||       |    |` |   \n" +
                    "   ||       |    |   \\  \n" +
                    "   ||       |    \\    \\ \n" +
                    "   ||       |     |    \\\n" +
                    "   ||       |      \\_,-'\n" +
                    "   ||       |___,,--\")_\\\n" +
                    "   ||         |_|   ccc/\n" +
                    "   ||        ccc/       \n" +
                    "   ||                   \n" + Color.RESET);
            System.out.println("Cell " + position + " — A Dark Wizard appears ! He's preparing a spell!  ✨ ");

        } else if (villains instanceof Dragon) {
            System.out.println(Color.GREEN + "      . \n" +
                    " .>   )\\;`a__\n" +
                    "(  _ _)/ /-. ~~\n" +
                    " `( )_ )/\n" +
                    "  <_  <_       \n" + Color.RESET);
            System.out.println("Cell " + position + " — A Drake appears ! He's rushing towards you !");

        } else if (villains instanceof Smaug) {
            /* --- Séquence d'apparition dramatique de Smaug --- */
            System.out.println(" The ground is shaking... ");
            System.out.println(" ..........................");
            System.out.println(" ..........................");
            System.out.println(" ..........................");
            System.out.println(" An incandescent light suddenly appears before you!!!!!!");
            System.out.println(
                    Color.YELLOW + " (       *                              \n" +
                            Color.RED    + " )\\ )  (  `     (             (         \n" +
                            Color.YELLOW + "(()/(  )\\))(    )\\        (   )\\ )      \n" +
                            Color.RED    + " /(_))((_)()\\ ((((_)(      )\\ (()/(      \n" +
                            Color.YELLOW + "(_))  (_()((_))\\ _ )\\  _ ((_) /(_))_    \n" +
                            Color.RED    +
                            "/ __| |  \\/  |(_)_\\(_)| | | |(_)) __|   \n" +
                            "\\__ \\ | |\\/| | / _ \\  | |_| |  | (_ |   \n" +
                            "|___/ |_|  |_|/_/ \\_\\  \\___/    \\___|   \n" +
                            Color.RESET +
                            "                                        "
            );
            System.out.println(Color.YELLOW + "                          (`-.                                        \n" +
                    "                                  \\  `                                       \n" +
                    "     /)         ,   '--.           \\    `                                    \n" +
                    "    //     , '          \\/          \\   `   `                                \n" +
                    "   //    ,'              ./         /\\    \\>- `   ,----------.               \n" +
                    "  ( \\  ,'    .-.-._        /      ,' /\\    \\   . `            `.             \n" +
                    "   \\ \\'     /.--. .)       ./   ,'  /  \\     .      `           `.           \n" +
                    "    \\     -{/    \\ .)        / /   / ,' \\       `     `-----.     \\          \n" +
                    "    <\\      )     ).:)       ./   /,' ,' \\        `.  /\\)    `.    \\         \n" +
                    "     >^,  //     /..:)       /   //--'    \\         `(         )    )        \n" +
                    "      | ,'/     /. .:)      /   (/         \\          \\       /    /         \n" +
                    "      ( |(_    (...::)     (                \\       .-.\\ /   ,'          \n" +
                    "      (O| /     \\:.::)                      /\\    ,'   \\)   /  ,'            \n" +
                    "       \\|/      /`.:::)                   ,/  \\  /         (  /              \n" +
                    "               /  /`,.:)                ,'/    )/           \\ \\              \n" +
                    "             ,' ,'.'  `:>-._._________,<;'    (/            (,'              \n" +
                    "           ,'  /  |     `^-^--^--^-^-^-'                                     \n" +
                    " .--------'   /   |                                                          \n" +
                    "(       .----'    |                                                          \n" +
                    " \\ <`.  \\         |                                                          \n" +
                    "  \\ \\ `. \\        |                                                          \n" +
                    "   \\ \\  `.`.      |                                                          \n" +
                    "    \\ \\   `.`.    |                                                          \n" +
                    "     \\ \\    `.`.  |                                                          \n" +
                    "      \\ \\     `.`.|                                                          \n" +
                    "       \\ \\      `.`.                                                         \n" +
                    "        \\ \\     ,^-'                                                         \n" +
                    "         \\ \\    |                                                            \n" +
                    "          `.`.  |                                                            \n" +
                    "             .`.|                                                            \n" +
                    "              `._>\n" + Color.RESET);
            System.out.println(Color.YELLOW + " My armor is worth ten shields, my fangs are swords, my claws are spears," +
                    " the strike of my tail is like lightning, my wings are like a hurricane, and my breath is deadly!" + Color.RESET);
        }
    }
}