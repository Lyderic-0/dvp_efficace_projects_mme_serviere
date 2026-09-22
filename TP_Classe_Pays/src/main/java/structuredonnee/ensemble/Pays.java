/*
 * Test de la classe Pays
 * TestPays.java                        09/22
 */
package structuredonnee.ensemble;

import java.util.ArrayList;



/**
 * Tests unitaires des principales méthodes de la classe Pays
 * @author C. Servières
 * @version 1.0
 */
public class Pays {

    private TreeSet<String> paysLimitrophes;
    private String nomPays;

    private String regexPays = "[a-zA-Z]";
    private Pattern p = Pattern.compile(regexPays);
    private Matcher mPrincipal;
    private Matcher mSecondaire;

    public Pays(String nomPays){
        mPrincipal = p.matcher(nomPays);
        boolean nomPaysValide = mPrincipal.matches();

        if (!nomPaysValide){
            throws new IllegalArgumentException();
        }

        this.paysLimitrophes = new TreeSet<>();
        this.nomPays = nomPays;
    }

    public Pays(int nomPays, String[] paysVoisins){
        mPrincipal = p.matcher(nomPays);
        mSecondaire = p.matcher(paysVoisins);
        boolean nomPaysValide = mPrincipal.matches();
        boolean nomPaysSecondaireValide = mSecondaire.matches();

        if (!nomPaysValide || !nomPaysSecondaireValide){
            throws new IllegalArgumentException();
        }
    }

    public toString(){
        
    }



}