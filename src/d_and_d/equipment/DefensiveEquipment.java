package d_and_d.equipment;

/**
 * Classe abstraite représentant un équipement défensif dans le jeu.
 * <p>
 * Sert de base pour tout équipement destiné à protéger le personnage
 * (armure, bouclier, etc.). Les sous-classes doivent étendre cette classe
 * pour définir des types d'équipement spécifiques.
 * </p>
 */
public abstract class DefensiveEquipment {

    /**
     * Nom de l'équipement (ex : "Bouclier de fer").
     */
    private String name;

    /**
     * Type de l'équipement (ex : "Shield", "Potion").
     */
    private String type;

    /**
     * Niveau de protection offert par l'équipement.
     */
    private int lvlProtection;

    /**
     * Construit un équipement défensif avec ses caractéristiques de base.
     *
     * @param name          le nom de l'équipement
     * @param type          le type de l'équipement
     * @param lvlProtection le niveau de protection offert
     */
    public DefensiveEquipment(String name, String type, int lvlProtection) {
        this.name = name;
        this.type = type;
        this.lvlProtection = lvlProtection;
    }
}