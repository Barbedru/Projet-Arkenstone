package d_and_d.character;

// La classe Wizard hérite de la classe Character
public class Wizard extends Character {
    // Constructeur de la classe Wizard
    // Il prend un paramètre : le nom du personnage
    public Wizard(String name) {
        // Appel du constructeur de la classe mère (Character)
        // On lui passe :
        // - le nom du personnage
        // - le type "Wizard"
        super(name, "Wizard");
    }
}

