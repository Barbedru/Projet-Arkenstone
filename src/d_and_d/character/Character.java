package d_and_d.character;

import d_and_d.equipment.OffensiveEquipment;

/**
 * Représente un personnage abstrait dans le jeu Donjons & Dragons.
 * <p>
 * Cette classe sert de base pour tous les types de personnages du jeu.
 * Elle encapsule les attributs fondamentaux tels que le nom, le type,
 * les points d'attaque, les points de vie et l'équipement offensif.
 * </p>
 */
public abstract class Character {

    /** Le nom du personnage. */
    private String name;

    /** Le type du personnage (ex : guerrier, mage, elfe...). */
    private String type;

    /** Les points d'attaque du personnage. */
    private int attack;

    /** Les points de vie du personnage. */
    private int hp;

    /** L'équipement offensif équipé par le personnage. Peut être {@code null}. */
    private OffensiveEquipment offensiveEquipment;


    /**
     * Construit un nouveau personnage avec les attributs spécifiés.
     * <p>
     * Note : l'équipement offensif est initialisé à {@code null} indépendamment
     * du paramètre {@code offensiveEquipment} fourni.
     * </p>
     *
     * @param name               le nom du personnage
     * @param type               le type du personnage
     * @param attack             les points d'attaque du personnage
     * @param hp                 les points de vie du personnage
     * @param offensiveEquipment l'équipement offensif (actuellement ignoré, voir note)
     */
    public Character(String name, String type, int attack, int hp, OffensiveEquipment offensiveEquipment) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.hp = hp;
        this.offensiveEquipment = offensiveEquipment;
    }


    // -------------------------------------------------------------------------
    // GETTERS
    // -------------------------------------------------------------------------

    /**
     * Retourne le nom du personnage.
     *
     * @return le nom du personnage
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne le type du personnage.
     *
     * @return le type du personnage
     */
    public String getType() {
        return type;
    }

    /**
     * Retourne les points d'attaque du personnage.
     *
     * @return les points d'attaque
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Retourne les points de vie du personnage.
     *
     * @return les points de vie
     */
    public int getHp() {
        return hp;
    }

    /**
     * Retourne l'équipement offensif du personnage.
     *
     * @return l'équipement offensif, ou {@code null} si aucun équipement n'est porté
     */
    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }


    // -------------------------------------------------------------------------
    // SETTERS
    // -------------------------------------------------------------------------

    /**
     * Définit le nom du personnage.
     *
     * @param name le nouveau nom du personnage
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Définit le type du personnage.
     *
     * @param type le nouveau type du personnage
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Définit les points de vie du personnage.
     *
     * @param hp les nouveaux points de vie
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Définit les points d'attaque du personnage.
     *
     * @param attack les nouveaux points d'attaque
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Définit l'équipement offensif du personnage.
     *
     * @param offensiveEquipment le nouvel équipement offensif, ou {@code null} pour le retirer
     */
    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }


    /**
     * Retourne une représentation textuelle du personnage.
     * <p>
     * Affiche le nom, le type, les points d'attaque, les points de vie
     * ainsi que l'équipement offensif (ou {@code "none"} si aucun).
     * </p>
     *
     * @return une chaîne décrivant le personnage
     */
    @Override
    public String toString() {


        return "Character{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", attack=" + attack +
                ", hp=" + hp +
                ", offensiveEquipment=" + offensiveEquipment +
                '}';
    }
}