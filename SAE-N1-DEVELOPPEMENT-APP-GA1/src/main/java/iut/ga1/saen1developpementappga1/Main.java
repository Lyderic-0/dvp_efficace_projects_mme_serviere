package iut.ga1.saen1developpementappga1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

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
    private static Scene sceneQuestionnaire;
    private static Scene sceneImportation;
    private static Scene sceneHistorique;
    private static Scene sceneConnexion;
    private static Scene sceneParametre;
    private static Scene sceneResultat;

    /* Navigation */

    public static void activerMenu() {

        afficher(sceneMenu);
    }

    public static void activerNouveauQuiz() {

        afficher(sceneNouveauQuiz);
    }
    
    public static void activerQuestionnaire() {

        afficher(sceneQuestionnaire);
    }

    public static void activerResultat() {

        afficher(sceneResultat);
    }

    public static void activerQuestion() {

        afficher(sceneQuestion);
    }

    public static void activerImportation() {

        afficher(sceneImportation);
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
        URL resource = Main.class.getResource(fichierFxml);
        if (resource == null) {
            throw new IllegalArgumentException("Fichier FXML introuvable : " + fichierFxml
                    + ". Vérifiez qu'il se trouve dans src/main/resources/iut/ga1/saen1developpementappga1/");
        }
        FXMLLoader loader = new FXMLLoader(resource);
        return new Scene(loader.load(), LARGEUR, HAUTEUR);
    }

    // Démarrage

    @Override
    public void start(Stage stage) throws IOException {
        fenetre = stage;

        sceneMenu = charger("menu/MenuVue.fxml");
        sceneNouveauQuiz = charger("nouveauQuiz/nouveauQuiz.fxml");
        sceneQuestionnaire    = charger("questionnaire/questionnaire.fxml");
        //TODO sceneResultat    = charger("resultat/resultat.fxml");
        //TODO sceneImportation    = charger("importationQuestion/importation.fxml");
        //TODO sceneQuestion    = charger("question/question.fxml");
        //TODO sceneHistorique  = charger("historique/HistoriqueVue.fxml");
        //TODO sceneConnexion   = charger("connexion/ConnexionVue.fxml");
        //TODO sceneParametre   = charger("parametre/ParametreVue.fxml");

        stage.setTitle("CamHoot - Quiz de connaissances");
        stage.setResizable(false);
        stage.setScene(sceneMenu);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}