package iut.ga1.saen1developpementappga1;

import java.util.ArrayList;
import java.util.List;

public class BanqueQuestions {

    private List<Categorie> categories = new ArrayList<>();

    public List<Categorie> getCategories() {
        return categories;
    }

    public Categorie ajouterCategorie(String nom) {
        Categorie nouvelleCategorie = new Categorie(nom);
        categories.add(nouvelleCategorie);
        return nouvelleCategorie;
    }

    public void supprimerCategorie(Categorie categorie) {
        categories.remove(categorie);
    }

    public void renommerCategorie(Categorie categorie, String nom) {
        if (categorie != null) {
            categorie.setNom(nom);
        }
    }

    public void ajouterQuestion(Question question, Categorie categorie) {
        if (categorie != null) {
            categorie.getQuestions().add(question);
        }
    }

    public void supprimerQuestion(Question question, Categorie categorie) {
        if (categorie != null) {
            categorie.getQuestions().remove(question);
        }
    }

    /**
     * Remplace une question existante par une nouvelle instance dans la catégorie ( questionAncienne -> nouvelleQuestion ).
     */
    public void modifierQuestion(Question questionAncienne, Question nouvelleQuestion, Categorie categorie) {
        if (categorie != null) {
            categorie.getQuestions().remove(questionAncienne);
            categorie.getQuestions().add(nouvelleQuestion);
        }
    }

    /**
     * Retire la question de sa catégorie d'origine pour l'ajouter à la destination.
     */
    public void deplacerQuestion(Question question, Categorie categorieSource, Categorie categorieDestination) {
        if (categorieSource != null && categorieDestination != null) {
            categorieSource.getQuestions().remove(question);
            categorieDestination.getQuestions().add(question);
        }
    }

    /**
     * Vérifie si la question est déjà enregistrée dans cette catégorie spécifique.
     */
    public boolean estDoublon(Question question, Categorie categorie) {
        return categorie != null && categorie.getQuestions().contains(question);
    }

    public List<Question> questionsDe(Categorie categorie) {
        return categorie != null ? categorie.getQuestions() : new ArrayList<>();
    }

    /**
     * Agrège et retourne l'ensemble des questions extraites de toutes les catégories.
     */
    public List<Question> toutesLesQuestions() {
        List<Question> toutesLesQuestions = new ArrayList<>();
        for (Categorie categorie : categories) {
            toutesLesQuestions.addAll(categorie.getQuestions());
        }
        return toutesLesQuestions;
    }

    public Categorie creerOuAjouterCategorie(String nom){
        for (Categorie categorie : categories){
            if (categorie.getNom().equalsIgnoreCase(nom)) {
                return categorie;
            }

        }
        return ajouterCategorie(nom);
    }
}