import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String askString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int askInt(String question) {
        System.out.println(question);
        return Integer.parseInt(scanner.nextLine());
    }
}
