package iut.ga1.saen1developpementappga1;

import java.util.Objects;

/**
 * Modèle Categorie (US.MCQ001).
 * Permet de créer et représenter une catégorie de questions.
 */
public class Categorie {

    public static final int LONGUEUR_MAX_NOM = 50;
    public static final String CATEGORIE_PAR_DEFAUT = "Général";

    private String nom;

    /**
     * Constructeur de Categorie.
     * @param nom Le nom de la catégorie (max 50 caractères, non vide).
     */
    public Categorie(String nom) {
        setNom(nom);
    }

    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de la catégorie avec validation métier (US.MCQ001).
     * @param nouveauNom Le nouveau nom à appliquer.
     * @throws IllegalStateException Si la catégorie est "Général" et qu'on tente de la renommer.
     * @throws IllegalArgumentException Si le nom est nul, vide ou dépasse 50 caractères.
     */
    public void setNom(String nouveauNom) {
        if (estCategorieParDefaut() && !CATEGORIE_PAR_DEFAUT.equalsIgnoreCase(nouveauNom)) {
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
     * Vérifie s'il s'agit de la catégorie réservée "Général".
     */
    public boolean estCategorieParDefaut() {
        return CATEGORIE_PAR_DEFAUT.equalsIgnoreCase(this.nom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Categorie categorie)) {
            return false;
        }

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