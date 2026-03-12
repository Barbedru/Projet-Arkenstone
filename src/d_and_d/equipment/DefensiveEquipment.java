package d_and_d.equipment;

/**
 * Classe abstraite représentant un équipement défensif (potion, bouclier...).
 * <p>
 * Toutes les potions ({@link Potion}, {@link GreatPotion}) héritent de cette classe.
 * </p>
 */
public abstract class DefensiveEquipment {

    private String name;
    private String type;          // ex : "Potion", "Shield"
    private int lvlProtection;    // bonus de protection apporté

    /**
     * @param name          le nom de l'équipement
     * @param type          le type de l'équipement
     * @param lvlProtection le niveau de protection
     */
    public DefensiveEquipment(String name, String type, int lvlProtection) {
        this.name = name;
        this.type = type;
        this.lvlProtection = lvlProtection;
    }

    public String getName()       { return name; }
    public String getType()       { return type; }
    public int getLvlProtection() { return lvlProtection; }
}