package entier.recursif;

public class FigureGeometrique {

    public static void blanc(int n) {
        if (n > 0) {
            System.out.print(' ');
            blanc(n - 1);
        }
    }

    public static void etoile(int n) {
        if (n > 0) {
            System.out.print('*');
            etoile(n - 1);
        } else if (n == 0) {
            System.out.println();
        }
    }

    public static void triangle(int hauteur) {
        if (hauteur > 0) {
            triangle(hauteur - 1);
            etoile(hauteur);
        }
    }

    public static void triangleIsocele(int n) {
        triangleIsocele(n, n);
    }

    private static void triangleIsocele(int n, int total) {
        if (n > 0) {
            triangleIsocele(n - 1, total);
            blanc(total - n);
            etoile(2 * n - 1);
        }
    }



}