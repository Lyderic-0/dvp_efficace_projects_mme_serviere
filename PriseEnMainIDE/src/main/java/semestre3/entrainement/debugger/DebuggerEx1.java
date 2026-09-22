/*
 * Programme très simple pour comprendre le principe du debogger
 * DebuggerEx1.java                         09/25
 */
package semestre3.entrainement.debugger;


/**
 * Dans  ce programme on a déclaré 4 variables, on les affecte avec différentes
 * valeurs ou expressions.
 * En fin de programme, les variables sont affichées.
 * @author BUT2
 * @version 1.0
 */
public class DebuggerEx1 {

    /**
     * Programme principal
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {

        int premier,
                deuxieme,
                valeur,
                entier;

        System.out.println("Début du programme");
        premier = 0;
        entier = -1;
        deuxieme = 2;
        premier = 1;
        valeur = premier + deuxieme;
        entier = 2 * valeur + 4;
        valeur = valeur + 1;
        entier = premier + deuxieme + (2 * entier);
        deuxieme = 2 * deuxieme;

        System.out.println("A la fin du programme : \n"
                + "la variable premier a la valeur " + premier + "\n"
                + "la variable deuxieme a la valeur " + deuxieme + "\n"
                + "la variable valeur a la valeur " + valeur + "\n"
                + "la variable entier a la valeur " + entier + "\n");
    }
}

