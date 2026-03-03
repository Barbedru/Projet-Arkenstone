package d_and_d.character;

/**
 * Représente un personnage de type Wizard.
 */
public class Wizard extends Character {

    /**
     * Construit un personnage de type Wizard avec son nom et ses caractéristiques.
     * Le type est automatiquement défini à {@code "Wizard"}.
     *
     * @param name   le nom du personnage
     * @param attack la valeur d'attaque du Wizard
     * @param hp     les points de vie du Wizard
     */
    public Wizard(String name, int attack, int hp) {
        super(name, "Wizard", attack, hp);
    }

    /**
     * Retourne une représentation textuelle du Wizard.
     *
     * @return une chaîne identifiant le personnage comme un Wizard
     */
    @Override
    public String toString() {
        return "Wizard{}";
    }
}