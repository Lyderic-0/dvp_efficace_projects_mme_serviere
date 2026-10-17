package iut.ga1.saen1developpementappga1;

import java.util.ArrayList;
import java.util.List;

public class ResultatImport {

    private int importees;
    private int doublons;
    private List<String> erreurs = new ArrayList<>();
    private List<String> categoriesCrees = new ArrayList<>();

    // Permet de donner résumé complet, par exemple pour l'utilisateur
    public String resume(){
        return "Nombres lignes importés : " + importees + "\n" +
               "Doublons : " + doublons + "\n" +

                // String.join permet une construction d'une chaine de chars séparés par des -
               "Erreurs : " + String.join("-", erreurs) + "\n" +
               "CategoriesCrees : " + String.join("-", categoriesCrees);
    }

    public int getImportees(){
        return importees;
    }

    public int getDoublons(){
        return doublons;
    }

    public List<String> getErreurs(){
        return erreurs;
    }

    public List<String> getCategoriesCrees(){
        return categoriesCrees;
    }

    public void setImportees(int importees) {
        this.importees = importees;
    }

    public void setDoublons(int doublons) {
        this.doublons = doublons;
    }

}
