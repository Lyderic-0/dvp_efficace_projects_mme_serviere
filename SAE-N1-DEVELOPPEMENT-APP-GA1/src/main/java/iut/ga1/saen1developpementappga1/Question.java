package iut.ga1.saen1developpementappga1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private Niveau niveau;
    private Categorie categorie; //Appel à la catégorie

    private String libelle;
    private String reponsejuste;
    private String feedback;


    private List<String> reponsesFausses;

    public Question(String libelle, Categorie categorie, Niveau niveau, String reponsejuste,
                    List<String> reponsesFausses, String feedback){
        this.libelle = libelle;
        this.categorie = categorie;
        this.niveau = niveau;
        this.reponsejuste = reponsejuste;
        this.reponsesFausses = reponsesFausses;
        this.feedback = feedback;
    }



    public boolean equals(Object autreQuestion){
        if ( autreQuestion == null || autreQuestion.getClass() != this.getClass() || this.categorie == null
                                   || this.reponsejuste == null || this.reponsesFausses == null || this.libelle == null){
            return false;
        }

        Question question = (Question) autreQuestion;

        // Deux question sont égales si : le libellé est égal, même catégorie, même proposition réponses
        if (this.libelle.equals(question.libelle) && this.categorie.equals(question.categorie)
                && this.reponsejuste.equals(question.reponsejuste)
                && this.reponsesFausses.equals(question.reponsesFausses)){
            return true;
        }

        return false;

    }

    public boolean estJuste(String reponseDonnee){
        return this.reponsejuste.equals(reponseDonnee);
    }

    public List<String> melanger(){
        List<String> melangeur = new ArrayList<>();
        melangeur.add(reponsejuste);
        melangeur.addAll(reponsesFausses);
        Collections.shuffle(melangeur);

        return melangeur;
    }

    public String getDetails(){
        return "Libelle :" + this.libelle + "\nCategorie : " + this.categorie + "\nNiveau : " + this.niveau
                           + "\nReponse juste : " + this.reponsejuste + "\nRéponses fausses : " + this.reponsesFausses
                           + "\nFeedback : " + this.feedback;
    }

    public Niveau getNiveau(){
        return this.niveau;
    }

    public Categorie setCategorie(Categorie categorie){
        return this.categorie = categorie;
    }


}
