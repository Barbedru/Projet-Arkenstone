package d_and_d.equipment;

/**
 * Classe abstraite représentant un équipement offensif (arme ou sort).
 * <p>
 * Toutes les armes ({@link Sword}, {@link WarAxe}) et tous les sorts
 * ({@link FireBall}, {@link Lightning}) héritent de cette classe.
 * </p>
 */
public abstract class OffensiveEquipment {

    private String name;
    private String type;       // "Weapon" ou "Spell"
    private int lvlAttack;     // bonus d'attaque apporté par cet équipement

    /**
     * @param name      le nom de l'équipement
     * @param type      le type ("Weapon" ou "Spell")
     * @param lvlAttack le niveau d'attaque de l'équipement
     */
    public OffensiveEquipment(String name, String type, int lvlAttack) {
        this.name = name;
        this.type = type;
        this.lvlAttack = lvlAttack;
    }

    public String getName()    { return name; }
    public String getType()    { return type; }
    public int getLvlAttack()  { return lvlAttack; }
}