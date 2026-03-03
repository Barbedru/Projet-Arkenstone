package d_and_d.character;

import d_and_d.equipment.OffensiveEquipment;

/**
 * Classe abstraite représentant un personnage jouable dans le jeu.
 * <p>
 * Définit les attributs et comportements communs à tous les types de personnages
 * ({@link Dwarf}, {@link Wizard}, etc.). Les sous-classes doivent étendre cette
 * classe pour implémenter des personnages spécifiques.
 * </p>
 */
public abstract class Character {

    /**
     * Nom du personnage (ex : "Thorin").
     */
    private String name;

    /**
     * Type du personnage (ex : "Dwarf", "Wizard").
     */
    private String type;

    /**
     * Valeur d'attaque du personnage.
     */
    private int attack;

    /**
     * Points de vie du personnage.
     */
    private int hp;

    /**
     * Équipement offensif actuellement équipé par le personnage.
     * Peut être {@code null} si aucun équipement n'est porté.
     */
    private OffensiveEquipment offensiveEquipment;

    /**
     * Construit un personnage avec ses caractéristiques de base.
     *
     * @param name   le nom du personnage
     * @param type   le type du personnage
     * @param attack la valeur d'attaque du personnage
     * @param hp     les points de vie du personnage
     */
    public Character(String name, String type, int attack, int hp) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.hp = hp;
    }

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
     * Retourne la valeur d'attaque du personnage.
     *
     * @return la valeur d'attaque
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
     * Retourne l'équipement offensif équipé par le personnage.
     *
     * @return l'équipement offensif, ou {@code null} si aucun n'est équipé
     */
    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    /**
     * Modifie le nom du personnage.
     *
     * @param name le nouveau nom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Modifie le type du personnage.
     *
     * @param type le nouveau type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Modifie les points de vie du personnage.
     *
     * @param hp les nouveaux points de vie
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Modifie la valeur d'attaque du personnage.
     *
     * @param attack la nouvelle valeur d'attaque
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Équipe le personnage avec un équipement offensif.
     *
     * @param offensiveEquipment l'équipement offensif à équiper
     */
    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        this.offensiveEquipment = offensiveEquipment;
    }

    /**
     * Retourne une représentation textuelle du personnage et de ses attributs.
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