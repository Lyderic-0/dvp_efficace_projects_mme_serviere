/*-----------------------------------------------------------------------------
 * IUT de Rodez                                                               *
 * Département Informatique                                                   *
 * Semestre 3 - Développement efficace                                        *
 *                                                                            *
 *             CORRECTION - TP CLASSE PAYS (utilisation d'un TreeSet)         *
 *                                                                            *
 * ----------------------------------------------------------------------------
 */

/*
 * Classe qui représente un pays par ses pays limitrophes
 * Pays.java                                               10/25
 */
package semestre3.entrainement.debugger;

import java.util.ArrayList;
import java.util.TreeSet;


/**
 * Cette classe correspond à la description d'un pays.
 * Un pays est décrit par son nom, et par la liste de ses pays limitrophes.
 * Dans cette version, un nom de pays est valide s'il est non null et ne contient pas
 * une chaîne vide, ni une chaîne formée uniquement d'espaces
 * @author INFO2
 * @version 1.0
 */
public class Pays {
    
    /** Attribut égal au nom du pays */
    private String nom;
    
    /** Ensemble  des pays limitrophes */
    private TreeSet<String>  limitrophe;
    
    
    /**
     * Constructeur par défaut : provoque une erreur
     * @throw IllegalArgumentException levée dans tous les cas
     */
    public Pays()  {
         throw new IllegalArgumentException(
                           "Erreur constructeur Pays : aucun nom de pays en argument.");
    }
    
    
    /**
     * Constructeur avec en argument le nom du pays à créer
     * @param leNom  une chaîne contenant le nom du pays
     * @throw IllegalArgumentException si le nom du pays argument n'est pas valide
     */
    public Pays(String leNom)  {
        if (! nomValide(leNom)) {
            throw new IllegalArgumentException(
                           "Erreur constructeur Pays : chaîne vide en argument.");
        }
        
        // le nom du pays n'est pas vide
        nom = leNom;
        limitrophe = new TreeSet<>();
    }
    
    
    /**
     * Constructeur avec en argument le nom du pays à créer,
     * et des pays limitrophes
     * @param leNomDuPays  une chaîne contenant le nom du pays
     * @param voisin  tableau contenant la liste des pays limitrophes   
     * @throw IllegalArgumentException si le nom de l'un des pays arguments n'est pas valide
     */
    public Pays(String leNomDuPays, String[] voisin) {
        if (! nomValide(leNomDuPays)) {
            throw new IllegalArgumentException(
                    "Erreur constructeur Pays : chaîne vide pour le nom du pays.");
        }
        
        // le nom du pays est valide
        nom = leNomDuPays;
        limitrophe = new TreeSet<>();
        
        // on affecte les pays voisins à la liste des pays limitrohpes
        for (int i = 0; i < voisin.length; i++) {
            if (! nomValide(voisin[i])) {
                throw new IllegalArgumentException(
                        "Erreur constructeur Pays : chaîne vide pour un voisin.");
            }
            if (nom.equals(voisin[i])) {
                throw new IllegalArgumentException(
                        "Un pays ne peut pas être voisin avec lui-même");
            }
                          
            // REMARQUE : la méthode add n'ajoutera pas le nom du pays, s'il est
            //            déjà présent (car add est appliquée ici à un ensemble.
            //            Si on l'applique à une ArrayList, l'ajout sera fait même
            //            si la valeur à ajouter est déjà présente)                
            limitrophe.add(voisin[i]);  
        }        
    }
    
    
    
    /**
     * Renvoie une chaîne de caractères contenant la desciption du pays courant
     * @return une chaîne contenant le nom du pays, et la liste de ses voisins
     */
    public String toString() {
        return nom + " a pour voisin : " + limitrophe;
    }   
    
    
    
