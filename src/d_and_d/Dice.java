package d_and_d;

import java.util.Random;

/**
 * Représente un dé virtuel capable de générer des valeurs aléatoires.
 */
public class Dice {

    private Random rand = new Random();

    /**
     * Simule un lancer de dé et retourne un résultat aléatoire entre 1 et {@code maxValue} inclus.
     * Exemple : {@code roll(6)} simule un dé à 6 faces.
     *
     * @param maxValue le nombre de faces du dé
     * @return un entier aléatoire entre 1 et {@code maxValue}
     */
    public int roll(int maxValue) {
        return rand.nextInt(maxValue) + 1; // +1 car nextInt(n) retourne [0, n-1]
    }
}