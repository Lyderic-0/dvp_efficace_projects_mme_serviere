/*
 * Contrôleur de la vue qui permet de compter le nombre d'occurrences d'une lettre 
 * dans une chaîne
 * ControleurVueAnalyse.java                                        05/24
 */
package iut.but.informatique.exemple.premierprojetjavafx.controleur;

import iut.but.informatique.exemple.premierprojetjavafx.modele.AnalyseurChaine;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * Classe qui joue le rôle du contrôleur de la vue qui permet à l'utilisateur de saisir
 * une chaîne de caractères et une lettre. L'application affiche ensuite le nombre d'apparitions
 * de cette lettre dans la chaîne.
 * Ce contrôleur a été codé en appliquant le modèle MVC
 * @author C. Servières
 * @version 1.0
 *
 */
public class ControleurVueAnalyse {
    
    /** Champ de saisie de la chaîne à analyser */
    @FXML
    private TextField champChaine;

    /** Champ de saisie de la lettre à compter */
    @FXML
    private TextField champLettre;
    
    /** Etiquette qui affiche le nombre d'apparitions de la lettre */
    @FXML
    private Label champResultat;
    
    /** Analyseur pour la chaîne saisie */
    private AnalyseurChaine analyseur;

    
    /**
     * Méthode automatiquement appelée au chargement de la vue
     * On fait en sorte que l'utilisateur ne puisse saisir qu'un seul caractère
     * dans le champ nommé champLettre.
     * L'analyseur est créé et initialisé : d'une manière générale on créé dans 
     * cette méthode le modèle et on l'initialise
     */
    @FXML
    private void initialize() {
        setTextLimit(champLettre, 1);    
        analyseur  = new AnalyseurChaine();
    }
    
    /**
     * Méthode invoquée lors du clic sur le bouton Effacer.
     * L'interface est remise dans son état d'origine.
     */
    @FXML
    void gererClicEffacer() {
        champChaine.setText("");
        champLettre.setText("");
        champResultat.setText(". . .");
        analyseur.reinitialiser();
    }

    /**
     * Méthode invoquée lors du clic sur le bouton Compter.
     * On récupère les informations saisies. Si l'une des saisie est incorrecte
     * (valeur non renseignée, caractère à compter qui n'est pas une lettre) :
     * une boîte d'alerte de type Erreur est affichée.
     * Dans le cas contraire, le nombre d'occurrences de la lettre est affichée
     * dans l'étiquette champResultat
     */
    @FXML
    void gererClicCompter() {
        // on récupère sous forme de chaîne, les 2 saisies de l'utilisateur
        String chaineSaisie = champChaine.getText();
        String chaineLettre = champLettre.getText();
        int compteur = 0;    // nombre d'apparitions de la lettre dans la chaîne
        
        /*
         * Si l'une des saisies est vide : une boîte d'alerte informe l'utilisateur
         *  de son erreur
         */
        if (chaineSaisie.length() == 0 || chaineLettre.length() == 0) {
            Alert boiteAlerte = 
                    new Alert(Alert.AlertType.ERROR,
                          "Au moins un champ n'a pas été renseigné");                        
            boiteAlerte.setTitle("Analyse d'un texte");
            boiteAlerte.setHeaderText("Erreur");        
            boiteAlerte.showAndWait();   
        } else {
            
            // prise en compte de la chaîne saisie par l'analyseur
            analyseur.setChaineAAnalyser(chaineSaisie);
            
            try {
                compteur = analyseur.compterOccurrenceLettre(chaineLettre);
                
                // le compteur est affiché
                champResultat.setText(String.valueOf(compteur));
                
            } catch(IllegalArgumentException erreur) {
                
                // chaineLettre ne contient pas une lettre unique
                Alert boiteAlerte = 
                        new Alert(Alert.AlertType.ERROR,
                              erreur.getMessage());                        
                boiteAlerte.setTitle("Analyse d'un texte");
                boiteAlerte.setHeaderText("Erreur");        
                boiteAlerte.showAndWait(); 
            }
           
        }
       
    }
    
    
    /**
     * Méthode permettant de faire en sorte que l'utilisateur ne puisse
     * saisir, au maximum, qu'un certain nombre de caractères
     * @param zoneDeSaisie   champ de saisie dont on veut limiter le nombre 
     *                       de caractères
     * @param nbMaxCaractere   nombre maximum de caractères à saisir
     */
    private static void setTextLimit(TextField zoneDeSaisie, int nbMaxCaractere) {
        /*
         * Si le nombre de caractères saisis dépasse la valeur nbMaxCaractere,
         * on extrait de la chaîne saisie  le début de cette chaîne
         * (dont entre les indices 0 et nbMaxCaractere - 1)
         * Cette sous-chaîne est affichée dans la zoneDeSaisie
         * Grâce à l'appel à positinCaret, le curseur est placé en fin de chaîne
         */
        zoneDeSaisie.setOnKeyTyped(event -> {
            String string = zoneDeSaisie.getText();

            if (string.length() > nbMaxCaractere) {
                zoneDeSaisie.setText(string.substring(0, nbMaxCaractere));
                zoneDeSaisie.positionCaret(string.length());
            }
        });
    }
}

