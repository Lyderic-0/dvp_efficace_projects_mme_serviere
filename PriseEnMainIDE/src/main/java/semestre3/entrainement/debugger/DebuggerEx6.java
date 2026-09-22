/*
 * Débogueur : voir le contenu d'un objet           10/25
 */
package semestre3.entrainement.debugger;


/**
 * Création d'un objet de type Pays. Le but est de visualiser sa construction pas à pas
 * grâce au débogueur
 * @author BUT 2
 * @version 1.0
 */
public class DebuggerEx6 {

    /**
     * Programme principal
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {

        Pays p = new Pays("France");
        p.ajouterVoisin("Espagne");
        p.ajouterVoisin("Italie");
        p.ajouterVoisin("Belgique");
        p.ajouterVoisin("Suisse");
        p.ajouterVoisin("Allemagne");
        p.ajouterVoisin("Luxembourg");

        // ces voisins ne doivent pas être ajoutés
        p.ajouterVoisin("Suisse");

        try {
            p.ajouterVoisin("");
        } catch(IllegalArgumentException erreur) {
            // ne rien faire : vérification avec le débogueur
        }

        try {
            p.ajouterVoisin("    ");
        } catch(IllegalArgumentException erreur) {
            // ne rien faire : vérification avec le débogueur
        }

        System.out.println("Pays France = " + p);
    }
}
