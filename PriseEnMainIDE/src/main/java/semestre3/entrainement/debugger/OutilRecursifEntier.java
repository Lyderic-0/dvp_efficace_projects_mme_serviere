/*
 *  Classe outil avec une méthode récursive (pour prise en main du débogueur)
 * OutilRecursifEntier.java                                 10/25
 */
package semestre3.entrainement.debugger;

/**
 * Contient une méthode récursive pour calculer les termes de la suite de
 * Fibonnacci
 * @author BUT2
 * @version 1.0
 */
public class OutilRecursifEntier {

    /**
     * Méthode récursive qui renvoie la valeur de la factorielle
     * située au rang argument
     * @param rang   rang du terme à calculer
     * @return un entier égal à la valeur du terme situé au rang argument
     * @throws IllegalArgumentException  levée si le rang argument est négatif
     */
    public static int factorielle(int rang) {
        if (rang < 0) {
            throw new IllegalArgumentException("Factorielle n'existe pas pour un rang négatif");
        }
        if (rang == 0) {
            return 1;
        }

        // else
        return rang * factorielle(rang - 1);
    }

    /**
     * Méthode récursive qui renvoie la valeur du terme de la suite de Fibonnacci
     * située au rang argument
     * @param rang   rang du terme à calculer
     * @return un entier égal à la valeur du terme situé au rang argument
     * @throws IllegalArgumentException  levée si le rang argument est négatif
     */
    public static int fibonacci(int rang) {
        if (rang < 0) {
            throw new IllegalArgumentException("Fibonacci n'existe pas pour un rang négatif");
        }
        if (rang == 0 || rang == 1) {
            return 1;
        }

        // else
        return fibonacci(rang - 1) + fibonacci(rang - 2);
    }
}
