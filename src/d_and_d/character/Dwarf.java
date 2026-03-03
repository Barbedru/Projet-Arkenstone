package d_and_d.character;

// La classe Dwarf hérite de la classe Character
public class Dwarf extends Character {

    // Constructeur de la classe Dwarf
    // Il prend un paramètre : le nom du personnage
    public Dwarf (String name) {
        // Appel du constructeur de la classe mère (Character)
        // On lui passe :
        // - le nom du personnage
        // - le type "Dwarf"
        super(name, "Dwarf");
    }



}
