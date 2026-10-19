package iut.ga1.saen1developpementappga1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Contrôleur du formulaire « Nouvelle question »
 */
public class ControleurNouveauQuiz {

    /** RETOUR : retour au menu */
    @FXML
    private void handleRetour(ActionEvent e) {
        Main.activerMenu();
    }

    /** LANCER : Lance le quiz */
    @FXML
    private void handleLancer(ActionEvent e) {
        Main.activerQuestionnaire();
    }
}
