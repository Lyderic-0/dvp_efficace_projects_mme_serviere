/*
 * Ce programme recherche tous les nombres premiers inférieurs ou égaux
 * à une valeur limite
 * fichier TousLesPremiers.java                                         10/25
 */
package semestre3.entrainement.debugger;

import java.util.Scanner;

/**
 * Ce programme recherche tous les nombres premiers inférieurs ou égaux à une
 * valeur limite entrée par l'utilisateur. Les nombres premiers trouvés seront
 * affichés par ligne de 10.
 *
 * @author INFO1
 * @version 1.0
 */
public class DebuggerEx5 {

    public static void main(String[] args) {

        /*
         * Constante égale à la quantité de nombres premiers affichés sur
         * une ligne
         */
        final int NB_PREMIER_LIGNE = 10;

        // déclaration d'un objet Scanner pour effectuer les saisies
        Scanner entree = new Scanner(System.in);

        int limite,             // valeur limite entrée par l'utilisateur
                nbEcritLigne,       // nombre de valeurs écrites sur la ligne
                // (sert à gérer les retours à la ligne)
                nombre,             // nombre à tester
                diviseur;           // diviseur potentiel du nombre

        // saisie de la valeur limite de la recherche
        System.out.print("Entrez une valeur limite : ");
        limite = entree.nextInt();

        // on traite d'abord les cas particuliers
        if (limite <= 1) {
            System.out.println(
                    "Il n'y a pas de nombre premier dans cet intervalle");
        } else if (limite == 2) {
            System.out.println(
                    "2 est le seul nombre premier de cet intervalle.");
        } else {

            // cas général, avec limite >= 3. D'abord, on affiche 2 et 3
            System.out.println("Les nombres premiers de l'intervalle 0.."
                    + limite + " sont : ");
            System.out.print("2  \t3  \t");

            /*
             * on recherche les autres nombres premiers seulement parmi les
             * entiers impairs supérieurs ou égaux à 5
             */
            nbEcritLigne = 2;   // on a écrit 2 valeurs sur la ligne
            nombre = 5;         // on commence la recherche par le nombre 5
            while (nombre <= limite) {

                /* on recherche si nombre possède un diviseur impair autre
                 * que 1 et lui-même. La recherche commence avec le diviseur
                 * potentiel 3, on passe ensuite au diviseur impair suivant
                 */
                diviseur = 3;       // premier diviseur potentiel impair
                while ((nombre % diviseur != 0)
                        && (diviseur * diviseur < nombre)) {
                    diviseur = diviseur + 2;        // diviseur impair suivant
                }

                // on détermine si nombre possède un diviseur
                if (nombre % diviseur != 0) {

                    /*
                     * Le dernier diviseur éventuel essayé ne divise pas nombre
                     * nombre est premier : on l'affiche
                     */
                    if (nbEcritLigne == NB_PREMIER_LIGNE) {

                        /*
                         * si on a déjà écrit NB_PREMIER_LIGNE nombres sur la
                         * ligne, on passe à la ligne suivante
                         */
                        System.out.println();
                        nbEcritLigne = 0;
                    }

                    // on affiche le nombre et on compte un nombre écrit de plus
                    System.out.print(nombre + "   \t");
                    nbEcritLigne++;
                }

                // on passe à l'entier impair suivant
                nombre = nombre + 2;
            }                    // fin de la boucle while
            System.out.println();
        }
    }
}
