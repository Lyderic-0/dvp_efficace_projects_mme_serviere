/*
 *  Test de la classe Noeud
 *  fichier TestNoeud.java
 */
package entier.arbre;


/**
 * Test de quelques méthodes de la classe Noeud
 * @author INFO2
 */
public class TestNoeud {


    /**
     * Valeurs à inséser pour les tests
     */
    private static final int[] A_INSERER = {25, 77, 11, 5, 20};

    /**
     * Valeurs présentes dans l'arbre de l'énoncé
     */
    private static final int[] ARBRE_ENONCE = {47, 25, 77, 65, 93, 68,
            25, 11, 43, 7, 17, 31, 44};



    /**
     * Méthode qui crée un noeud racine et insère toutes les valeus du
     * tableau argument. La première valeur sera celle du noeud racine
     * @param valeursAInserer  entiers à insérer à partir du noeud racine
     * @return un noeud racine contenant des descendants
     */
    public static Noeud<Integer>  creerDescendant(int[] valeursAInserer) {
        Noeud<Integer> noeud = new Noeud<>(valeursAInserer[0]);

        for (int i = 1; i < valeursAInserer.length; i++) {
            noeud.inserer(valeursAInserer[i]);
        }
        return noeud;
    }




    /**
     * Cette méthode teste la création d'un noeud
     * Elle ne teste pas toutes les opérations à effectuer lors de la création
     */
    public static void testConstructeurSeul() {
        System.out.println("\nTest de la création d'un noeud (test partiel):\n"
                + "-------------------------------------------\n");
        Noeud<Integer> noeud = new Noeud<>(47);
        System.out.println("Test OK");
    }


    /**
     * Cette méthode teste la méthode estPresente dans le cas où le noeud n'a pas
     * de descendant
     * Elle ne teste pas toutes les opérations à effectuer lors de la création
     */
    public static void testEstPresenteSansDescendance() {
        System.out.println("\nTest de la méthode estPresente (test partiel, noeud sans descendant):\n"
                + "---------------------------------------------------------------------\n");
        Noeud<Integer> noeud = new Noeud<>(47);
        if (noeud.estPresente(47)) {
            System.out.println("Test OK = > la valeur 47 a bien été trouvée.");
        } else {
            System.out.println("Test NOK => la valeur 47 n'a pas été trouvée, alors qu'elle est présente.");
        }

        for (int valeur : A_INSERER) {
            if (! noeud.estPresente(valeur)) {
                System.out.println("Test OK : " +  valeur + " n' est pas présente");
            } else {
                System.out.println("Test NOK : " +  valeur + " a été trouvée, alors qu'elle est absente");
            }
        }

    }

    /**
     * Cette méthode teste l'insertion de valeurs
     * Elle ne teste pas toutes les actions a effectuer lors de l'insertion
     */
    public static void testInserer() {
        System.out.println("\nTest de l'insertion de valeurs (test partiel) :\n"
                + "-------------------------------------------\n");
        int nbTestOk;
        Noeud<Integer> noeud = new Noeud<>(47);

        nbTestOk = 0;
        // insertions de valeurs absentes
        for (int valeur : A_INSERER) {
            if (! noeud.inserer(valeur)) {
                System.out.println("Test NOK : échec de l'insertion de " + valeur);
            } else {
                nbTestOk++;
            }
        }

        // insertion de valeurs présentes : l'ajout ne doit pas se faire
        for (int valeur : A_INSERER) {
            if (noeud.inserer(valeur)) {
                System.out.println("Test NOK : insertion de " + valeur + " alors que déjà présente");
            } else {
                nbTestOk++;
            }
        }
        System.out.println("\n   *****  RESULTAT = " + nbTestOk
                + " tests ok sur un total de "
                + A_INSERER.length * 2 +  " tests.\n");
    }


    /**
     * Cette méthode teste l'insertion de valeurs et la méthode estPresente
     * Elle ne teste pas toutes les actions a effectuer lors de l'insertion
     */
    public static void testInsererEstPresente() {
        System.out.println("\nTest methode estPresente :\n"
                + "------------------------------\n");
        int nbTestOk;

        // création d'une hiérarchie conforme à l'exemple du TP
        Noeud<Integer> noeud = creerDescendant(ARBRE_ENONCE);

        nbTestOk = 0;

        // on vérifie que toutes les valeurs de ARBRE_ENONCE sont présentes
        for (int valeur : ARBRE_ENONCE) {
            if (! noeud.estPresente(valeur)) {
                System.out.println("Test NOK : " +  valeur + "n'a pas été trouvée.");
            } else {
                nbTestOk++;
            }
        }

        // on vérifie que toutes les valeurs de ARBRE_ENONCE + 1 sont absentes
        for (int valeur : ARBRE_ENONCE) {
            // TODO : améliorer 43 écrit en dur
            if (valeur != 43 && noeud.estPresente(valeur + 1)) {
                System.out.println("Test NOK : " +  valeur + "a été trouvée.");
            } else {
                nbTestOk++;
            }
        }


        System.out.println("\n   *****  RESULTAT = " + nbTestOk
                + " tests ok sur un total de "
                + ARBRE_ENONCE.length * 2 +  " tests.\n");
    }



    /**
     * Programme principal : lance les tests
     * @param args argument non utilisé
     */
    public static void main(String[] args) {
        testConstructeurSeul();
        testEstPresenteSansDescendance();
        testInserer();
        testInsererEstPresente();
    }

}