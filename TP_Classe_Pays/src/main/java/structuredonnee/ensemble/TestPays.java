/*
 * Test de la classe Pays
 * TestPays.java                        09/22
 */
package structuredonnee.ensemble;

import java.util.ArrayList;



/**
 * Tests unitaires des principales méthodes de la classe Pays
 * @author C. Servières
 * @version 1.0
 */
public class TestPays {

    /** Noms de pays invalides */
    private static final String[] NOM_PAYS_INVALIDE = { null, "", " ", "      "};

    /** Exemples de noms de pays valides */
    private static final String[] NOM_PAYS_VALIDE = { "France", "Espagne", "Italie", "Australie"};



    /** tableau contenant les noms des pays utilisés pour les tests les plus complets */
    private static final String[] NOM_DES_PAYS = { "France", "Royaume-Uni", "Irlande", "Espagne",
            "Allemagne", "Hongrie", "Pologne",
            "Argentine", "Chili", "Perou", "Canada"};

    /**
     * tableau contenant les noms des pays voisins de ceux contenus dans
     * le tableau précédent NOM_DES_PAYS
     */
    private static final String [][] VOISINS = {
            { "Espagne", "Italie", "Suisse", "Allemagne", "Luxembourg", "Belgique" },
            { "Irlande" },
            { "Royaume-Uni" },
            { "Portugal", "France" },
            { "Danemark", "Pologne", "Republique Tcheque", "Autriche",
                    "Suisse", "France", "Luxembourg", "Belgique", "Pays-Bas" },
            { "Slovaquie", "Ukraine", "Roumanie", "Serbie", "Croatie", "Slovenie",
                    "Autriche" },
            { "Russie", "Lituanie", "Bielorussie", "Ukraine",
                    "Slovaquie", "Republique Tcheque", "Allemagne" },
            { "Uruguay", "Bresil", "Paraguay", "Bolivie", "Chili"},
            { "Argentine", "Bolivie", "Perou"},
            { "Chili", "Bolivie", "Bresil", "Colombie", "Equateur"},
            { "Etats-Unis" } };


    /* ===================================================================== */
    /*                     méthode outil pour gérer les tests                */
    /* ===================================================================== */


    /**
     * Affiche le résultat d'un test : le nombre de tests réussis et le
     * nombre de tests total
     * @param nbTestTotal       nombre total de tests effectués
     * @param nbTestOk          nombre de tests réussis
     */
    private static void afficherResultatTest(int nbTestTotal, int nbTestOk) {
        System.out.println("\n" + nbTestOk + " test(s) ont réussi sur un total de "
                + nbTestTotal + " tests réalisés.\n   ==>  "
                + ((nbTestOk == nbTestTotal) ?
                "Tous les tests sont OK"
                : (nbTestTotal - nbTestOk) + " test(s) ont échoué.") + "\n");
    }



    /* ===================================================================== */
    /*                            Tests des constructeurs                    */
    /* ===================================================================== */


