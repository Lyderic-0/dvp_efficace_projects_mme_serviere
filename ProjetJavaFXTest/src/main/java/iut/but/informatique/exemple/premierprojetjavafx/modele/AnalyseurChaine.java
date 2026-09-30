/*
 * Cette classe contient des opérations pour analyser le contenu d'une chaîne de caractères
 * AnalyseurChaine.java                                         05/24
 */
package iut.but.informatique.exemple.premierprojetjavafx.modele;


/**
 * Cette classe contient des opérations pour analyser le contenu d'une chaîne de caractères.
 * Celle-ci ne doit pas être vide.
 * Pour l'instant, une seule méthode est présente : celle qui compte le nombre d'apparitions
 * d'une lettre dans une chaîne
 * @version 1.0
 * @author C. Servières
 */
public class AnalyseurChaine {
    
    /** Chaîne par défaut à analyser */
    private static final String CHAINE_DEFAUT = " ";
    
    
    /** Message d'erreur si la chaîne à analyser est vide */
    private static final String ERREUR_CHAINE_VIDE = 
            "Erreur - la chaîne à analyser ne peut pas être vide";
    
    /** Message d'erreur si le caractère à compter est invalide : vide ou constitué de plusieurs
     *  caractères
     */
    private static final String ERREUR_CAR_INVALIDE = 
            "Erreur - Le caractère à compter est invalide";
    
    /** Message d'erreur si le caractère à compter est invalide : 
     * n'est pas une lettre
     */
    private static final String ERREUR_CAR_PAS_LETTRE = "Erreur - Le caractère à compter n'est pas une lettre";
    
    
    /** Chaîne à analyser */
    private String chaineAAnalyser;
    
    
    /**
     * Constructeur avec initialisation par défaut de la chaîne à analyser
     */
    public AnalyseurChaine() {
        chaineAAnalyser = CHAINE_DEFAUT;
    }
    
    
    /**
     * Réinitialise la chaîne à analyser avec la chaîne par défaut
     */
    public void reinitialiser() {
        chaineAAnalyser = CHAINE_DEFAUT;
    }
    
    /**
     * Modificateur de la chaîne à analyser
     * @param nouvelleChaine  nouvelle chaîne à analyser, elle ne doit pas être vide
     * @throw IllegalArgumentException   levée si la chaîne argument est vide
     */
    public void setChaineAAnalyser(String nouvelleChaine) {
        
        // si argument vide : exception
        if (nouvelleChaine == null || nouvelleChaine.length() == 0) {
            throw new IllegalArgumentException(ERREUR_CHAINE_VIDE);
        }
        
        // sinon : modification de la chaîne à analyser
        chaineAAnalyser = nouvelleChaine;
    }
    
    
    /**
     * Compte les occurrences de la lettre argument dans la chaîne à analyser
     * La chaîne argument pour être valide doit contenir un seul caractère : une lettre 
     * @param caractereACompter  une chaîne supposée contenir un seul caractère, une lettre
     * @return  un entier égal au nombre d'apparitions de la lettre argument dans la 
     *          chaîne à analyser
     * @throw IllegalArgumentException levée si la chaîne argument ne contient pas un unique
     *        caractère et si ce caractère n'est pas une lettre         
     */
    public int compterOccurrenceLettre(String caractereACompter) {
        
        // le caractère à compter est vide ou invalide, car composé de plusieurs caractères
        if (caractereACompter == null || caractereACompter.length() != 1) {
            throw new IllegalArgumentException(ERREUR_CAR_INVALIDE);
        }
        
        // sinon : un seul caractère à compter
        char aCompter = caractereACompter.charAt(0);
        int compteur;
        
        // si le caractère n'est pas une lettre : exception
        if (! Character.isLetter(aCompter)) {
            throw new IllegalArgumentException(ERREUR_CAR_PAS_LETTRE);
        }
        
        // on compte les occurences du caractère aCompter dans la chaîne à analyser
        compteur = 0;        
        for (int i = 0; i < chaineAAnalyser.length(); i++) {
            if (aCompter == chaineAAnalyser.charAt(i)) {
                compteur++;
            }
        }
        
        return compteur;        
    }
    
    
    

}
