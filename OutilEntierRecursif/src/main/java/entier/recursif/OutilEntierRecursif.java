package entier.recursif;

import static entier.recursif.FigureGeometrique.etoile;

public class OutilEntierRecursif {

    public static int fibonnacci(int rangN){
        if (rangN == 1) {
            return 1;
        } else if (rangN == 0){
            return 0;
        }
        return fibonnacci(rangN - 1 ) + fibonnacci(rangN - 2);
    }

    public static int Fibonnacci(int rangN){
        if (rangN < 0){
            throw new IllegalArgumentException("Le rang doit être supérieur à 0");
        }

        return fibonnacci(rangN);
    }

    public static void initialiser(int[] tab, int valeur) {
        initialiser(tab, valeur, 0);
    }

    private static void initialiser(int[] tab, int valeur, int index) {
        if (tab != null && index >= 0 && index < tab.length) {
            tab[index] = valeur;
            initialiser(tab, valeur, index + 1);
        }
    }

    public static int ackermann(int m, int n) {
        if (m < 0 || n < 0) {
            return -1;
        }
        if (m == 0) {
            return n + 1;
        }
        if (n == 0) {
            return ackermann(m - 1, 1);
        }
        return ackermann(m - 1, ackermann(m, n - 1));
    }

    public static void main(String[] args) {
        System.out.printf("Suite de fibo pour n=10 est : " + Fibonnacci(10) + "\n");
    }
}