    /**
     * Permet de tester que le constructeur avec un seul argument lève (ou pas)
     * l'exception IllegalArgumentException à bon escient
     */
    public static void testConstructeur1ArgumentException() {
        System.out.println("Test du constructeur ayant 1 argument\n"
                + "-------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectué pour ce pays

        // vérification qu'aucune exception n'est levée si le nom du pays est valide
        nbTestOk = 0;
        for (int i = 0; i < NOM_PAYS_VALIDE.length; i++) {
            try {
                aTester = new Pays(NOM_PAYS_VALIDE[i]);
                nbTestOk++;
            } catch(IllegalArgumentException erreur) {
                System.out.println("Echec du test pour le pays " + NOM_PAYS_VALIDE[i]);
            }
        }

        // vérification qu'une exception est levée si le nom du pays est invalide
        for (int i = 0; i < NOM_PAYS_INVALIDE.length; i++) {
            try {
                aTester = new Pays(NOM_PAYS_INVALIDE[i]);
                System.out.println("Echec du test pour le pays " + NOM_PAYS_INVALIDE[i]);
            } catch(IllegalArgumentException erreur) {
                nbTestOk++;

            }
        }

        // résultat du test
        afficherResultatTest(NOM_PAYS_VALIDE.length + NOM_PAYS_INVALIDE.length, nbTestOk);
    }


    /**
     * Permet de tester que le constructeur avec 2 arguments lève (ou pas)
     * l'exception IllegalArgumentException à bon escient
     */
    public static void testConstructeur2ArgumentsException() {
        System.out.println("Test du constructeur ayant 2 arguments\n"
                + "------------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectué pour ce pays

        // vérification qu'aucune exception n'est levée si les noms de pays sont valides
        nbTestOk = 0;
        for (int i = 0; i < NOM_PAYS_VALIDE.length; i++) {
            try {
                aTester = new Pays(NOM_PAYS_VALIDE[i], NOM_PAYS_VALIDE);
                //i % 2 == 0 ? NOM_PAYS_VALIDE : new String[0]);
                nbTestOk++;
            } catch(IllegalArgumentException erreur) {
                System.out.println("Echec du test pour le pays " + NOM_PAYS_VALIDE[i]);
            }
        }

        // vérification qu'une exception est levée si un nom de pays est invalide
        // 1)  nom du pays principal invalide, et noms des pays voisins valides
        for (int i = 0; i < NOM_PAYS_INVALIDE.length; i++) {
            try {
                aTester = new Pays(NOM_PAYS_INVALIDE[i], NOM_PAYS_VALIDE);
                System.out.println("Echec du test pour le pays invalide" + NOM_PAYS_INVALIDE[i]);
            } catch(IllegalArgumentException erreur) {
                nbTestOk++;

            }
        }

        // 2)  nom du pays principal valide, et noms des pays voisins invalides
        String[] paysVoisinAvecInvalide = new String[NOM_PAYS_VALIDE.length];
        for (int i = 0; i < NOM_PAYS_VALIDE.length ; i++) {
            paysVoisinAvecInvalide[i] = NOM_PAYS_VALIDE[i];
        }
        for (int i = 0; i < NOM_PAYS_INVALIDE.length; i++) {
            try {
                paysVoisinAvecInvalide[2] = NOM_PAYS_INVALIDE[i];
                aTester = new Pays(NOM_PAYS_VALIDE[i], paysVoisinAvecInvalide);
                System.out.println("Echec du test pour le pays " + NOM_PAYS_INVALIDE[i]
                        + " et son voisin invalide " + NOM_PAYS_INVALIDE[i]);
            } catch(IllegalArgumentException erreur) {
                nbTestOk++;

            }
        }

        // résultat du test
        afficherResultatTest(NOM_PAYS_VALIDE.length * 2 + NOM_PAYS_INVALIDE.length, nbTestOk);
    }


    /**
     * Permet de tester que le constructeur avec un seul argument et la méthode toString
     * sont corects
     */
    public static void testConstructeur1ArgumentToString() {
        System.out.println("Test du constructeur ayant 1 argument et toString\n"
                + "-------------------------------------------------\n");
        Pays aTester;      // test effectué pour ce pays

        System.out.println("*** Test Visuel ***  Vérifiez l'affichage correct **** \n");
        // vérification qu'aucune exception n'est levée si le nom du pays est valide

        for (int i = 0; i < NOM_PAYS_VALIDE.length; i++) {
            aTester = new Pays(NOM_PAYS_VALIDE[i]);
            System.out.println("Création du pays " + NOM_PAYS_VALIDE[i] + " :\n     ==> "
                    + aTester);
        }
    }


    /**
     * Permet de tester que le constructeur avec 2 arguments et la méthode toString
     * sont corects
     */
    public static void testConstructeur2ArgumentsToString() {
        System.out.println("Test du constructeur ayant 2 arguments et toString\n"
                + "-------------------------------------------------\n");
        Pays aTester;      // test effectué pour ce pays

        System.out.println("*** Test Visuel ***  Vérifiez l'affichage correct **** \n");
        // vérification qu'aucune exception n'est levée si le nom du pays est valide

        for (int i = 0; i < NOM_DES_PAYS.length / 2; i++) {
            aTester = new Pays(NOM_DES_PAYS[i], VOISINS[i] );
            System.out.println("Création du pays " + NOM_DES_PAYS[i] + " :\n     ==> "
                    + aTester);
        }
    }



    /* ===================================================================== */
    /*              Tests des méthodes portant sur les pays voisins          */
    /* ===================================================================== */



    /**
     * Permet de tester la méthode ajouterVoisin
     */
    public static void testAjouterVoisin() {
        System.out.println("Test de la méthode ajouterVoisin \n"
                + "---------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectué pour ce pays

        // vérification qu'une exception est lévée, si le voisin est incorrect
        System.out.println("======> Ajout de voisins incorrects ....");
        nbTestOk = 0;
        aTester = new Pays("France");
        for (int i = 0; i < NOM_PAYS_INVALIDE.length; i++) {
            try {
                aTester.ajouterVoisin(NOM_PAYS_INVALIDE[i]);
                System.out.println("Echec du test pour le pays voisin "
                        + NOM_PAYS_INVALIDE[i]);
            } catch(IllegalArgumentException erreur) {
                nbTestOk++;
            }
        }

        // vérification qu'aucune exception est levée si pays voisin correct est ajouté
        //  + vérification visuelle de l'ajout
        System.out.println("\n======> Ajout de voisins corrects et pas encore présents ....");
        for (int i = 0; i < VOISINS[0].length; i++) {
            try {
                aTester.ajouterVoisin(VOISINS[0][i]);
                System.out.println("Après ajout du voisin " + VOISINS[0][i]
                        + " :\n     => " + aTester);
                nbTestOk++;
            } catch(IllegalArgumentException erreur) {


            }
        }

        // vérification qu'aucune exception est levée si pays voisin déjà présent est ajouté
        //  + vérification visuelle qu'il n'est pas ajouté une 2ème fois
        System.out.println("\n======> Ajout de voisins corrects et déjà présents ....");
        for (int i = 0; i < VOISINS[0].length; i++) {
            try {
                aTester.ajouterVoisin(VOISINS[0][i]);
                System.out.println("Après ajout du voisin " + VOISINS[0][i]
                        + " :\n     => " + aTester);
                nbTestOk++;
            } catch(IllegalArgumentException erreur) {


            }
        }

        // résultat du test
        afficherResultatTest(NOM_PAYS_INVALIDE.length + VOISINS[0].length * 2, nbTestOk);
    }


    /**
     * Permet de tester la méthode aPourVoisin
     */
    public static void testAPourVoisin() {
        System.out.println("Test de la méthode aPourVoisin \n"
                + "-----------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectué pour ce pays


        aTester = new Pays("France", VOISINS[0]);
        System.out.println("Les tests se feront à partir du pays " + aTester + "\n");

        // vérification que les voisins sont bien détectés en tant que voisins
        System.out.println("======> Vérification des voisins ....");
        nbTestOk = 0;
        for (int i = 0; i < VOISINS[0].length; i++) {
            if (aTester.aPourVoisin(VOISINS[0][i])) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test pour le pays voisin "
                        + VOISINS[0][i]);
            }
        }

        // vérification que les non voisins sont bien détectés en tant que non voisins
        System.out.println("======> Vérification des pays non voisins ....");
        for (int i = 0; i < VOISINS[5].length; i++) {
            if (! aTester.aPourVoisin(VOISINS[5][i])) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test pour le pays non voisin "
                        + VOISINS[5][i]);
            }
        }

        // résultat du test
        afficherResultatTest(VOISINS[0].length + VOISINS[5].length, nbTestOk);
    }

