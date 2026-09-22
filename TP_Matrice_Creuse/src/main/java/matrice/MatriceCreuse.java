

package matrice;

import java.util.ArrayList;
import java.util.Collection;

public class MatriceCreuse {

    /**
     * Valeur par défault de la matrice
     */
    private static final int TAILLE_MATRICE_DEFAULT = 5;


    private int nombreLignesMatrice;
    private int nombreColonnesMatrice;

    private final int COEFFICIENT_MATRICE_DEFAULT = 0;

    private ArrayList<Coefficient> coefficientsNonNull;
    private Coefficient coefficient;


    public MatriceCreuse(){
        nombreLignesMatrice = TAILLE_MATRICE_DEFAULT;
        nombreColonnesMatrice = TAILLE_MATRICE_DEFAULT;
        coefficientsNonNull = new ArrayList<>();
    }

    public MatriceCreuse(int nbLignes, int nbColonnes){

        if (nbColonnes < 1 || nbLignes < 1){
            throw new IllegalArgumentException("Erreur dans la création dans la matrice");
        }

        nombreLignesMatrice = nbLignes;
        nombreColonnesMatrice = nbColonnes;
        coefficientsNonNull = new ArrayList<>();

    }

    public double valeurCoefficient(int ligneMatrice, int colonneMatrice){

        if (ligneMatrice < 1 || colonneMatrice < 1){
            throw new IllegalArgumentException("Erreur dans la création dans la matrice");
        }

        if (coefficient.estSitue(ligneMatrice, colonneMatrice)){
            return coefficient.getValeur();
        } else {
            return 0;
        }
    }

    public void modifierValeurCoefficient(int numeroLigne, int numeroColonne, int nouvelleValeurCoeff){
        if (nouvelleValeurCoeff == 0){
            System.out.print("La valeur du coeffcient ne peut être 0");
        } else if (numeroLigne > nombreLignesMatrice || numeroColonne > nombreColonnesMatrice){
            throw new IllegalArgumentException("Le numéro de colonne ou de ligne passé en parametre dépasse les " +
                                               "dimensions de la matrice");
        } else {
            
        }
    }



}