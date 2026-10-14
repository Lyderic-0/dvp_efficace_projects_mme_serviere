package entier.arbre;

public class Noeud<T> {

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

    public boolean insererNoeud(T valeurAInserer){
        if (valeurAInserer == null){
            return false;
        }
        // TODO Continuer comparaison

        return true;
    }






}