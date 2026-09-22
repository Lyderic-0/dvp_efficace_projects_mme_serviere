/*-----------------------------------------------------------------------------
 *-                                                                           -
 *- SEMESTRE 3 - Développement efficace                                      -
 *-                                                                           -
 *-                  TP MATRICE CREUSE - TEST CLASSE MATRICE PARTIE 1         -
 *-                                                                           -
 *-                                                                           -
 * ----------------------------------------------------------------------------
 */

/* Programme de test de la classe Matrice (matrice creuse)                09/22
 * TestMatricePartie1.java
 */
package matrice;

/**
 * Programme de test de la classe Matrice qui représente une matrice creuse.
 * Seules les opérations de la partie 1 du TP sont testées.
 *    - le constructeur avec argument
 *    - la modification d'un coefficient de la matrice
 *    - l'accès à un coefficient de la matrice
 *    - afficher sur l'interface console les coefficients non nuls
 * @author INFO2
 * @version 1.0
 */
public class TestMatricePartie1 {

    /** Dimension de la matrice carrée utilisée pour les tests */
    private static final int DIMENSION = 5;
    
    
    /** jeux de données avec les coordonnées où seront placées des valeurs
     *  non nulles dans la matrice carrée utilisée pour les tests        
     */
    private static final int[][] COORDONNEES = { {1, 2}, {3, 3}, {4, 1} };
    
    /**
     * Jeu de données avec les valeurs des coefficients non nuls de la matrice
     * carrée utilisée pour les tests
     */
    private static final double[] A_INSERER = { 10.5, 6, 5.3 };
    
    
    /*
     * Test du constructeur avec argument
     */
    public static void testConstructeur() {
        
        // jeux de données avec des dimensions incorrectes et correctes
        int[][] dimIncorrecte = { {0, 0}, {0, -6}, {-6, -7}, {-6, 0},
                                  {5, 0}, {5, -6}, {0, 10}, {-4, 15} };
        int[][] dimCorrecte = { {2, 2}, {10, 15}, {15, 4}};
        Matrice aCreer = null;      // matrice à créer
        int nbTestOk;               // nombre de tests réussis
        
        System.out.println("Test du constructeur avec argument : \n"
                           + "------------------------------------\n"
                           + "1) Tests avec des dimensions incorrectes. Vous "
                           + "devez vérifier qu'un message d'erreur s'affiche "
                           + "correctement pour chaque tentative.\n");
        
        // test avec le jeu de données comportant des valeurs incorrectes
        nbTestOk = 0;
        for (int i = 0; i < dimIncorrecte.length; i++) {
            System.out.println("Tentative construction avec la dimension incorrecte "
                    + dimIncorrecte[i][0] + " * " 
                    + dimIncorrecte[i][1] + " : ");            
            try {
                aCreer = new Matrice(dimIncorrecte[i][0], dimIncorrecte[i][1]);
                System.out.println("ERREUR : construction effectuée bien que "
                                   + "la dimension soit incorrecte");
            } catch (IllegalArgumentException erreur) {
                System.out.println("  => " + erreur.getMessage());
                nbTestOk++;
            }           
        }
        System.out.println("\n   *****  RESULTAT = " + nbTestOk + " test(s) Ok sur "
                           + dimIncorrecte.length + "\n" );
        
        // test avec le jeu de données comportant des valeurs correctes
        nbTestOk = 0;
        System.out.println("2) Tests avec des dimensions correctes. Vous devez "
                           + "vérifier qu'un message de confirmation s'affiche "
                           + "pour chaque tentative.\n");
        for (int i = 0; i < dimCorrecte.length; i++) {
            System.out.println("Tentative construction avec la dimension correcte "
                               + dimCorrecte[i][0] + " * " 
                               + dimCorrecte[i][1] + " : ");
            try {
                aCreer = new Matrice(dimCorrecte[i][0], dimCorrecte[i][1]);
                System.out.println("  =>  Construction effectuée."); 
                nbTestOk++;
            } catch (IllegalArgumentException erreur) {
                System.out.println("ERREUR : construction impossible avec ");
                System.out.println(erreur.getMessage());
            }           
        }
        System.out.println("\n   *****  RESULTAT = " + nbTestOk + " tests Ok sur "
                           + dimCorrecte.length + "\n" );  
        System.out.println("\n********************************************\n");
    }
    
    
    /**
     * Test de la méthode permettant d'afficher les coefficients non nuls de la 
     * matrice. Simultanément, la méthode setValeur est testée sur quelques 
     * situations simples.
     */
    public static void testAfficherSetValeur() {        
        Matrice aTester = null;         // matrice utilisée pour les tests
         
        System.out.println("Test de l'affichage des coefficients : \n"
                           + "------------------------------------\n");
        
        // test avec une matrice nulle
        aTester = new Matrice(DIMENSION, DIMENSION);
        System.out.println("Résultat affichage d'une matrice nulle. \n"
        		           + "  => ");
        aTester.afficher();
        
        // tests avec une matrice non nulle
        initMatriceCarre(aTester);
        System.out.println("\nRésultat affichage d'une matrice non nulle. \n");
        for(int i = 0; i < A_INSERER.length; i++) {
            System.out.println("Insertion de la valeur "
                               + A_INSERER[i] + " sur la ligne "
                               + COORDONNEES[i][0] + " et la colonne "
                               + COORDONNEES[i][1]);
        }
        System.out.println("   => ");
        aTester.afficher();
        System.out.println("\n********************************************\n");
    }
    
    
    /**
     * Test de la méthode getValeur avec une matrice nulle
     * @param aTester matrice qui sera créée par la méthode 
     */
    private static void testGetValeurMatriceNulle(Matrice aTester) {
        int nbTestOk;                   // nombre de tests réussis
        System.out.println("TEST 1 : avec une matrice nulle.\n");
        nbTestOk = 0;
        
        // on vérifie que tous les coefficients de la matrice sont égaux à 0
        for (int l = 1; l <= DIMENSION; l++) {
            for (int c = 1; c <= DIMENSION; c++) {
                if (aTester.getValeur(l, c) == 0) {
                    nbTestOk++;
                } else {
                    System.out.println("ERREUR : le coefficient de la ligne "
                                       + l + ", colonne " + c + " est égal à " 
                                       + aTester.getValeur(l, c) 
                                       + " au lieu de 0.");
                }
            }
        }
        System.out.println("   *****  RESULTAT = " + nbTestOk 
                           + " tests ok sur un total de "
                           + DIMENSION * DIMENSION + " tests.\n");        
    }
    
    
    
