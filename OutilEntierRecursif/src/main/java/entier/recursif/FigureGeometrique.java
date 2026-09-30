package entier.recursif;

public class FigureGeometrique {

    public static void blanc (int n){
        if (n > 0){
            System.out.print('*');
            blanc(n - 1);
        }
    }

    public static void etoile (int n){
        if (n > 0){
            System.out.print('*');
            etoile(n - 1);
        } else if (n == 0){
            System.out.print("\n");
        }
    }

    public static void triangle (int hauteur, int largeur){
        
    }


}
