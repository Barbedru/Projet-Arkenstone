package d_and_d.equipment;

/**
 * Représente une arme à usage offensif dans le jeu.
 * <p>
 * Une arme est un équipement offensif permettant d'infliger des dégâts.
 * Son type est automatiquement défini à {@code "Weapon"}.
 * </p>
 */

public class Weapon extends OffensiveEquipment {

    /**
     * Construit une arme avec son nom et son niveau d'attaque.
     * Le type est automatiquement défini à {@code "Weapon"}.
     *
     * @param name       le nom de l'arme (ex : "Orcrist")
     * @param lvlAttack  le niveau d'attaque de l'arme
     */

    public Weapon (String name , int lvlAttack) {
        super(name, "Weapon", lvlAttack);
    }

}
