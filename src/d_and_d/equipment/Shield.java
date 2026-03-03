package d_and_d.equipment;

/**
 * Représente un Shield à un usage de défensif dans le jeu.
 *  * <p>
 *  * Une potion est un équipement défensif d'augmenter la protection du personnage.
 *  * Son type est automatiquement défini à {@code "Shield"}.
 *  * </p>
 *  */

public class Shield extends DefensiveEquipment {

    /**
     * Construit un Shield avec son nom et son niveau de protection.
     * Le type est automatiquement défini à {@code "Shield"}.
     *
     * @param name          le nom du shield (ex : "Oak Shield")
     * @param lvlProtection le niveau de protection offert le shield
     */

    public Shield (String name , int lvlProtection) {
        super(name, "Shield", lvlProtection);
    }
}
