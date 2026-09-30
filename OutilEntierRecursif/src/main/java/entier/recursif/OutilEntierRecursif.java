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

    public static void main() {
        System.out.printf("Suite de fibo pour n=10 est : " + Fibonnacci(10) + "\n");
        FigureGeometrique.etoile(4);
    }
}
