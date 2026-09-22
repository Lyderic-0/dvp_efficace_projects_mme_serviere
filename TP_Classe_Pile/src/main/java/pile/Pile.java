/*-----------------------------------------------------------------------------
 * IUT de Rodez                                                               *
 * Département Informatique                                                   *
 * Semestre 3 - Programmation Efficace                                        *
 *                                                                            *
 *                  CORRECTION - TP CLASSE PILE D'ENTIERS                     *
 *                        - Avec IllegalArgumentException                     *
 *                            et IllegalStateException                        *
 *                                                                            *
 * ----------------------------------------------------------------------------
 */

/*
 *  gestion d'une pile d'entiers  avec exceptions prédéfinies
 *  fichier PileEntier.java                                              09/26
 */
package pile;

/**
 * Cette classe représente une pile d'entiers.
 * Les opérations possibles sont
 *      création de la pile,
 *      tester si la pile est vide ou pleine,
 *      empiler une valeur,
 *      dépiler,
 *      consulter la valeur du sommet,
 *      renvoyer le contenu de la pile sous-la forme d'une chaîne de caractères,
 *      déterminer si 2 piles ont la même capacité,
 *      déterminer si 2 piles sont égales
 * Les méthodes qui ne peuvent pas être exécutées normalement provoquent
 * la levée d'une exception : IllegalArgumentException et IllegalStateException
 * @author INFO2
 * @version 1.0
 */
public class Pile {


    /**
     * Valeur par défaut pour la capacité de la pile
     */
    private static final int CAPACITE_DEFAUT = 10;

    /**
     * Capacité de la pile, ou nombre maximum d'éléments qu'elle peut contenir
     */
    private int capacite;

    /**
     * Taille de la pile (ou nombre d'éléments qu'elle contient)
     * Le sommet de la pile se trouve donc à l'indice taille-1
     */
    private int taille;

    /**
     * Tableau contenant les entiers éléments de la pile
     */
    private int[] element;


    /**
     * Constructeur par défaut (pile vide avec la capacité par défaut)
     */
    public Pile() {

        // création d'une pile vide ayant la capacité par défaut
        taille = 0;             // à sa création, la pile est vide
        element = new int[CAPACITE_DEFAUT];
        capacite = CAPACITE_DEFAUT;
    }

    /**
     * Construit une pile vide avec la capacité argument
     *
     * @param capacite capacité de la pile à créer
     * @throws IllegalArgumentException levée si la capacité est invalide
     */
    public Pile(int capacite) throws IllegalArgumentException {

        // si la capacite argument est invalide, l'exception est levée
        if (capacite <= 0) {
            throw new IllegalArgumentException();
        }

        // sinon : création d'une pile vide avec la capacité argument
        taille = 0;
        element = new int[capacite];
        this.capacite = capacite;
    }

    /**
     * Détermine si la pile est pleine
     *
     * @return un booléen égal à vrai ssi la pile est pleine
     */
    public boolean estPleine() {
        return taille == capacite;
    }

    /**
     * Détermine si la pile est vide
     *
     * @return un booléen égal à vrai ssi la pile est vide
     */
    public boolean estVide() {
        return taille == 0;
    }

    /**
     * Vérifie si deux piles ont la même capacité
     *
     * @param pileAComparer Première pile dont la capacité doit être comparé à la capacité de autrePile
     */
    public boolean memeCapacite(Pile pileAComparer, Pile autrePileAComparer){
        return pileAComparer.capacite == autrePileAComparer.capacite;
    }

    /**
     * Détermine si deux piles sont identiques
     *
     * @param pilaAComparerObjet la pile que l'on vas comparer à l'autre parametre
     */
    public boolean equals(Object pilaAComparerObjet){

        // Vérifie si l'object est bien null et n'est pas instance de pile
        // auquel cas comparaison impossible
        if (!(pilaAComparerObjet instanceof Pile)) {
            return false;
        }

        Pile pileAComparer = (Pile) pilaAComparerObjet;
        Pile autrePile = new Pile();

        if (!memeCapacite(pileAComparer, autrePile) || this.taille != pileAComparer.taille){
            return false;
        }

        for (int compteur = 0 ; compteur <= taille - 1; compteur++){
            if (this.element[compteur] != pileAComparer.element[compteur]){
                return false;
            }
        }
        return true;
    }


    /**
     * Renvoie la valeur du sommet de la pile
     *
     * @return le sommet de la pile (un entier)
     * @throws IllegalStateException levée si la pile est vide
     */
    public int sommet() throws IllegalStateException {

        // si la pile est vide, on lève l'exception IllegalStateException
        if (estVide()) {
            throw new IllegalStateException();
        }

        // sinon : on renvoie le sommet
        return element[taille - 1];
    }

    /**
     * Empile l'entier passé en argument
     *
     * @param nbEmpile la valeur à empiler
     * @throws IllegalStateException la pile est pleine.
     */
    public void empiler(int nbEmpile) {

        if (!estPleine()){
            element[taille] = nbEmpile;
            taille++;
        } else {
            throw new IllegalStateException();
        }
    }

    /**
     * Dépile le sommet de la pile
     *
     * @throws IllegalStateException levé si la pile est vide
     */
    public void depiler() throws IllegalStateException{
        if (estVide()){
            throw new IllegalStateException();
        } else {
            taille--;
        }
    }



    @Override
    public String toString(){
        String affichageFinal = "[ sommet =";
        for (int compteur = taille - 1; compteur >= 0; compteur-- ){
            affichageFinal += " " + element[compteur] + " |";
        }
        affichageFinal += "]";
        return affichageFinal;
    }

}


