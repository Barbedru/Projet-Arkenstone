package d_and_d.board;
import d_and_d.character.Character;
import d_and_d.character.villains.Gobelin;
import d_and_d.character.villains.DarkWizard;
import java.util.Random;

//Case Ennemi
public class EnemyCell extends Cell {

    private Character villains;

    public EnemyCell(int position) {
        super(position);
        this.villains = randomVillain();
    }

    public Character randomVillain(){
        Random rand = new Random();
        int roll = rand.nextInt(2);

        if (roll ==0){
            return new Gobelin("Gobelin",1,6, null);
        }else {
            return new DarkWizard("Dark Wizard","Dark Wizard",2, 9, null);
        }
    }

    @Override
    public void action(Character character) {
        System.out.println("⚔\uFE0F Cell " + position + " - BASTON !");
        System.out.println(character.getName() + " fights " + villains.getName() + " !");
    }
}
