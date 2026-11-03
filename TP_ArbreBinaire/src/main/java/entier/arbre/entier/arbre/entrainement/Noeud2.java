package entier.arbre;

public class Noeud<T extends Comparable<T>> {

    private T valeur;
    private Noeud<T> sousArbreGauche;
    private Noeud<T> sousArbreDroit;

    private String chaine;

    public Noeud<T>(T valeur){
        this.valeur = valeur;
        this.sousArbreGauche = 0;
        this.sousArbreDroit = 0;
    }

    public boolean inserer(T aInserer){
        if (aInserer.compareTo(valeur) < 0){
            if (sousArbreGauche == null){
                sousArbreGauche = new Noeud<>(aInserer);

                return true;
            }else{
                sousArbreGauche.inserer(aInserer);
            }
        } else if (aInserer.compareTo(valeur) > 0){
            if (sousArbreGauche == null){
                sousArbreGauche = new Noeud<>(aInserer);
                return true;
            }else{
                sousArbreGauche.inserer(aInserer);
            } else {
                return false;
            }

        }
    }

    public boolean estPresente(T aChercher){
        if (aChercher.compareTo(valeur) == 0){
            return true;
        } else if (aChercher.compareTo(valeur) < 0){
            return sousArbreGauche.estPresente(aChercher);
        } else{
            return sousArbreDroit.estPresente(aChercher);
        }
    }

    public T getValeur() {
        return valeur;
    }

    public String chaineCarac(valeur){
        return StringBuilder(valeur.toString().append("  ")
                .append(if (sousArbreGauche == null ? "": chaineCarac()))
        )
    }
    public int trouverHauteur(){
        if (sousArbreGauche == null && sousArbreDroit == null){
            return 1;
        } else if (sousArbreGauche == null){
            return 1 + sousArbreDroit.trouverHauteur();
        } else if (sousArbreDroit == null){
            return 1 + sousArbreGauche.trouverHauteur();
        }

        return 1 + Math.max(sousArbreGauche.trouverHauteur(), sousArbreDroit.trouverHauteur());
    }


}
