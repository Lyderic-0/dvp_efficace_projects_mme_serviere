/*
 *  gestion d'une pile version générique
 *  fichier PileGen.java                                           09/22
 */

package pile;

/**
 * Cette classe représente une pile générique.
 * Les opérations possibles sont
 *      création de la pile, avec une capacité par défaut, ou bien spécifiée
 *      tester si la pile est vide ou pleine,
 *      empiler une valeur,
 *      dépiler,
 *      consulter la valeur du sommet,
 *      renvoyer le contenu de la pile sous-la forme d'une chaîne de caractères,
 *      déterminer si 2 piles ont la même capacité,
 *      déterminer si 2 piles sont égales
 * @author INFO2
 * @version 1.0
 */
public class PileGenerique<T> {

    /**
     * Valeur par défaut pour la capacité de la pile
     */
    private static final int CAPACITE_DEFAUT = 10;

    /**
     * Taille de la pile (ou nombre d'éléments qu'elle contient)
     * Le sommet de la pile se trouve donc à l'indice taille-1
     */
    private int taille;

    /**
     * Tableau contenant les entiers éléments de la pile
     */
    private T[] element;


    /**
     * Constructeur qui initialise par défaut (pile vide avec capacité par défaut)
     */
    public PileGenerique() {

        // création d'une pile vide ayant la capacité par défaut
        taille = 0;             // à sa création, la pile est vide
        element =  (T[]) new Object[CAPACITE_DEFAUT];
    }

    /**
     * Construit une pile vide avec la capacité argument
     * @param capacite capacité de la pile à créer
     * @throws IllegalArgumentException levée si la capacité est invalide
     */
    public PileGenerique(int capacite) throws IllegalArgumentException {

        // si la capacite argument est invalide, l'exception est levée
        if (capacite <= 0) {
            throw new IllegalArgumentException("La capacité " + capacite
                    + " est invalide.");
        }

        // sinon : création d'une pile vide avec la capacité argument
        taille = 0;
        element =  (T[]) new Object[capacite];
    }



    /**
     * Empile un entier
     * @param valeur entier à empiler
     * @return la pile modifiée
     * @throws IllegalStateException levée si la pile est pleine
     */
    public PileGenerique<T> empiler(T valeur) throws IllegalStateException {

        if (estPleine()){
            throw new IllegalStateException();
        }
        element[taille] = valeur;
        taille++;
        return this;
    }

    /**
     * Dépile le sommet de la pile
     * @return la pile modifiée
     * @throws IllegalStateException levée si la pile est vide
     */
    public PileGenerique<T> depiler() throws IllegalStateException {

        if (this.estVide()){
            throw new IllegalStateException();
        }
        taille--;
        return this;
    }

    /**
     * Renvoie la valeur du sommet de la pile
     * @return le sommet de la pile (un entier)
     * @throws IllegalStateException levée si la pile est vide
     */
    public T sommet() throws IllegalStateException {
        if (this.estVide()){
            throw new IllegalStateException();
        }
        return element[taille - 1];
    }


    /**
     * Détermine si 2 piles ont la même capacité
     * @param a  première pile
     * @param b  deuxième pile
     * @return un booléen égal à vrai ssi les 2 piles arguments ont la même
     *         capacité
     */
    public static <T> boolean memeCapacite(PileGenerique<T> a, PileGenerique<T> b) {
        return a.element.length == b.element.length;
    }

    /**
     * Détermine si la pile est pleine
     *
     * @return un booléen égal à vrai ssi la pile est pleine
     */
    public boolean estPleine() {
        return taille == element.length;
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
     * Renvoie le contenu de la pile sous la forme d'une chaîne
     * dans le format [ sommet = liste des éléments de la pile]
     * @return résultat une chaîne contenant les valeurs des éléments de la pile
     */
    @Override
    public String toString() {

        String affichageFinal = "[ sommet =";
        for (int compteur = taille - 1; compteur >= 0; compteur-- ){
            affichageFinal += " " + element[compteur] + " |";
        }
        affichageFinal += "]";
        return affichageFinal;
    }

    /**
     * Compare la pile courante et la pile argument
     * @return un booléen égal à vrai ssi les 2 piles sont identiques :
     *         même capacité et même contenu
     */
    @Override
    public boolean equals(Object aComparer) {
        boolean resultat = true;

        if (!(this.getClass().equals(aComparer.getClass()) )
              || !memeCapacite(this, (PileGenerique<T>) aComparer)
              || this.taille != ((PileGenerique<?>) aComparer).taille){

            return false;
        }

        for (int compteur = 0 ; compteur <= taille - 1; compteur++){
            if (this.element[compteur] != ((PileGenerique<?>) aComparer).element[compteur]){
                return false;
            }
        }

        return resultat;
    }

}

