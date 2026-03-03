package d_and_d;

import java.util.Random;

public class Dice {

    Random rand = new Random();
    // Création d'un objet Random qui servira à générer les nombres aléatoires

    public int roll(int maxValue) {
        // Méthode publique qui simule un lancer de dé
        // maxValue représente la valeur maximale que le dé peut donner


        return rand.nextInt(maxValue) + 1;
        // nextInt(maxValue) génère un nombre entre 0 (inclus) et maxValue (exclus)
        // On ajoute 1 pour obtenir un nombre entre 1 et maxValue (inclus)
    }
    }


