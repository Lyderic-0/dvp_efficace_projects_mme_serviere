package heritage;


public class Main {

    /*
     * Instancier et tester la classe personne et ces méthodes
     * @param args
     */
    public static void main(String[] args){
        Personne p = new Personne();
        Personne p2 = new Personne("INNOCENTI", "Axel");
        Personne p3 = new Personne("INNOCENTI", "Axel", "0612874563", "axel.innocenti@gmail.com");

        System.out.println("Les infos : ");
        p.afficher();
        System.out.print("\n");
        p2.afficher();
        System.out.print("\n");
        p3.afficher();
        System.out.print("\n");

        /* p.saisir();
        System.out.print("\n");
        p2.saisir();
        System.out.print("\n");
        p3.saisir(); */

        System.out.println("Saisie des infos pour p1");
        p3.saisir();
        System.out.println("Affichage des infos pour p1");
        p3.afficher();

        System.out.println("Informations......... : ");
        System.out.println("\nInformations P :\n");
        System.out.println(p.information());
        System.out.println("\nInformations P2 :\n");
        System.out.println(p2.information());
        System.out.println("\nInformations P3 :\n");
        System.out.println(p3.information());


    }


}