    /**
     * Permet de tester la méthode nombreVoisin
     */
    public static void testNombreVoisin() {
        System.out.println("Test de la méthode nombreVoisin (test visuel) \n"
                + "----------------------------------------------\n");
        Pays aTester;      // test effectué pour ce pays

        // vérification visuelle du nombre de voisins
        System.out.println("\n======> Ajout de voisins et comptage ....");
        aTester = new Pays("France");
        System.out.println("Pour l'instant, le pays " + aTester + " ===> "
                + aTester.nombreVoisin() + " voisins\n");
        for (int i = 0; i < VOISINS[0].length; i++) {
            aTester.ajouterVoisin(VOISINS[0][i]);
            System.out.println("Pour l'instant, le pays " + aTester + " ===> "
                    + aTester.nombreVoisin() + " voisins\n");
        }
    }



    /* ===================================================================== */
    /*          Tests des méthodes portant un groupe de pays voisins         */
    /* ===================================================================== */


    /**
     * Permet de tester la méthode aPourVoisin avec en argument une liste de pays
     */
    public static void testAPourVoisinListePays() {
        System.out.println("Test de la méthode aPourVoisin (argument ArrayList) \n"
                + "-----------------------------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectué pour ce pays
        ArrayList<String> listeATester = new ArrayList<>();

        aTester = new Pays("France", VOISINS[0]);
        System.out.println("Les tests se feront à partir du pays " + aTester + "\n");

        // vérification que l'argument ne coincide pas avec les voisins
        // (car 1 au moins pays manque)
        System.out.println("======> Vérification des voisins (il manque des voisins) ....");
        nbTestOk = 0;
        for (int i = 0; i < VOISINS[0].length; i++) {
            if (aTester.aPourVoisin(listeATester)) {
                System.out.println("Echec du test avec les voisins "
                        + listeATester);
            } else {
                nbTestOk++;
            }
            listeATester.add(VOISINS[0][i]);
        }

        // normalemnt : la liste coincide avec les voisins
        System.out.println("======> Vérification des voisins (ils coincident) ....");
        if (aTester.aPourVoisin(listeATester)) {
            nbTestOk++;
        } else {
            System.out.println("Echec du test avec les voisins "
                    + listeATester);
        }

        // vérification que l'argument ne coincide pas avec les voisins
        // (car 1 pays au moins est un trop et éventuellement 1 manque)
        System.out.println("======> Vérification des voisins (des voisins en trop) ....");
        for (int i = 0; i < VOISINS[5].length; i++) {
            listeATester.add(VOISINS[5][i]);
            if (aTester.aPourVoisin(listeATester)) {
                System.out.println("Echec du test avec les voisins "
                        + listeATester);
            } else {
                nbTestOk++;
            }
            if (i > VOISINS[5].length / 2) {
                // on supprime un voisin
                listeATester.remove(0);
            }
        }

        // résultat du test
        afficherResultatTest(VOISINS[0].length + VOISINS[5].length + 1, nbTestOk);
    }

    /**
     * Permet de tester la méthode nombreCommun
     */
    public static void testNombreCommun() {
        System.out.println("Test de la méthode nombreCommun  \n"
                + "---------------------------------\n");
        int nbTestOk;      // nombre de tests corrects
        Pays aTester;      // test effectué pour ce pays
        ArrayList<String> listeATester = new ArrayList<>();

        aTester = new Pays("France", VOISINS[0]);
        System.out.println("Les tests se feront à partir du pays " + aTester + "\n");

        // vérification quand le nombre de pays de la liste testée est inférieur au
        // nombre de voisins
        System.out.println("======> Vérification du nombre de voisins qui coincident (nombre inférieur) ....");
        nbTestOk = 0;
        for (int i = 0; i < VOISINS[0].length; i++) {
            if (aTester.nombreCommun(listeATester) == i) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test avec les voisins "
                        + listeATester
                        + ". Le nombre de voisins communs trouvé est "
                        + aTester.nombreCommun(listeATester) + " au lieu de " + i);
            }
            listeATester.add(VOISINS[0][i]);
        }

