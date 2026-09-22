/*
 * TP CLASSE PILE - PROGRAMME DE TEST
 * ----------------------------------
 *
 * tests de la classe Pile
 * TestPileEntierComplet.java                                                09/22
 */
package pile;

import pile.Pile;

/**
 * Tests de base pour la classe Pile.
 * Les tests portent sur les différentes méthodes de la classe Pile,
 * ainsi que sur les exceptions susceptibles d'être levées par les 
 * méthodes.
 * @author INFO2
 * @version 1.0
 */
public class TestPileEntierComplet {

    /**
     * Vérifie que la pile argument est vide. Un message affiche le résultat
     * du test
     * @param p  pile supposée être vide
     * @param nomPile  nom de la pile testée 
     */
    private static void testCreationPileVide(Pile p, String nomPile){
        if (p.estVide()) {
            System.out.println("Création avec succès de la pile " + nomPile + " (vide) !"
                    + " Elle contient : " + p);
        } else {
            System.out.println("Test NOK pour la création "
                    + "de la pile " + nomPile);
        }
    }

    /**
     * Test que les capacités des piles sont correctes
     * @param p             pile supposée avec la même capacité que identique
     * @param identique     pile supposée avec la même capacité que p
     * @param differente    pile avec une capactité différente des précédentes
     */
    private static void testCapacite(Pile p, Pile identique, Pile differente) {

        if (identique.memeCapacite(p, identique)
                && !identique.memeCapacite(p, differente)
                && !identique.memeCapacite(identique, differente)) {
            System.out.println("Test OK pour la méthode memeCapacite.");
        } else {
            System.out.println("Test NOK pour la méthode memeCapacite.");
        }
    }

    /**
     * Test de la méthode equals
     * @param p             pile supposée identique à identique
     * @param identique     pile supposée identique à  p
     * @param differente    pile supposée différente de p et identique
     */
    private static void testEgalite(Pile p, Pile identique, Pile differente) {

        if (p.equals(identique) && !p.equals(differente)  && !p.equals(differente)) {
            System.out.println("Test OK pour la méthode equals.");
        } else {
            System.out.println("Test NOK pour la méthode equals.");
        }
    }


    /**
     * Test des méthodes de la classe Pile. Dans ce test, aucune exception 
     * ne doit se produire. Cette assertion est également vérifiée par le test.
     */
    private static void testSansException() {

        // ETAPE 1 : Test des méthodes sans provoquer d'exception
        System.out.println("ETAPE de TEST numéro 1 :\n"
                + "    Test des méthodes de la classe Pile\n"
                + "    et vérification qu'aucune exception ne "
                + "se produit\n\n");

        /*
         * aucune exception ne doit se produire dans le code ci-dessous
         * sauf si l'utilisateur entre trop d'éléments pour la pile p
         */
        try {
            Pile p = new Pile(5);                    // pile de référence
            Pile inverse = new Pile(5);              // recevra l'inverse de p
            Pile grandePile = new Pile(10);          // pour le test sur la capacité

            // on vérifie que les 3 piles sont vides, 
            System.out.println("  ===> Tests création des piles");
            testCreationPileVide(p, "p");
            testCreationPileVide(inverse, "inverse");
            testCreationPileVide(grandePile, "grandePile");

            // on teste la méthode de comparaison des capacités, et equals
            System.out.println("\n\n  ===> Tests sur les piles vides");
            testCapacite(p, inverse, grandePile);
            testEgalite(p, inverse, grandePile);

            // on empile les entiers de 1 à 5 dans la pile p
            for (int n = 1; n <= 5; n++) {
                p.empiler(n);
            }
            System.out  .println("\n\n  ===> Tests sur des piles non vides\n");
            System.out.println("La pile p contient-elle les entiers de 1 à 5 ?\n"
                    + p + "       => "
                    + (p.toString().equals(
                    "[ sommet =  5 | 4 | 3 | 2 | 1 |  ]")
                    ? "OK " : "NOK") + "\n");

            // on dépile les éléments de p pour les empiler dans inverse
            while (!p.estVide()) {
                inverse.empiler(p.sommet());
                p.depiler();
            }
            System.out.println("Contenu de la pile inverse de la précédente "
                    + inverse + "    =>  "
                    + (inverse.toString().equals
                    ("[ sommet =  1 | 2 | 3 | 4 | 5 |  ]")
                    ? "OK " : "NOK") + "\n"
                    + "\net de la pile initiale (devenue vide) : "
                    + p + "   => " + (p.estVide() ? "OK" : "NOK"));

            // nouveau test pour equals
            System.out.println("\n\n  ===> Tests égalité");
            System.out.println("Test " + (! inverse.equals(p) ? "OK " : "NOK")
                    + " pour equals");


            // autres tests pour l'égalité            
            inverse.depiler();
            inverse.depiler();      // inverse contient : sommet = 3, 4, 5
            p.empiler(5);
            p.empiler(4);           // p contient : sommet = 4, 5
            System.out.println("Test " + (! inverse.equals(p) ? "OK " : "NOK")
                    + " pour equals");
            p.empiler(3);          // p contient : sommet = 3, 4, 5
            System.out.println("Test " + (inverse.equals(p) ? "OK " : "NOK")
                    + " pour equals");

        } catch (IllegalArgumentException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalArgumentException");
        } catch (IllegalStateException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalStateException");
        }
    }


