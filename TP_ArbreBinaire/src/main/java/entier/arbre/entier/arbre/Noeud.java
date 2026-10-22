package entier.arbre;

public class Noeud<T extends Comparable<T>> {

    private T valeurNoeud;
    private Noeud<T> valeurNoeudGauche;
    private Noeud<T> valeurNoeudDroite;

    private static final int DECALAGE = 5;


    public Noeud(T valeurNoeud) {
        if (valeurNoeud != null) {
            this.valeurNoeud = valeurNoeud;
            this.valeurNoeudGauche = null;
            this.valeurNoeudDroite = null;
        }
    }

    public boolean estPresente(T aChercher) {
        if (aChercher == null || this.valeurNoeud == null) {
            return false;
        }
        int comp = aChercher.compareTo(this.valeurNoeud);
        if (comp == 0) {
            return true;
        } else if (comp < 0) {
            return this.valeurNoeudGauche != null && this.valeurNoeudGauche.estPresente(aChercher);
        } else {
            return this.valeurNoeudDroite != null && this.valeurNoeudDroite.estPresente(aChercher);
        }
    }

    public boolean inserer(T valeurAInserer) {
        if (valeurAInserer == null) {
            return false;
        }
        int comp = valeurAInserer.compareTo(this.valeurNoeud);
        if (comp == 0) {
            return false;
        } else if (comp < 0) {
            if (this.valeurNoeudGauche == null) {
                this.valeurNoeudGauche = new Noeud<>(valeurAInserer);
                return true;
            }
            return this.valeurNoeudGauche.inserer(valeurAInserer);
        } else {
            if (this.valeurNoeudDroite == null) {
                this.valeurNoeudDroite = new Noeud<>(valeurAInserer);
                return true;
            }
            return this.valeurNoeudDroite.inserer(valeurAInserer);
        }
    }

    public void afficheArbreNiveau(int niveau) {
        // TODO
    }

    public boolean insererNoeud(T valeurAInserer) {
        return inserer(valeurAInserer);
    }

    public T getValeurNoeud() {
        return valeurNoeud;
    }

    public Noeud<T> getValeurNoeudGauche() {
        return valeurNoeudGauche;
    }

    public Noeud<T> getValeurNoeudDroite() {
        return valeurNoeudDroite;
    }
}