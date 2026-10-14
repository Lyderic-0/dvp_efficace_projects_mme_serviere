package entier.arbre;

// Noeud<T extends Comparable<T>> fait en sorte que des noeuds soient instanciable que dans des classes qui ont la méthode compareTo soit héritent de Comparables
public class Noeud<T extends Comparable<T>> {

    private T valeurNoeud;

    private Noeud<T> valeurNoeudGauche;
    private Noeud<T> valeurNoeudDroite;

    public Noeud(T valeurNoeud){
        if (valeurNoeud != null){
            this.valeurNoeud = valeurNoeud;
            this.valeurNoeudGauche = null;
            this.valeurNoeudDroite = null;
        }
    }

    public boolean estPresente(T aChercher){
        if (valeurNoeud.compareTo(aChercher) == 0){
            return true;
        }

        if (aChercher.compareTo(valeurNoeud) < 0){
            // appel récursif, chercher à gauche
        } else {
            // appel récursif, chercher à droite
        }
        // STUB
        return true;
    }

    public boolean insererNoeud(T valeurAInserer){
        if (valeurAInserer == null){
            return false;
        }
        // TODO Continuer comparaison

        return true;
    }






}