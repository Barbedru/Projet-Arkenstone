package d_and_d.character;



public class Wizard extends Character {



    public Wizard(String name, int attack, int hp) {

        super(name, "Wizard", attack, hp);
    }



    @Override
    public String toString() {

        return "Wizard{}" + super.toString();
    }
}