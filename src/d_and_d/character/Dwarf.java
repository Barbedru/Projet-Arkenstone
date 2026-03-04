package d_and_d.character;

/**
 * Représente un personnage de type Nain (Dwarf).
 * <p>
 * Le Nain est un personnage robuste, caractérisé par des points de vie élevés
 * et une bonne capacité d'attaque au corps à corps.
 * </p>
 */
public class Dwarf extends Character {

    /**
     * Construit un personnage de type Nain avec son nom et ses caractéristiques.
     * Le type est automatiquement défini à {@code "Dwarf"}.
     *
     * @param name   le nom du personnage
     * @param attack la valeur d'attaque du Nain
     * @param hp     les points de vie du Nain
     */
    public Dwarf(String name, int attack, int hp) {
        super(name, "Dwarf", attack, hp);
    }


    /**
     * Retourne une représentation textuelle du Nain.
     *
     * @return une chaîne identifiant le personnage comme un Dwarf
     */
    @Override
    public String toString() {
        return "Dwarf{} " + super.toString();
    }

}