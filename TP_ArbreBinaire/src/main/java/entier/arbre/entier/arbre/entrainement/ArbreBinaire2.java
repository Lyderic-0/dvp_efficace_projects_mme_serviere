package entier.arbre;

public class ArbreBinaire<T extends Comparable<T>> {

    private Noeud<T> racine;

    public ArbreBinaire(){
        racine == null;
    }

    public boolean inserer(T valeur){
        if (racine == null){
            racine = new Noeud<T>(valeur);
            return true;
        } else {
            return racine.inserer(valeur);
        }
    }

    public boolean estPresente(T aChercher){
        if (racine == null){
            return false;
        }

        return racine.estPresente(aChercher);
    }



}