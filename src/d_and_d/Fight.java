//package d_and_d;
//
//import d_and_d.character.Character;
//import java.util.Scanner;
//
//public class Fight {
//
//    private Scanner scanner;
//
//    public Fight(Scanner scanner) {
//
//        this.scanner = scanner;
//    }
//
//    public boolean fight (Character hero, Character villain ) {
//
//        while (hero.getHp() > 0 && villain.getHp() > 0) {
//            System.out.println(hero.getName() + " : " + hero.getHp() + " Hp");
//            System.out.println(villain.getName() + " : " + villain.getHp() + " Hp");
//
//            System.out.println("Action ?");
//            System.out.println("1 - Fight");
//            System.out.println("2 - run");
//            String choice = scanner.nextLine();
//
//            if (choice.equals("2")) {
//                System.out.println(" run ");
//                return false;
//            }
//
//            int heroDamage = calculateDamage(hero);
//            villain.setHp(villain.getHp() - heroDamage);
//            System.out.println(hero.getName() + " make " + heroDamage + " damage ");
//
//            if (villain.getHp() <= 0)
//                break;
//
//
//            int villainDamage = calculateDamage(villain);
//            hero.setHp(hero.getHp() - villainDamage);
//            System.out.println(villain.getName() + " make " + villainDamage + " damage");
//        }
//
//
//        if (hero.getHp() > 0) {
//            System.out.println(villain.getName() + " dead ");
//            return true;
//        } else {
//            System.out.println(hero.getName() + " You are Dead...");
//            return false;
//        }
//    }
//
//
//    private int calculateDamage(Character character) {
//        int base = character.getAttack();
//        return base;
//    }
//}