        // normalemnt : la liste coincide avec les voisins
        System.out.println("======> Vérification du nombre de voisins qui coincident (nombre égal) ....");
        if (aTester.nombreCommun(listeATester) == VOISINS[0].length) {
            nbTestOk++;
        } else {
            System.out.println("Echec du test avec les voisins "
                    + listeATester
                    + ". Le nombre de voisins communs trouvé est "
                    + aTester.nombreCommun(listeATester) + " au lieu de " + VOISINS[0].length);
        }

        // vérification avec des pays en plus des voisins
        System.out.println("======> Vérification du nombre de voisins qui coincident "
                + "(nombre égal, et avec plus de pays dans la liste) ....");
        for (int i = 0; i < VOISINS[5].length; i++) {
            listeATester.add(VOISINS[5][i]);
            if (aTester.nombreCommun(listeATester) == VOISINS[0].length) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test avec les voisins "
                        + listeATester
                        + ". Le nombre de voisins communs trouvé est "
                        + aTester.nombreCommun(listeATester) + " au lieu de " + VOISINS[0].length);
            }

        }

        // vérification avec des pays en plus des voisins et des voisins manquant
        System.out.println("======> Vérification du nombre de voisins qui coincident "
                + "(nombre inférieur, et des pays non voisins dans la liste) ....");
        for (int i = 0; i < VOISINS[0].length; i++) {
            listeATester.remove(0);
            if (aTester.nombreCommun(listeATester) == VOISINS[0].length - i - 1) {
                nbTestOk++;
            } else {
                System.out.println("Echec du test avec les voisins "
                        + listeATester
                        + ". Le nombre de voisins communs trouvé est "
                        + aTester.nombreCommun(listeATester) + " au lieu de "
                        + (VOISINS[0].length - i - 1));
            }
        }

        // résultat du test
        afficherResultatTest(VOISINS[0].length * 2 + VOISINS[5].length + 1, nbTestOk);
    }



    /* ===================================================================== */
    /*                Programme principal pour lancer les tests              */
    /* ===================================================================== */

    /**
     * Programme principal : lancement des méthodes de tests unitaires
     * @param args  argument non utlisé
     */
    public static void main(String[] args) {
        System.out.println("TESTS DE LA  CLASSE PAYS\n------------------------------\n\n");

        // testConstructeur1ArgumentException();
        // testConstructeur2ArgumentsException();
        // testConstructeur1ArgumentToString();
        // testConstructeur2ArgumentsToString();
        // testAjouterVoisin();
        // testAPourVoisin();
        // testNombreVoisin();
        // testAPourVoisinListePays();
        // testNombreCommun();
    }

}
