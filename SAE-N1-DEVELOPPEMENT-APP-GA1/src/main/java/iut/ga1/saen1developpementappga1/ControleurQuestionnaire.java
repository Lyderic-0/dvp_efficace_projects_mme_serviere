package iut.ga1.saen1developpementappga1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Contrôleur du questionnaire
 */
public class ControleurQuestionnaire {

    /** RETOUR : retour a la création du quiz */
    @FXML
    private void handleRetour(ActionEvent e) {
        Main.activerNouveauQuiz();
    }

}
