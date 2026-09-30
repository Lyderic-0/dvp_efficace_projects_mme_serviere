/*
 * Application permettant de compter le nombre d'occurences d'une lettre dans une chaîne
 * fichier TP2EX2AnalyseChaine.java                                     02/22
 */
package iut.but.informatique.exemple.premierprojetjavafx;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * Cette application propose à l'utilisateur de saisir une chaîne de caractères et une
 * lettre. Elle affiche ensuite le nombre d'occurences de la lettre dans cette chaîne.
 * En cas d'erreur de saisie, l'utilisateur est informé via une boîte d'alerte
 * @author Utilisateur
 *
 */
public class TP2EX2AnalyseChaineMVC extends Application {
    
	@Override
    public void start(Stage primaryStage) throws Exception {
        // créaton d'un chargeur de code FXML
        FXMLLoader chargeurFXML = new FXMLLoader();
        
        /*
         *  on indique au chargeur quelle est la vue fxml qu'il devra charger :
         *  ici VueAnalyseChainePerf.fxml
         */
        chargeurFXML.setLocation(getClass().getResource("VueAnalyseChainePerf.fxml"));
        
        /*
         *  création d'un objet de type parent qui est initialisé avec le résultat du chargement
         *  de la vue FXML. Ou dit autrement le code écrit en FXML est transformé en un objet Java
         */
        Parent racine = chargeurFXML.load();
        
        Scene scene = new Scene(racine);                
        
        // on définit le titre, la hauteur et la largeur de la fenêtre
        primaryStage.setTitle("Analyse d'un texte (MVC)");
        primaryStage.setHeight(400);
        primaryStage.setWidth(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Programme principal
     * @param args  argument non utilisé
     */
    public static void main(String[] args) {
        launch(args);
    }
}