    /**
     * Test de la méthode getValeur avec une matrice non nulle
     * @param aTester  matrice sur laquelle portent les tests
     */
    private static void testGetValeurMatriceNonNulle(Matrice aTester) {
        int nbTestOk;                   // nombre de tests réussis
        int position;                   // position d'une paire dans COORDONNEES
        double valeurCourante;          // valeur d'un coefficient de la matrice
        boolean correct;                // vrai ssi le test de la valeur est correct
                
        System.out.println("TEST 2 : avec une matrice non nulle.\n");
        initMatriceCarre(aTester);
        nbTestOk = 0;       
        for (int l = 1; l <= DIMENSION; l++) {
            for (int c = 1; c <= DIMENSION; c++) {
                
                // on vérifie que la valeur située en (l, c) est correcte
                valeurCourante = aTester.getValeur(l, c);
                
                // position = -1, si valeur attendue égale à 0
                position = positionDansTable(COORDONNEES, l, c);  
                correct = false;
                
                /*
                 * 2 cas sont envisagés : la valeur du coefficient en (l, c) est
                 * égale à 0 ou bien elle est différente de 0
                 */
                if (valeurCourante != 0 && position != -1) {
                    if (A_INSERER[position] == valeurCourante) {
                        nbTestOk++;
                        correct = true;
                    }
                } else if (valeurCourante == 0 && position == -1) {
                    nbTestOk++;
                    correct = true;
                }
                if (! correct) {                    
                    System.out.println("ERREUR : le coefficient de la ligne "
                                       + l + ", colonne " + c + " est égal à " 
                                       + aTester.getValeur(l, c) 
                                       + " au lieu de "
                                       + (position == -1 ? 0 : A_INSERER[position]));
                }
            }
        }
        System.out.println("   *****  RESULTAT = " + nbTestOk 
                           + " tests ok sur un total de "
                           + DIMENSION * DIMENSION + " tests.\n");               
    }
    
    
    /**
     * Test de la méthode getValeur avec des coordonnées incorrectes
     * @param aTester  matrice sur laquelle portent les tests
     */
    private static void testGetValeurCoordonneeIncorrecte(Matrice aTester) {        
        int nbTestOk;                   // nombre de tests réussis
        double valeurCourante;          // valeur d'un coefficient de la matrice
        
        // jeu de données avec des coordonnées incorrectes
        int[][] coordIncorrecte = { {0, 0}, {0, -6}, {-6, -7}, {-6, 0},
                {5, 0}, {5, -6}, {0, 10}, {-4, 15},
                {3, 15}, {12, 2}, {0, 6}, {10, 6}};

        System.out.println("TEST 3 : accès avec des coordonnées incorrectes.\n"
                           + "Vous devez vérifier qu'un message d'erreur "
                           + "s'affiche correctement après chaque accès.\n");        
        nbTestOk = 0;
        for (int i = 0; i < coordIncorrecte.length; i++) {                      
            try {
                System.out.println("Accès à la valeur située en "
                                   + coordIncorrecte[i][0] + " , "
                                   + coordIncorrecte[i][1] + " : ");
                valeurCourante = aTester.getValeur(coordIncorrecte[i][0], 
                                                   coordIncorrecte[i][1]);                
                System.out.println("ERREUR : les coordonnées " 
                                   + coordIncorrecte[i][0] + " , "
                                   + coordIncorrecte[i][1] 
                                   + " ont été jugées correctes.");
            } catch (IllegalArgumentException erreur) {
                System.out.println("  => " + erreur.getMessage());
                nbTestOk++;
            }           
        }
        System.out.println("\n   *****  RESULTAT = " + nbTestOk 
                           + " tests ok sur un total de "
                           + coordIncorrecte.length +  " tests.\n");           
    }
    
    
    
