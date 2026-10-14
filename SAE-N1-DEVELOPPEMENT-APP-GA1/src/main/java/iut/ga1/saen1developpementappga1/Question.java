package iut.ga1.saen1developpementappga1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class Question {
    private Niveau niveau;
    private String libelle;
    private String reponsejuste;
    private String feedback;

    private List<String> reponsesFausses;

    public boolean equals(Object autreQuestion){
        if (autreQuestion == null){
            return false;
        } else if ( autreQuestion == null || autreQuestion.getClass() != this.getClass()){
            return false;
        }

        Question question = (Question) autreQuestion;

        // TODO Coder les conditions de passement
        return true;
    }


}
