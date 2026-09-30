package structuredonnees.ensemble;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Cette classe correspond à la description d'un pays.
 * Un pays est décrit par son nom, et par la liste de ses pays limitrophes.
 *
 * @author INFO2
 * @version 1.0
 */
public class Pays {

    /** Attribut égal au nom du pays */
    private String nom;

    /** Ensemble des pays limitrophes */
    private TreeSet<String> limitrophe;

    /**
     * Vérifie si un nom de pays est valide.
     * @param chaine la chaîne à vérifier
     * @return true si le nom est non null et non vide
     */
    private static boolean nomValide(String chaine) {
        return chaine != null && !chaine.isBlank();
    }

    /**
     * Constructeur par défaut provoque une erreur.
     * @throws IllegalArgumentException levée dans tous les cas
     */
    public Pays() {
        throw new IllegalArgumentException(
                "Erreur constructeur Pays aucun nom de pays en argument.");
    }

    /**
     * Constructeur avec en argument le nom du pays à créer.
     * @param leNom une chaîne contenant le nom du pays
     * @throws IllegalArgumentException si le nom du pays n'est pas valide
     */
    public Pays(String leNom) {
        if (!nomValide(leNom)) {
            throw new IllegalArgumentException(
                    "Erreur constructeur Pays chaîne vide en argument.");
        }
        this.nom = leNom;
        this.limitrophe = new TreeSet<>();
    }

    /**
     * Constructeur avec en argument le nom du pays et des pays limitrophes.
     * @param leNomDuPays le nom du pays
     * @param voisin tableau contenant la liste des pays limitrophes
     * @throws IllegalArgumentException si un nom est invalide ou auto-voisinage
     */
    public Pays(String leNomDuPays, String[] voisin) {
        if (!nomValide(leNomDuPays)) {
            throw new IllegalArgumentException(
                    "Erreur constructeur Pays chaîne vide pour le nom du pays.");
        }
        this.nom = leNomDuPays;
        this.limitrophe = new TreeSet<>();

        if (voisin != null) {
            for (int i = 0; i < voisin.length; i++) {
                if (!nomValide(voisin[i])) {
                    throw new IllegalArgumentException(
                            "Erreur constructeur Pays chaîne vide pour un voisin.");
                }
                if (this.nom.equals(voisin[i])) {
                    throw new IllegalArgumentException(
                            "Un pays ne peut pas être voisin avec lui-même");
                }
                this.limitrophe.add(voisin[i]);
            }
        }
    }

    /**
     * Ajoute un pays limitrophe à l'ensemble.
     * @param unPays le nom du pays voisin à ajouter
     * @return true si le pays a été ajouté, false s'il était déjà présent
     * @throws IllegalArgumentException si le nom est invalide ou égal au pays lui-même
     */
    public boolean ajouterLimitrophe(String unPays) {
        if (!nomValide(unPays)) {
            throw new IllegalArgumentException("Nom de pays voisin invalide.");
        }
        if (this.nom.equals(unPays)) {
            throw new IllegalArgumentException("Un pays ne peut pas être voisin avec lui-même.");
        }
        return this.limitrophe.add(unPays);
    }

    /**
     * Détermine si le pays donné fait partie des pays limitrophes.
     * @param unPays le nom du pays à vérifier
     * @return true si le pays est limitrophe, false sinon
     */
    public boolean estLimitrophe(String unPays) {
        return unPays != null && this.limitrophe.contains(unPays);
    }

    /**
     * Détermine le nombre de pays limitrophes du pays courant.
     * @return le nombre de pays limitrophes
     */
    public int nombreLimitrophes() {
        return this.limitrophe.size();
    }

    /**
     * Détermine si la liste donnée coïncide avec l'ensemble des pays limitrophes.
     * @param liste la liste de pays à comparer
     * @return true si les ensembles coïncident, false sinon
     */
    public boolean coincide(ArrayList<String> liste) {
        if (liste == null) {
            return false;
        }
        return this.limitrophe.containsAll(liste) && liste.containsAll(this.limitrophe);
    }

    /**
     * Détermine le nombre de pays communs entre la liste et les limitrophes.
     * @param liste la liste des pays à analyser
     * @return le nombre de pays communs
     */
    public int nbPaysCommuns(ArrayList<String> liste) {
        if (liste == null) {
            return 0;
        }
        int nbCommuns = 0;
        for (String p : this.limitrophe) {
            if (liste.contains(p)) {
                nbCommuns++;
            }
        }
        return nbCommuns;
    }

    /** Accesseur nom */
    public String getNom() {
        return this.nom;
    }

    /** Accesseur ensemble limitrophe */
    public TreeSet<String> getLimitrophe() {
        return this.limitrophe;
    }

    @Override
    public String toString() {
        return "Pays : " + this.nom + " | Voisins : " + this.limitrophe;
    }
}