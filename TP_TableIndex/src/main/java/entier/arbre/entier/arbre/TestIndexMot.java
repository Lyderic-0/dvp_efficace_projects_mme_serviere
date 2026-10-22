/*
 * Tests de la classe IndexMot
 * TestIndexMot.java                        10/23
 */
package main.java.entier.arbre.entier.arbre;

import java.util.ArrayList;

/**
 * Tests unitaires des m�thodes de la classe IndexMot
 * @author INFO2
 * @vesion 1.0
 *
 */
public class TestIndexMot {

    /** Mots utilis�s comme jeu de test  */
    private static final String[] MOTS =
            {"Java", "PHP", "C++", "HTML", "JavaScript" };

    /** Num�ros associ�s aux mots et utiliss comme jeu de test */
    private static final int[][] NUMEROS = { {5, 15, 10, 20},   // pour Java
            {1, 2, 3, 4, 5},                  // pour PHP
            {20, 15, 10, 5},                  // pour C++
            {8, 4, 2},                        // pour HTML
            {10} };                           // pour JavaScript
    /**
     * Table de test cr��e par les m�thodes testAjouterMot ou ajouterMot
     */
    private static IndexMot tableTest;


    /**
     * Initialisation de la table de test, sans effectuer de v�rifications
     */
    private static void ajouterMot() {
        tableTest = new IndexMot();

        // ajout du jeu de test � la table de test
        for (int m = 0; m < MOTS.length; m++) {
            for (int numero = 0; numero < NUMEROS[m].length; numero++) {
                tableTest.ajouterMot(MOTS[m], NUMEROS[m][numero]);
            }
        }
    }


    /**
     * Test de la m�thode ajouterMot.
     * Elle initialise la table tableTest avec un jeu de donn�es
     */
    private static void testAjouterMot() {
        int nbTestOk = 0;               // nombre de tests corrects
        int nbTestNok = 0;              // nombre de tests incorrects
        tableTest = new IndexMot();
        System.out.println("\n\nTest de la m�thode ajouterMot\n"
                + "-----------------------------");

        // ajout du jeu de test � la table de test
        for (int m = 0; m < MOTS.length; m++) {
            for (int numero = 0; numero < NUMEROS[m].length; numero++) {
                if (! tableTest.ajouterMot(MOTS[m], NUMEROS[m][numero])) {
                    System.out.println("R�sultat inattendu : ajout impossible "
                            + " du mot " + MOTS[m] + " et de la page "
                            + NUMEROS[m][numero]);
                    nbTestNok++;
                } else {
                    nbTestOk++;
                }
            }
        }
        affichePhraseBilan("des ajouts possibles", nbTestOk, nbTestNok);

        // v�rification ajout impossible si valeurs d�j� pr�sentes
        nbTestNok = 0;
        nbTestOk = 0;
        for (int m = 0; m < MOTS.length; m++) {
            for (int numero = 0; numero < NUMEROS[m].length; numero++) {
                if (tableTest.ajouterMot(MOTS[m], NUMEROS[m][numero])) {
                    System.out.println("R�sultat inattendu : ajout possible "
                            + " du mot " + MOTS[m] + " et de la page "
                            + NUMEROS[m][numero]);
                    nbTestNok++;
                } else {
                    nbTestOk++;
                }
            }
        }
        affichePhraseBilan("des ajouts impossibles", nbTestOk, nbTestNok);
    }


    /**
     * Test de la m�thode toString
     */
    private static void testToString() {
        System.out.println("\n\nTest de la m�thode toString (test visuel) \n"
                + "------------------------------------------");
        tableTest = new IndexMot();
        System.out.println("Une table vide : " + tableTest);
        ajouterMot();
        System.out.println("Apr�s ajout des mots (v�rifier l'ordre croissant des "
                + "cl�s et des num�ros) : \n" + tableTest);
    }


    /**
     * Test de la m�thode getListeMot
     */
    private static void testGetListeMot() {
        System.out.println("\n\nTest de la m�thode getListeMot (test visuel) \n"
                + "------------------------------------------");
        tableTest = new IndexMot();
        System.out.println("Liste des mots d'une table vide : "
                + tableTest.getListeMot());
        ajouterMot();
        System.out.println("Apr�s ajout des mots (v�rifier l'ordre croissant des "
                + "cl�s) : \n" + tableTest.getListeMot());
    }


