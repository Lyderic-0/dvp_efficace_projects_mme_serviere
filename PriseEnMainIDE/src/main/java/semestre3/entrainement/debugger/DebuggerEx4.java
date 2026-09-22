package semestre3.entrainement.debugger;

public class DebuggerEx4 {

    public static void main(String[] args) {
        int rangACalcuer;
        int resultat;


        System.out.println("--- Début du calcul de la factorielle ---");

        rangACalcuer = 10;
        resultat = OutilRecursifEntier.factorielle(rangACalcuer);

        System.out.println("La factorielle de " + rangACalcuer + " est : " + resultat);
        System.out.println("--- Fin du programme ---");
    }


}
