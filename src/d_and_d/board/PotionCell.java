package d_and_d.board;
import d_and_d.character.Character;
import d_and_d.equipment.DefensiveEquipment;
import d_and_d.equipment.GreatPotion;
import d_and_d.equipment.Potion;


//Case Potion
public class PotionCell extends Cell {

    private DefensiveEquipment potions;

    public PotionCell(int position) {
        super(position);
        posPotion(position);
    }

    private void posPotion(int position) {
        switch (position) {
            case 7: case 13: case 31: case 33: case 39: case 43:
                potions = new Potion("Potion",2);
                break;
            case 28: case 41:
                potions = new GreatPotion("Great Potion",5);
        }
    }

    @Override
    public void interact(Character character) {
        super.interact(character);

        if (potions instanceof Potion) {
            System.out.println("Cell " + "" + position + " " +  " There's something here ");
            System.out.println("A Potion \uD83E\uDDEA  I feel better ");
        } else if (potions instanceof GreatPotion) {
            System.out.println("Cell " + "" + position + " " +  " There's are something here ");
            System.out.println("A Great Potion ⚗\uFE0F  I feel much better ");
        }
    }

}