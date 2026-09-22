/*
 * Programme à comprendre
 * DebuggerEx2.java                     09/25
 */
package semestre3.entrainement.debugger;
import java.util.Scanner;

/**
 * Selon les saisies de l'utilisateur, combien de conditions parmi celles vérifiées par le programme
 * sont vraies ?
 * @author INFO1
 * @version 1.0
 */
public class DebuggerEx2 {

    /**
     * Programme principal
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {

        Scanner entree = new Scanner(System.in);
        int a, b;       // deux entiers saisis par l'utilisateur
        int compteurCondition;  // compteur de conditions vérifiées et vraies
        int compteurElse;       // compteur du nombre d'entrée dans une branche else
        
        // saisie des 2 entiers
        System.out.print("Donnez le premier entier : ");
        a = entree.nextInt();
        System.out.print("Donnez le deuxième entier : ");
        b = entree.nextInt();
        
        // on compte les conditions vraies selon la valeur de a et b
        compteurCondition = 0;
        compteurElse = 0;
        if (a < 0 || a == 5) {
            compteurCondition++;
            if (b % 2 == 0) {
                compteurCondition++;
            } else {
                compteurElse++;
            }
        } else if (a % 5 == 0 && b % 2 == 0) {
            compteurElse++;
            compteurCondition++;
            if (a > 500) {
                compteurCondition++;
            } else if (b <= 200) {
                compteurElse++;
                compteurCondition++;
            } else {
                compteurElse++;
            }
        } else {
            compteurElse++;
            if (b > 10) {
                compteurCondition++;
                if (b % 10 == 0) {
                    compteurCondition++;
                    if (a < -5) {
                        compteurCondition++;
                    } else if (a > 300) {
                        compteurElse++;
                        compteurCondition++;
                    } else {
                        compteurElse++;
                    }
                }
            } else {
                compteurElse++;
            }
        }

        // on affiche le résultat
        System.out.println("Nombre de conditions vérifiées et vraies = " + compteurCondition
                           +  "\nNombre d'entrées dans un branche else = " + compteurElse);

    }
}
