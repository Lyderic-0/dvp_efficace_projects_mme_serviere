package main.java.entier.arbre.entier.arbre;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexMot {


    private HashMap<String, ArrayList<Integer>> index;

    public IndexMot(){
        index = new HashMap<>();
    }

    public boolean ajouterMot(String mot, int page){

        if (mot == null || page <= 0 ){
            return false;
        }



        // TODO Faire gestion boollean

        ArrayList<Integer> listePages;
        if (this.index.containsKey(mot)){

            listePages = index.get(mot);
            if (!listePages.contains(page)){
                listePages.add(page);
                return true;
            }

        } else {
            listePages = new ArrayList<>();
            listePages.add(page);
            index.put(mot, listePages);
        }



        return false;

    }
}