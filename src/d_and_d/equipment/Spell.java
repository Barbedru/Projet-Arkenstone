package d_and_d.equipment;

/**
 * Représente un sort à usage offensif dans le jeu.
 * <p>
 * Un sort est un équipement offensif permettant d'infliger des dégâts
 * à distance ou par magie. Son type est automatiquement défini à {@code "Spell"}.
 * </p>
 */
public class Spell extends OffensiveEquipment {

    /**
     * Construit un sort avec son nom et son niveau d'attaque.
     * Le type est automatiquement défini à {@code "Spell"}.
     *
     * @param name       le nom du sort (ex : "You shall not pass!")
     * @param lvlAttack  le niveau d'attaque du sort
     */
    public Spell(String name, int lvlAttack) {
        super(name, "Spell", lvlAttack);
    }
}