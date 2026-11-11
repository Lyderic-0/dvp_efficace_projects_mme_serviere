package iut.ga1.saen1developpementappga1;

import java.util.ArrayList;
import java.util.List;

public class Questionnaire {

    private int nbSouhaite;
    private Niveau niveau;
    private String categorieNom;

    private List<Question> questions;

    public Questionnaire(){
        this.questions = new ArrayList<>();
    }

    public Questionnaire(int nbSouhaite, Niveau niveau, String categorieNom){
        this.nbSouhaite = nbSouhaite;
        this.niveau = niveau;
        this.categorieNom = categorieNom;
    }

    public Questionnaire(int nbSouhaite, Niveau niveau, String categorieNom, List<Question> questions){
        this.questions = (questions != null) ? new ArrayList<>(questions) : new ArrayList<>();
        this.nbSouhaite = nbSouhaite;
        this.niveau = niveau;
        this.categorieNom = categorieNom;
    }

    public List<Question> getQuestions(){
        return this.questions;
    }

    public int nbAffichable(){
        return Math.min(this.nbSouhaite, questions.size());
    }

    public boolean estIncomplet(){
        return questions.size() < nbSouhaite;
    }

    public boolean estVide(){
        return questions.isEmpty();
    }
}
