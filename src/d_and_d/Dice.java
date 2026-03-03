package d_and_d;

import java.util.Random;

/**
 * Représente un dé virtuel capable de générer des valeurs aléatoires.
 */
public class Dice {

    /**
     * Générateur de nombres aléatoires utilisé pour les lancers de dé.
     */
    private Random rand = new Random();

    /**
     * Simule un lancer de dé et retourne un résultat aléatoire.
     * <p>
     * Le résultat est compris entre 1 et {@code maxValue} inclus.
     * Par exemple, {@code roll(6)} simule un dé à 6 faces.
     * </p>
     *
     * @param maxValue la valeur maximale (et le nombre de faces) du dé
     * @return un entier aléatoire entre 1 et {@code maxValue} inclus
     */
    public int roll(int maxValue) {
        return rand.nextInt(maxValue) + 1;
    }
}