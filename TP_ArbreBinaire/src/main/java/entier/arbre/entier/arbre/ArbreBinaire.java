package entier.arbre;

public class ArbreBinaire<T extends Comparable<T>> {

    private Noeud<T> racine;

    public ArbreBinaire() {
        this.racine = null;
    }

    public boolean estPresente(T aChercher) {
        if (this.racine == null) {
            return false;
        }
        return this.racine.estPresente(aChercher);
    }

    public boolean inserer(T valeurAInserer) {
        if (valeurAInserer == null) {
            return false;
        }
        if (this.racine == null) {
            this.racine = new Noeud<>(valeurAInserer);
            return true;
        }
        return this.racine.inserer(valeurAInserer);
    }

    public Noeud<T> getRacine() {
        return racine;
    }
}