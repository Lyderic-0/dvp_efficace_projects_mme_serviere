/*
 * Représentation d'un coefficient d'une matrice                                    09/22 
 * Coefficient.java
 */

package matrice;

/**
 * Cette classe représente le coefficient d'une matrice. 
 * Un coefficient regroupe : la ligne et la colonne du coefficient (2 entiers) et la valeur du
 * coefficient (de type double).
 * Aucune vérification n'est faite sur la validité des numéros de ligne et de colonne
 * @author INFO2
 * @version 1.0
 */
public class Coefficient {

    /** Attribut représentant la ligne sur laquelle se situe le coefficient */
    private int ligne;

    /** Attribut représentant la colonne sur laquelle se situe le coefficient */
    private int colonne;

    /** Attribut égal à la valeur du coefficient */
    private double valeur;



    /**
     * Constructeur d'un coefficient
     * @param numLigne numéro de la ligne du coefficient (entier)
     * @param numColonne numéro de la colonne du coefficient (entier)
     * @param valeurCoef valeur du coefficient (double)
     */
    public Coefficient(int numLigne, int numColonne, double valeurCoef) {
        ligne = numLigne;
        colonne = numColonne;
        valeur = valeurCoef;
    }

    /**
     * Accesseur sur la ligne
     * @return la ligne courante
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Accesseur sur la colonne
     * @return la colonne courante
     */
    public int getColonne() {
        return colonne;
    }

    /**
     * Accesseur sur la valeur du coefficient
     * @return la valeur du coefficient
     */
    public double getValeur() {
        return valeur;
    }

    /**
     * Modifie le numéro de la ligne
     * @param numLigne nouveau numéro de ligne à affecter (entier)
     */
    public void setLigne(int numLigne) {
        ligne = numLigne;
    }

    /**
     * Modifie le numéro de la colonne
     * @param numColonne nouveau numéro de colonne à affecter (entier)
     */
    public void setColonne(int numColonne) {
        ligne = numColonne;
    }

    /**
     * Modifie la valeur du coefficient
     * @param valeurCoef nouvelle valeur du coefficient à affecter (double)
     */
    public void setValeur(double valeurCoef) {
        valeur = valeurCoef;
    }

    /**
     * Renvoie une chaîne de caractères contenant les informations connues sur
     * le coefficient
     * @return une chaîne avec les informations
     */
    public String toString() {
        return "(" + ligne + "," + colonne + ") => " + valeur;
    }

    /**
     * Détermine si le coefficient est situé à la position indiquée en argument
     * @param numLigne numéro de ligne
     * @param numColonne numéro de colonne
     * @return un booléen égal à vrai ssi le coefficient est situé à la position
     *         argument
     */
    public boolean estSitue(int numLigne, int numColonne) {
        return ligne == numLigne && colonne == numColonne;
    }

}