    /**
     * Ajoute le pays argument à la liste des voisins.
     * Si ce pays figure déjà dans la liste des pays limitrophes,
     * la méthode est sans effet
     * @param nomPaysVoisin  nom du pays voisin à ajouter
     * @throw IllegalArgumentException si le nom du pays argument n'est pas valide
     *        (vide ou égal au nom du pays courant)
     */
    public void ajouterVoisin(String nomPaysVoisin) {
        if (! nomValide(nomPaysVoisin)) {
            throw new IllegalArgumentException(
                    "Erreur ajout voisin : chaîne vide pour un voisin.");
        }
        if (nom.equals(nomPaysVoisin)) {
            throw new IllegalArgumentException(
                    "Un pays ne peut pas être voisin avec lui-même");
        }
        
        // le nom du voisin est valide
        limitrophe.add(nomPaysVoisin);
    }
    
    
    /**
     * Renvoie vrai ssi le pays courant a pour voisin le pays argument
     * @param unPays  une chaîne de caractères contenant le nom du pays à tester
     * @return un booléen égal à vrai ssi le pays dont le nom est passé en
     *         argument est voisin du pays courant
     * @throw IllegalArgumentException si le nom du pays argument n'est pas valide     
     */
    public boolean aPourVoisin(String unPays) {
        if (! nomValide(unPays)) {
            throw new IllegalArgumentException(
                    "Erreur ajout voisin : chaîne vide pour un voisin.");
        }
        return limitrophe.contains(unPays);
    }
    
    
    /**
     * Accesseur sur le nom du pays
     * @return une chaîne contenant le nom du pays
     */
    public String getNom() {
        return nom;
    }
    
    
    /**
     * Accesseur sur la liste des pays limitrophes
     * @return une liste de chaînes de caractères contenant les noms des 
     *         pays limitrophes
     */
    public TreeSet<String> getLesVoisins() {
        
        /*
         * ATTENTION : il faut renvoyer une copie de l'ensemble des voisins
         * Dans le cas contraire, si l'appelant modifie le TreeSet renvoyé,
         * pour lui ajouter un pays, ce dernier devient un pays voisin du pays courant
         * 
         * PAR EXEMPLE :
         *      Pays paysFrance = new Pays("France", VOISINS);       
         *      TreeSet<String> voisinsFrance = paysFrance.getLesVoisins();
         *      voisinsFrance.add("Australie");
         *      System.out.println(paysFrance);  
         *         ==> L'Australie est devenu voisin de la France
         */
        return new TreeSet<String>(limitrophe);
    }
    
    
    /**
     * Renvoie le nombre de pays limitrophes
     * @return un entier égal au nombre de pays limitrophes
     */
    public int nombreVoisin() {
        return limitrophe.size();
    }
    
    
    /**
     * Renvoie vrai ssi le pays courant a pour voisin tous les pays
     * de la liste argment, et aucun autre pays
     * @param listePays  une liste de chaînes de caractères contenant les noms des 
     *                   pays à tester 
     * @return un booléen égal à vrai ssi les pays dont les noms sont passés en
     *         argument sont voisins du pays courant et réciproquement
     */
    public boolean aPourVoisin(ArrayList<String> paysATester) {        
        return limitrophe.containsAll(paysATester) 
               && paysATester.containsAll(limitrophe);
    }
    
    
    /**
     * Renvoie le nombre de pays communs entre la liste arguemnt
     * et la liste des pays limitrophes du pays courant
     * @param listePays  une liste de chaînes de caractères contenant les noms des 
     *                   pays à tester 
     * @return un entier égal au nombre de pays communs entre les 2 listes
     */
    public int nombreCommun(ArrayList<String> paysATester) { 
        // on transforme l'ensemble des pays limitrophes en une ArrayList
        ArrayList<String> paysPresentDansATester = new ArrayList<>(limitrophe);
        
        // on retire de la ArrayList les pays présents dans la liste argument
        paysPresentDansATester.retainAll(paysATester);
        return paysPresentDansATester.size();
    }
    
 
    
    /**
     * Détermine si la chaîne argument est un nom de pays valide
     * Seule vérification effectuée : chaîne argument non nulle et 
     * non vide (au moins 1 caractère autre que espace)
     * @param aTester    nom du pays à vérifier
     * @return  un booléen égal à vrai ssi la chaîne argument est un nom de pays valide
     */
    private static boolean nomValide(String aTester) {
        return aTester != null && ! aTester.isBlank();
    }
}
