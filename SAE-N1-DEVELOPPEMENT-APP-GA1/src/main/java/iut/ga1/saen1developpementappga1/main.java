package iut.ga1.saen1developpementappga1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe principale : crée les scènes au démarrage et gère la navigation.
 */
public class Main extends Application {

    private static final double LARGEUR = 1100;
    private static final double HAUTEUR = 620;

    private static Stage fenetre;

    private static Scene sceneMenu;
    private static Scene sceneNouveauQuiz;
    private static Scene sceneQuestion;
    private static Scene sceneHistorique;
    private static Scene sceneConnexion;
    private static Scene sceneParametre;

    //  Navigation 

    public static void activerMenu() {
        afficher(sceneMenu);
    }

    public static void activerNouveauQuiz() {
        afficher(sceneNouveauQuiz);
    }

    public static void activerQuestion() {
        afficher(sceneQuestion);
    }

    public static void activerHistorique() {
        afficher(sceneHistorique);
    }

    public static void activerConnexion() {
        afficher(sceneConnexion);
    }

    public static void activerParametre() {
        afficher(sceneParametre);
    }

    /** Affiche la scène, ou signale qu'elle n'est pas encore faite. */
    private static void afficher(Scene scene) {
        if (scene == null) {
            System.out.println("Écran pas encore disponible.");
        } else {
            fenetre.setScene(scene);
        }
    }

    // Chargement

    /** Charge un fichier FXML (même package que Main) et crée la scène. */
    private static Scene charger(String fichierFxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(fichierFxml));
        return new Scene(loader.load(), LARGEUR, HAUTEUR);
    }

    // Démarrage

    @Override
    public void start(Stage stage) throws IOException {
        fenetre = stage;

        sceneMenu = charger("MenuVue.fxml");
        sceneNouveauQuiz = charger("nouveau_quiz.fxml");
        //TODO sceneQuestion    = charger("QuestionVue.fxml");
        //TODO sceneHistorique  = charger("HistoriqueVue.fxml");
        //TODO sceneConnexion   = charger("ConnexionVue.fxml");
        //TODO sceneParametre   = charger("ParametreVue.fxml");

        stage.setTitle("CamHoot - Quiz de connaissances");
        stage.setResizable(false);
        stage.setScene(sceneMenu);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}