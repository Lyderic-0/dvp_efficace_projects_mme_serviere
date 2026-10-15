package iut.ga1.saen1developpementappga1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Contrôleur du menu principal
 * Chaque bouton demande à Main d'afficher la scène correspondante
 */
public class ControleurMenu {

    /** JOUER : lance l'écran « Nouveau quiz » */
    @FXML
    private void handleJouer(ActionEvent e) {
        Main.activerNouveauQuiz();
    }

    /** QUESTIONS : gestion des catégories et de la banque de questions */
    @FXML
    private void handleQuestion(ActionEvent e) {
        Main.activerQuestion();
    }

    /** HISTORIQUE : liste des dernières tentatives */
    @FXML
    private void handleHistorique(ActionEvent e) {
        Main.activerHistorique();
    }

    /** CONNEXION : échange de questions avec un autre ordinateur */
    @FXML
    private void handleConnexion(ActionEvent e) {
        Main.activerConnexion();
    }

    /** PARAMÈTRES : nom du joueur, tentatives conservées, IP & port, notice */
    @FXML
    private void handleParametre(ActionEvent e) {
        Main.activerParametre();
    }

    /** QUITTER : ferme l'application */
    @FXML
    private void handleQuitter(ActionEvent e) {
        Platform.exit();
    }
}