    /**
     * Test de la méthode getValeur
     */
    public static void testGetValeur() {
        Matrice aTester = null;         // matrice utilisée pour les tests
       
        System.out.println("Test de l'accesseur getValeur : \n"
                           + "------------------------------\n");

        /*
         *  TEST 1 : on vérifie que tous les coefficients d'une matrice nulle
         *  sont égaux à 0 
         */
        aTester = new Matrice(DIMENSION, DIMENSION);
        testGetValeurMatriceNulle(aTester);
        
        /*
         * TEST 2 : on place dans la matrice des valeurs différentes de 0,
         * et on vérifie que tous les coefficients ont bien la valeur attendue
         */
        testGetValeurMatriceNonNulle(aTester);
        
        // TEST 3 : on utilise des coordonnées incorrectes
        testGetValeurCoordonneeIncorrecte(aTester); 
        System.out.println("\n********************************************\n");
    }
    
    
    /**
     * Test de la méthode setValeur en utilisant des coordonnées incorrectes
     * @param aTester  matrice à tester
     */
    private static void testSetValeurCoordonneeIncorrecte(Matrice aTester) {
        
        // jeu de données avec des coordonnées incorrectes
        int[][] coordIncorrecte = { {0, 0}, {0, -6}, {-6, -7}, {-6, 0},
                {5, 0}, {5, -6}, {0, 10}, {-4, 15},
                {3, 15}, {12, 2}, {0, 6}, {10, 6}};
        int nbTestOk;                   // nombre de tests réussis
        
        System.out.println("TEST 1 : avec des coordonnées incorrectes.\n"
                + "Vous devez vérifier qu'un message d'erreur "
                + "s'affiche correctement.\n");
        nbTestOk = 0;
        
        /*
         * Pour chaque paire de coordonnées incorrectes, on appelle la méthode
         * setValeur afin de provoquer la levée de l'exception.
         */
        for (int i = 0; i < coordIncorrecte.length; i++) {                      
            try {
                 System.out.println("Modification de la valeur située en "
                                    + coordIncorrecte[i][0] + " , "
                                    + coordIncorrecte[i][1] + " : ");
                 aTester.setValeur(coordIncorrecte[i][0], 
                                   coordIncorrecte[i][1], 55);                
                 System.out.println("ERREUR : les coordonnées " 
                                    + coordIncorrecte[i][0] + " , "
                                    + coordIncorrecte[i][1] 
                                    + " ont été jugées correctes.");
             } catch (IllegalArgumentException erreur) {
                 System.out.println("  => " + erreur.getMessage());
                 nbTestOk++;
             }           
        }
        System.out.println("\n   *****  RESULTAT = " + nbTestOk 
                           + " tests ok sur un total de "
                           + coordIncorrecte.length +  " tests.\n"); 
    }
    
