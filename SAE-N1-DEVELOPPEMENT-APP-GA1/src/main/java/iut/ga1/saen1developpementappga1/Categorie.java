package iut.ga1.saen1developpementappga1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Représente une catégorie de questions du quiz.
 */
public class Categorie {

    public static final String GENERALE = "Général";
    public static final int LONGUEUR_MAX_NOM = 50;

    private String nom;
    private List<Question> questions = new ArrayList<>();

    public Categorie(String nom) {
        setNom(nom);
    }

    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la catégorie en appliquant les règles de validation.
     *
     * @throws IllegalStateException Si la catégorie est "Général".
     * @throws IllegalArgumentException Si le nom est nul, vide ou dépasse 50 caractères.
     */
    public void setNom(String nouveauNom) {
        if (estGenerale() && !GENERALE.equalsIgnoreCase(nouveauNom)) {
            throw new IllegalStateException("La catégorie Général ne peut pas être modifiée.");
        }

        if (nouveauNom == null || nouveauNom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de la catégorie ne peut pas être vide.");
        }

        String nomNettoye = nouveauNom.trim();
        if (nomNettoye.length() > LONGUEUR_MAX_NOM) {
            throw new IllegalArgumentException("Le titre est trop long (maximum " + LONGUEUR_MAX_NOM + " caractères).");
        }

        this.nom = nomNettoye;
    }

    /**
     * Indique si cette catégorie est la catégorie réservée "Général".
     */
    public boolean estGenerale() {
        return GENERALE.equalsIgnoreCase(this.nom);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Retourne le nombre total de questions dans cette catégorie.
     */
    public int nbQuestions() {
        return questions.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categorie categorie)) return false;
        return this.nom.equalsIgnoreCase(categorie.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom.toLowerCase());
    }

    @Override
    public String toString() {
        return nom;
    }
}