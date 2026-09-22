package heritage;

import java.util.Scanner;

/*
 * Permet de re-travailler la notion de polymorphisme
 * avec les classes individu et personne.
 */
public class Main2 {

    /*
     * ...
     * @param args
     */
    public static void main(String[] args) {

        int nbElements = 5;
        String instanceType;

        // Instanciation du tableau de type Individu car classe mère
        Individu[] TableauDemoPolyIndividu  = new Individu[nbElements];


        Scanner entree = new Scanner(System.in);
        boolean estBonType = false;
        for (int compteur = 0; compteur < nbElements ; compteur++){

            System.out.println("Souhaitez vous créer une instance de Individu ou de Personne : ");
            do {
                instanceType = entree.nextLine();
                estBonType = instanceType.equalsIgnoreCase("Personne") || instanceType.equalsIgnoreCase("Individu");

                if (!estBonType){
                    System.out.println("Le type de l'instance n'est pas connu, " +
                                     "choisissez entre Individu et Personne : ");
                }
            } while (!estBonType);


            /*
             * Instancie les types choisis puis l'utilisateur peut saisir les
             * composantes et le programme les affichent
             */
            if (instanceType.equalsIgnoreCase("Personne")){
                TableauDemoPolyIndividu[compteur] = new Personne();
            } else if (instanceType.equalsIgnoreCase("Individu")){
                TableauDemoPolyIndividu[compteur] = new Individu();
            }

            // Liaison dynamique
            TableauDemoPolyIndividu[compteur].saisir();
            System.out.println(TableauDemoPolyIndividu[compteur]);
        }
    }
}
