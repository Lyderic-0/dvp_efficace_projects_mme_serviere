package entier.recursif.entrainement;

public class FigureGeometrique {

   private int n ;
   public static void etoile(n){
       if (n > 0){
           System.out.print("*");
           etoile(n-1);
       }
   }

   private static void triangle(n){
       if (n > 0){

           etoile(n);

           triangle(n - 1);

       }
   }


   private static void isocele(int hauteur, int espace){
       if (hauteur > 0 && espace > 0){

          isocele(hauteur - 1, espace + 1);

          blank(espace);

          etoile(2*hauteur -1)

       }
   }



}