package d_and_d.equipment;

/**
 * Classe abstraite représentant un équipement offensif dans le jeu.
 * <p>
 * Sert de base pour tout équipement destiné à augmenter la valeur d'attaque du personnage
 * (hache, épée, sortilère, ect.). Les sous-classes doivent étendre cette classe
 * pour définir des types d'équipements spécifiques.
 * </p>
 */
public abstract class OffensiveEquipment {

    /**
     * Nom de l'équipement (ex : "Battle ax").
     */
    private String name;

    /**
     * Type de l'équipement (ex : "Spell" , "Weapon").
     */
    private String type;

    /**
     * Niveau d'attaque offert l'équipement.
     */
    private int lvlAttack;

    /**
     * Construit un équipement offensif avec ses caractéristiques de base
     *
     * @param name          le nom de l'équipement
     * @param type          le type de l'équipement
     * @param lvlAttack     le niveau d'attaque offert
     */

    public OffensiveEquipment (String name, String type, int lvlAttack){
        this.name = name;
        this.type = type;
        this.lvlAttack = lvlAttack;

    }
}
