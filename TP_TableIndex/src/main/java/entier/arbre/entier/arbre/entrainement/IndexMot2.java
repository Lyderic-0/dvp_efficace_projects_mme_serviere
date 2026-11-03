package main.java.entier.arbre.entier.arbre;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexMot {

    private HashMap<String, ArrayList<Integer>> index;

    public IndexMot(){
        index = new HashMap<>();
    }

    public boolean ajouterMot(String mot, int numeroPage){
        if (mot == null){
            return false;
        } else {

            ArrayList<Integer> listeNumero = index.get(nom);

            if (index.containsKey(mot)){
                if (index.containsValue(numeroPage)){
                    return false;
                } else{
                    if (listeNumero == null){
                        listeNumero = new ArrayList<>();
                        listeNumero.add(mot);
                        index.put(mot, listeNumero);
                    } else {
                        if (!listeNumero.contains(numeroPage)){
                            listeNumero.add(numeroPage);
                            index.put(mot, listeNumero);
                        }
                    }

                }
            }
        }
    }
}