    /**
     * Test des méthodes de la classe Pile. Dans ce test, on vérifie que les
     * exceptions attendues sont bien propagées par les méthodes de la classe PileEntier
     */
    private static void testDesExceptions() {
        int testOk = 0;                     // nombre de tests corrects

        // ETAPE 2 : Test des exceptions
        System.out.println("\n\nETAPE de TEST numéro 2\n"
                + "    Vérification que les exceptions sont levées\n");

        // l'exception IllegalArgumentException sera levée  (constructeur)
        try {
            Pile p = new Pile(-5);
            System.out.println("Test NOK pour capacité invalide");
        } catch (IllegalArgumentException e) {
            System.out.println("Test OK => Exception levée: IllegalArgumentException");
            testOk++;
        } catch (IllegalStateException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalStateException");
        }

        // l'exception IllegalStateException sera levée (méthode empiler)
        try {
            Pile p = new Pile(5);
            for (int i = 1; i <= 6 ; i++) {
                p.empiler(i);
            }
            System.out.println("Test NOK pour empiler (ErreurPilePleine)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalArgumentException");
        } catch (IllegalStateException e) {
            System.out.println("Test OK => Exception levée: : IllegalStateException");
            testOk++;
        }

        // l'exception IllegalStateException sera levée (méthode depiler)
        try {
            Pile p = new Pile(5);
            p.depiler();
            System.out.println("Test NOK pour depiler (ErreurPileVide)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalArgumentException");
        } catch (IllegalStateException e) {
            System.out.println("Test OK => Exception levée: : IllegalStateException");
            testOk++;
        }

        // l'exception IllegalStateException sera levée (méthode sommet)
        try {
            Pile p = new Pile(5);
            System.out.println(p.sommet());
            System.out.println("Test NOK pour sommet (ErreurPileVide)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test NOK => Erreur inattendue : IllegalArgumentException");
        } catch (IllegalStateException e) {
            System.out.println("Test OK => Exception levée: : IllegalStateException");
            testOk++;
        }

        // résultat global du test
        if (testOk == 4) {
            System.out.println("\nTous les tests sur les exceptions ont réussi.");
        } else {
            System.out.println("\nAu moins un test sur les exceptions a échoué.");
        }
    }

    /**
     * Fonction principale pour lancer les tests
     * @param args paramètre non utilisé
     */
    public static void main(String[] args) {

        // test des méthodes sans lever les exceptions
        testSansException();

        // test de la propagation correcte des exceptions
        testDesExceptions();
    }
}