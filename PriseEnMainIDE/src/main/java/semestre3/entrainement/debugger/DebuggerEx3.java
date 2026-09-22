/*
 * Programme pour comprendre le principe du débogueur
 * Utilisation d'une boucle et instruction conditionnelle
 * DebuggerEx2.java                         09/25
 */
package semestre3.entrainement.debugger;


/**
 * Dans ce programme, on calcule la somme des multiples de 4 qui sont
 * inférieurs à une LIMITE
 * @author BUT2
 * @version 1.0
 */
public class DebuggerEx3 {

    /**
     * Programme principal
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {

        // limite jusqu'à laquelle les multiples de 4 sont recherchés
        final int LIMITE = 100;
        int sommeDesMultiples;

        System.out.println("Début du traitement, somme des multiples ...");

        sommeDesMultiples = 0;
        for (int nombre = 1; nombre <= LIMITE; nombre++) {
            if (nombre % 4 == 0) {

                // multiple de 4
                sommeDesMultiples += nombre;
                System.out.print("");
            }

        }

        System.out.println("La somme des multiples de 4 compris entre 1 et "
                           + LIMITE + " est égale à " + sommeDesMultiples);
    }
}