    /**
     * Test de la méthode setValeur en utilisant des coordonnées correctes
     * @param aTester  matrice à tester
     */
    private static void testSetValeurCoordonneeCorrecte(Matrice aTester) {
        
        // jeu de données avec les coordonnées des coefficients à modifier
        int[][] coordAModifier = { {5, 4}, {2, 2}, {1, 2} };
        
        // jeu de données avec les nouvelles valeurs des coefficients
        double[] nouvelleValeur = { 13.7, 0, -6};
         
        System.out.println("TEST 2 : avec des coordonnées correctes.\n"
                + "Vous devez vérifier que l'affichage est correct.\n"
                + "Matrice intiale : ");
        aTester.afficher();  
        
        // on modifie  des valeurs de la matrice avec des valeurs non nulles
        for (int i = 0; i < coordAModifier.length; i++) {                              
             System.out.println("\n\nModification de la valeur située en "
                                + coordAModifier[i][0] + " , "
                                + coordAModifier[i][1] + " avec la valeur "
                                + nouvelleValeur[i]);
             aTester.setValeur(coordAModifier[i][0], 
                               coordAModifier[i][1], nouvelleValeur[i]);                
             aTester.afficher();  
        }
        
        // on modifier des valeurs de la matrice avec la valeur 0
        for(int i = 0; i < A_INSERER.length; i++) {            
            System.out.println("\n\nModification de la valeur située en "
                    + COORDONNEES[i][0] + " , "
                    + COORDONNEES[i][1] + " avec la valeur 0");
            aTester.setValeur(COORDONNEES[i][0], COORDONNEES[i][1], 0);                
            aTester.afficher(); 
        }      
    }
    
    
    /**
     * Test de la méthode setValeur
     */
    public static void testSetValeur() {
        Matrice aTester;                // matrice à tester
           
        System.out.println("Test opération de modification d'un coefficient : \n"
                           + "--------------------------------------------------\n");
        aTester = new Matrice(DIMENSION, DIMENSION);
        initMatriceCarre(aTester);
        
        // tests avec des coordonnées incorrectes
        testSetValeurCoordonneeIncorrecte(aTester);
        
        // tests avec des coordonnées correctes
        testSetValeurCoordonneeCorrecte(aTester);
        System.out.println("\n********************************************\n");
    }
    
    
    /**
     * Détermine si une paire (a, b) est présente dans un tableau à 2 dimensions
     * contenant des paires
     * @param table tableau à 2 dimensions avec 2 colonnes 
     *              chaque ligne contient donc une paire
     * @param a  première valeur de la paire recherchée
     * @param b  deuxième valeur de la paire recherchée
     * @return un entier égal l'indice de la ligne du tableau table qui contient 
     *         la paire (a, b) ou -1 si la paire n'est pas trouvée
     */
     private static int positionDansTable(int[][] table, int a, int b) {
        int i;      // indice de parcours des lignes de table
        for (i = 0; i < table.length && (table[i][0] != a || table[i][1] != b); i++);
        return (i < table.length ? i : -1);
     }
    
    
    /**
     * Initialise une matrice carrée de taille DIMENSION * DIMENSION
     * pour qu'elle contienne les valeurs définies dans la constante
     * A_INSERER. Les coordonnées sont spécifiées par le tableau
     * COORDONNEES.
     * @param aInitiliaser  matrice à initialiser (elle doit déjà être
     *                      créée à l'appel de la méthode)
     */
    private static void initMatriceCarre(Matrice aInitialiser) {        
        for(int i = 0; i < A_INSERER.length; i++) {            
            aInitialiser.setValeur(COORDONNEES[i][0], COORDONNEES[i][1], A_INSERER[i]);            
        }
    }
    
        
    /**
     * Programme principal permettant de lancer les procédures de test
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {
        System.out.println("TEST DES METHODES DE LA CLASSE MATRICE CREUSE\n\n");
        // testConstructeur();
        // testAfficherSetValeur();
        // testSetValeur();
         testGetValeur();
        
    }
    
}