    /**
     * Test de la m�thode getListeNumero
     */
    private static void testGetListeNumero() {
        System.out.println("\n\nTest de la m�thode getListeNumero (test visuel) \n"
                + "------------------------------------------\n"
                + "(les num�ros ne sont pas suppos�s �tre tri�s dans l'ordre "
                + "croissant) ");

        ajouterMot();
        for (String mot : MOTS) {
            System.out.println("Le mot " + mot + " est pr�sent sur les index "
                    + tableTest.getListeNumero(mot));
        }

        ArrayList<Integer> resultat;
        resultat = tableTest.getListeNumero("tablette");
        System.out.println("Le mot " + "tablette" + " est pr�sent sur les index : "
                + ( resultat == null ? "aucun index" : resultat));

        resultat = tableTest.getListeNumero("ordinateur");
        System.out.println("Le mot " + "ordinateur" + " est pr�sent sur les index : "
                + ( resultat == null ? "aucun index" : resultat));
    }


    /**
     * Test de la m�thode SupprimerNumero
     */
    private static void testSupprimerNumero() {
        int nbTestOk,             // nombre de tests corrects
                nbTestNok;            // nombre de tests incorrects
        System.out.println("\n\nTest de la m�thode supprimerNumero (test visuel) \n"
                + "------------------------------------------ ");

        ajouterMot();
        System.out.println("Table initiale avant suppression\n" + tableTest);

        // tests de suppressions possibles
        nbTestOk = nbTestNok = 0;
        for (int m = 0; m < MOTS.length; m++) {
            if (tableTest.supprimerNumero(MOTS[m], NUMEROS[m][0])) {
                System.out.println("Suppression de (" + MOTS[m] + " , "
                        + NUMEROS[m][0] + ") effectu�e");
                nbTestOk++;
            } else {
                System.out.println("Echec anormal de la suppression " + MOTS[m] + " , "
                        + NUMEROS[m][0] );
                nbTestNok++;
            }
        }
        affichePhraseBilan("des suppressions possibles", nbTestOk, nbTestNok);
        System.out.println("Table apr�s ces suppressions :\n" + tableTest + "\n");

        // tests de suppressions impossibles
        nbTestOk = 0;
        for (int m = 0; m < MOTS.length; m++) {
            if (tableTest.supprimerNumero(MOTS[m], 999)) {
                System.out.println("Echec : Suppression de (" + MOTS[m] + " , "
                        + NUMEROS[m][0] + ") effectu�e alors que impossible");
                nbTestNok++;
            } else {
                nbTestOk++;
            }
        }
        if (tableTest.supprimerNumero("ordinateur", 9)) {
            System.out.println("Echec : Suppression de (" + "ordinateur , 9"
                    + ") effectu�e alors que impossible");
            nbTestNok++;
        } else {
            nbTestOk++;
        }
        affichePhraseBilan("des suppressions impossibles", nbTestOk, nbTestNok);
    }


    /**
     * Test de la m�thode incrementerApres
     */
    private static void testIncrementerApres() {
        System.out.println("\n\nTest de la m�thode incrementerApres (test visuel) \n"
                + "------------------------------------------ ");
        ajouterMot();
        System.out.println("Table initiale avant modification\n" + tableTest);

        // insertion d'une page apr�s la page num�ro 10
        tableTest.incrementerApres(10);
        System.out.println("Insertion d'une page apr�s celle de num�ro 10 :\n"
                + tableTest);

        // insertion d'une page apr�s la page num�ro 5
        tableTest.incrementerApres(5);
        System.out.println("Insertion d'une page apr�s celle de num�ro 5 :\n"
                + tableTest);
    }


    /**
     * Test de la m�thode supprimerDecrementerApres
     */
    private static void testsupprimerDecrementerApres() {
        System.out.println("\n\nTest de la m�thode incrementerApres (test visuel) \n"
                + "------------------------------------------ ");
        ajouterMot();
        System.out.println("Table initiale avant modification\n" + tableTest);

        // suppression de la   page  num�ro 10
        tableTest.supprimerDecrementerApres(10);
        System.out.println("Suppression de la page  num�ro 10 :\n" + tableTest);

        // suppression de la page  num�ro 5
        tableTest.supprimerDecrementerApres(5);
        System.out.println("Suppression de la page num�ro 5 :\n" + tableTest);
    }


    /**
     * Affiche une phrase bilan d'un test : nombre de tests ok et non ok.
     * @param phrase        d�but de la phrase � afficher
     * @param nbTestOk      nombre de tests ok
     * @param nbTestNok     nombre de tests non ok
     */
    private static void affichePhraseBilan(String phrase, int nbTestOk, int nbTestNok) {
        System.out.println("Test " + phrase + " : " + nbTestOk + " tests OK sur "
                + (nbTestOk + nbTestNok) + " tests effectu�s.\n    ==> "
                + (nbTestNok == 0 ?
                "Tous les tests sont OK" : " Erreurs d�tect�es"));
    }


    /**
     * Programme principal pour lancer les tests
     * @param args  argument non utilis�
     */
    public static void main(String[] args) {

        testAjouterMot();
        testToString();
        testGetListeMot();
        testGetListeNumero();
        testSupprimerNumero();
        testIncrementerApres();
        testsupprimerDecrementerApres();
    }
}
