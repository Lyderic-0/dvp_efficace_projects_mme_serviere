package heritage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe décrivant une personne avec comme caractéristiques :
 * - un nom et un prénom hérités de la classe Individu
 * - un numéro de téléphone
 * - une adresse électronique
 *
 * @author INFOS
 * @version 1.0
 */
public class Personne extends Individu {

    /**
     * Déclaration d'un objet Scanner pour effectuer les saisies
     */
    private static Scanner entree = new Scanner(System.in);

    /**
     * Constante pour l'adresse électronique par défaut
     */
    private static final String MAIL_DEFAUT = "inconnu@inconnu";

    /**
     * Attribut adresse électronique
     */
    private String email;

    /**
     * Attribut numéro de téléphone
     */
    private Telephone tel;


    /*
     * Pattern regex pour une email
     */
    Pattern patternRegexEmail = Pattern.compile("^[a-zA-Z0-9-_.]+@[a-zA-Z0-9-_]+\\.[a-zA-Z]{2,3}$");

    /*
     * Matcher utilisé avec le pattern regex
     */
    Matcher matcher;

    /**
     * Constructeur par défaut
     */
    public Personne() {
        // L'appel à super() est automatique
        tel = new Telephone();         // création du numéro de téléphone
        email = MAIL_DEFAUT;           // affectation du mail par défaut
    }

    /**
     * Constructeur avec en paramètre le nom et le prénom. Le téléphone et
     * l'adresse mail sont initialisés par défaut.
     *
     * @param leNom    le nom de la personne
     * @param lePrenom le prénom de la personne
     */
    public Personne(String leNom, String lePrenom) {
        super(leNom, lePrenom);        // appel au constructeur de Individu
        tel = new Telephone();         // création du numéro de téléphone
        email = MAIL_DEFAUT;           // affectation du mail par défaut
    }

    /**
     * Constructeur avec en paramètre les 4 informations décrivant une personne.
     * Si l'adresse mail est invalide, c'est la valeur par défaut qui est affectée.
     *
     * @param leNom       le nom de la personne
     * @param lePrenom    le prénom de la personne
     * @param leTelephone le numéro de téléphone
     * @param leMail      l'adresse mail de la personne
     */
    public Personne(String leNom, String lePrenom, String leTelephone, String leMail) {
        super(leNom, lePrenom);              // appel au constructeur de Individu
        tel = new Telephone(leTelephone);    // création du numéro de téléphone

        // Matcher comparé au pattern regex
        matcher = patternRegexEmail.matcher(leMail);
        email = (matcher.matches() ? MAIL_DEFAUT : leMail.trim());
    }

    @Override
    public void afficher(){
        super.afficher();

        System.out.println("Email ........... : " + email + '\n'
                + "Tel ........ : " + tel.getNumero());
    }

    @Override
    public void saisir(){
        super.saisir();
        tel.saisir();
        boolean correct = false;

        do {
            System.out.print("Email ......... ? ");
            email = entree.nextLine();
            email = (email.trim().length() == 0 ? MAIL_DEFAUT : email.trim());

            // Matcher comparé au pattern regex
            matcher = patternRegexEmail.matcher(email);
            correct = matcher.matches();

            if (!correct) {
                System.out.println("Email invalide. Recommencez ! ");
            }
        } while (!correct);

    }

    public String information(){
        return super.toString() + "\n" + tel.getNumero() + "\n" + email;
    }
}