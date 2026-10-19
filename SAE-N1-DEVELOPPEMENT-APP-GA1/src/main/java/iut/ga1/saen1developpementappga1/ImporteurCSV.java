package iut.ga1.saen1developpementappga1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ImporteurCSV {

    // Séparateur CSV
    private char separateur = ';';
    private BanqueQuestions banqueQuestion;

    public ImporteurCSV(BanqueQuestions banqueQuestion){
        this.banqueQuestion = banqueQuestion;
    }

    /*
     * Importe le fichier et vérifier qu'il ne contient pas d'erreurs, si oui alors elles seront renvoyés dans
     * resultatImport
     */
    public ResultatImport importerFichier(File fichier){
        ResultatImport resultatImport = new ResultatImport();

        if (fichier == null || !fichier.exists()) {
            resultatImport.getErreurs().add("Le fichier est introuvable ou invalide.");
            return resultatImport;
        }

        try {
            // Lecture de toutes les lignes du fichier CSV
            List<String> lignes = Files.readAllLines(fichier.toPath(), StandardCharsets.UTF_8);

            // Renvoie traitement à importerListe afin de ne pas surcharger une seule méthode
            return importerListe(lignes);

        } catch (IOException e) {
            resultatImport.getErreurs().add("Impossible de lire le fichier : " + e.getMessage());
            return resultatImport;
        }
    }

    public ResultatImport importerListe(List<String> liste){

        ResultatImport resultat = new ResultatImport();
        String[] colonnes = null;

        // Pour chaque ligne, on récupére les colonnes de la ligne (attributs) et on les fait vérfier par vérifierLigne
        for (String ligne : liste) {

            // Enlève espace si y'en a
            if (ligne == null || ligne.trim().isEmpty()) {
                continue;
            }

            colonnes = ligne.split(String.valueOf(separateur));

            if (!verifierLigne(colonnes)) {
                resultat.getErreurs().add("Ligne invalide : " + ligne);
                continue;
            }

            // Ajout chaques attributs leurs valeurs validés par verifierLigne
            String nomCategorie = colonnes[0].trim();
            Niveau niveau        = Niveau.valueOf(colonnes[1].trim().toUpperCase());
            String libelle       = colonnes[2].trim();
            String reponseJuste  = colonnes[3].trim();
            List<String> reponsesFausses = new ArrayList<>();


            for (int i = 4; i < colonnes.length; i++) {
                String reponse = colonnes[i].trim();
                reponsesFausses.add(reponse);
            }

            Categorie categorie = banqueQuestion.creerOuAjouterCategorie(nomCategorie);

            Question question = new Question(libelle, categorie, niveau,
                    reponseJuste, reponsesFausses, "");

            if (banqueQuestion.estDoublon(question, categorie)) {
                resultat.getErreurs().add("Question déjà présente (ignorée) : " + libelle);
                continue;
            }

            banqueQuestion.ajouterQuestion(question, categorie);
        }



        return resultat;
    }

    /*
     * Vérifie si le tableau issu du découpage d'une ligne CSV respecte le format attendu.
     */
    public boolean verifierLigne(String[] colonnes) {
        // 5 Attributes nécéssaire fixés ( libellé, categorie, reponseJuste, réponseFausse et niveau)
        if (colonnes == null || colonnes.length < 5 || colonnes.length > 8) {
            return false;
        }

        String categorie = colonnes[0].trim();
        String niveauStr = colonnes[1].trim();
        String libelle = colonnes[2].trim();
        String reponseJuste = colonnes[3].trim();


        if (categorie.isEmpty() || libelle.isEmpty() || reponseJuste.isEmpty() || niveauStr.isEmpty()) {
            return false;
        }

        // Vérifie que les réponses fausses sont pas vides
        for (int i = 4; i < colonnes.length; i++) {
            String reponse = colonnes[i].trim();
            if (reponse.isEmpty()) {
                return false;
            }
        }

        try {
            Niveau.valueOf(niveauStr.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return false;
        }

        return true;
    }

}
