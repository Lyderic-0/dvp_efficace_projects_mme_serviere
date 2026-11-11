package iut.ga1.saen1developpementappga1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateurQuiz {

    private BanqueQuestions banqueQuestions;

    public GenerateurQuiz(BanqueQuestions banqueQuestions){
        this.banqueQuestions = banqueQuestions;
    }

    /*
     * Permet à partir d'une banque de question et de certains parametres comme Niveau, Categorie et nbQuestionDemandé
     * de générer un questionnaire
     */
    public Questionnaire generer(Niveau niveau, Categorie categorie, int nbQuestionDemandes){
        List<Question> questions = filtrerQuestions(niveau, categorie);

        // Mélanger les questions
        Collections.shuffle(questions);

        int nombreQuestionMin = Math.min(nbQuestionDemandes, questions.size());
        List<Question> questionsChoisies = questions.subList(0, nombreQuestionMin);

        String nomCategorie;
        if( categorie == null ){
            nomCategorie = null;
        } else {
            nomCategorie = categorie.getNom();
        }

        return new Questionnaire(nbQuestionDemandes, niveau, nomCategorie, questionsChoisies);
    }

    public int nbDisponibles(Niveau niveau, Categorie categorie){
        return filtrerQuestions(niveau, categorie).size();
    }


    /*
     * Permet d'appliquer un filtre aux questions de la banque en fonction du niveau et de la catégorie
     */
    private List<Question> filtrerQuestions(Niveau niveau, Categorie categorie) {
        // Sélection de la source (toutes les questions ou celles de la catégorie)
        List<Question> source;
        if (categorie == null) {
            source = banqueQuestions.toutesLesQuestions();
        } else {
            source = banqueQuestions.questionsDe(categorie);
        }

        List<Question> result = new ArrayList<>();
        if (source != null) {
            for (Question q : source) {
                boolean niveauOk = (niveau == Niveau.Indifferent) || (q.getNiveau() == niveau);
                if (niveauOk) {
                    result.add(q);
                }
            }
        }
        return result;
    }
}
