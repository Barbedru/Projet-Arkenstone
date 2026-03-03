package d_and_d.equipment;

/**
 * Représente une potion à usage défensif dans le jeu.
 * <p>
 * Une potion est un équipement défensif consommable permettant de restaurer
 * ou d'augmenter la protection du personnage. Son type est automatiquement
 * défini à {@code "Potion"}.
 * </p>
 */
public class Potion extends DefensiveEquipment {

    /**
     * Construit une potion avec son nom et son niveau de protection.
     * Le type est automatiquement défini à {@code "Potion"}.
     *
     * @param name          le nom de la potion (ex : "Potion de soin")
     * @param lvlProtection le niveau de protection offert par la potion
     */
    public Potion(String name, int lvlProtection) {
        super(name, "Potion", lvlProtection);
    }
}