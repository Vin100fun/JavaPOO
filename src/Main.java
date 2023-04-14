import Classes.*;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Limite et axes d'améliorations :
 * - Les tests peuvent être automatisés en java
 * - Ces mêmes tests pourraient couvrir plus de cas
 * - Avec Github un pipeline d'intégration continue est envisageable
 * - Les fonctions sont implémentés et testés, mais ne servent pas en tant que tel
 */
public class Main {

    public static void main(String[] args) throws IOException {
        int nRet = 0;
        Scanner clavier = new Scanner(System.in);

        while (nRet != -1) {
            System.out.println("Quelle fonction tester ? :");
            System.out.println("1- Renverser une chaine");
            System.out.println("2- Pyramide d'une chaine");
            System.out.println("3- Calcul de la somme des nombres");
            System.out.println("4- Nombre premier, pair ou impair");
            System.out.println("5- Jeu du juste nombre");
            System.out.println("6- Compter les mots dans une phrase");
            System.out.println("7- Sauvegarder une entrée dans un fichier");
            System.out.println("8- Compter le nombre de mots dans un fichier");
            System.out.println("9- Pour tester l'implémentation des classes");
            System.out.println("10- Pour tester l'implémentation des Singleton");
            System.out.println("11- Pour tester la Serialisation puis DéSerialisation");
            System.out.println("-1 Pour quitter");
            nRet = inputNumber();
            switch (nRet) {
                case 1:
                    reverseChaine();
                    break;
                case 2:
                    pyramideChaine();
                    break;
                case 3:
                    sumNumber();
                    break;
                case 4:
                    isPremier();
                    break;
                case 5:
                    searchNumber();
                    break;
                case 6:
                    clavier = new Scanner(System.in);
                    System.out.println("Veuillez rentrer une phrase à enregistrer :");
                    String sRet = clavier.nextLine();
                    System.out.println(sumWords(sRet));
                    break;
                case 7:
                    clavier = new Scanner(System.in);
                    System.out.println("Veuillez rentrer une phrase à enregistrer :");
                    String phrase = clavier.nextLine();
                    System.out.println("Dans quel fichier l'enregister ? :");
                    String nomFichier = clavier.nextLine();
                    savetoTXT(phrase, nomFichier);
                    break;
                case 8:
                    ReadFileAndSumWords();
                    break;
                case 9:
                    testClasses();
                    break;
                case 10:
                    testSingleton();
                    break;
                case 11:
                    Utilisateur utilisateur = new Utilisateur("Vincent", "EVIEUX", "VEVIEUX", "motdepasse", 25);
                    testSerializableUtilisateur(utilisateur, "utilisateur.ser");
                    System.out.println("Réinitialisation de l'objet avant dé-sérialisation");
                    System.out.println(utilisateur.getPrenom());
                    System.out.println(utilisateur.getMotdepasse());
                    System.out.println(utilisateur.getNom());
                    System.out.println(utilisateur.getAge());
                    System.out.println(utilisateur.getLogin());
                    utilisateur = new Utilisateur(null, null, null, null, 0);
                    utilisateur = testDeSerializableUtilisateur("utilisateur.ser");
                    System.out.println("Objet lu après dé-sérialisation");
                    System.out.println(utilisateur.getPrenom());
                    System.out.println(utilisateur.getMotdepasse());
                    System.out.println(utilisateur.getNom());
                    System.out.println(utilisateur.getAge());
                    System.out.println(utilisateur.getLogin());
                    break;
            }
            System.out.println("Appuyer sur une touche pour continuer");
            clavier.nextLine();
        }
    }

    /**
     * Demande une chaine à l'utilisateur pour la renverser caractère par caractère
     */
    private static void reverseChaine() {
        System.out.println("Entrez une chaine :");
        String chaineReverse = "";
        Scanner clavier = new Scanner(System.in);
        String chaine = clavier.next();
        int longueur = chaine.length();

        //Renversement de la chaine
        for (int i = longueur - 1; i >= 0; i--) {
            chaineReverse += chaine.charAt(i);
        }
        System.out.println("Chaine normale : " + chaine);
        System.out.println("Chaine inversée : " + chaineReverse);

    }

    /**
     * Demande une chaine de caractère à l'utilisateur et en fait une pyramide
     * Attention : Si la chaine est paire, la pyramide s'arrête à longueur(chaine) -1
     */
    private static void pyramideChaine() {
        System.out.println("Entrez une chaine :");
        Scanner clavier = new Scanner(System.in);
        String chaine = clavier.next();
        int espace = chaine.length() / 2;
        //Boucle pour le nombre de lignes
        for (int i = 1; i < chaine.length(); i = i + 2) {
            String sRet = "";
            //Boucle pour le d'espace pour centrer la pyramide
            for (int k = 0; k < espace; k++) {
                sRet += " ";
            }
            //Boucle pour le nombre de caractères par ligne
            for (int j = 0; j < i; j++) {
                sRet += chaine.charAt(j);
            }
            espace--;
            System.out.println(sRet);
        }
    }

    /**
     * A partir d'un entier donné par l'utilisateur,
     * utilise la formule mathématique pour
     * donner la somme des entiers
     * compris entre 1 et l'entier donné
     */
    private static void sumNumber() {
        int number = inputNumber();
        //Formule mathématique de la somme d'entier de 1 à number
        System.out.println((number + 1) * (number / 2));
    }

    /**
     * Pour un entier donné par l'utilisateur,
     * vérifie dans un premier temps s'il est pair.
     * Puis, s'il n'est pas premier, c'est qu'il est impair.
     */
    private static void isPremier() {
        boolean fPremier = true;
        int monEntier = inputNumber();
        double nRet = monEntier % 2;
        //Si nRet n'est pas pair :
        if (nRet != 0) {
            for (int i = 3; i < monEntier - 1; i++) {
                //Si le nombre en entrée est divisible, par autre chose que 1 et lui
                // même il n'est pas premier
                if (monEntier % i == 0) {
                    fPremier = false;
                    break;
                }
            }
            if (fPremier) {
                System.out.println("Le nombre " + monEntier + " est un nombre premier");
            } else {
                System.out.println("Le nombre " + monEntier + " est un nombre impair");
            }
        } else {
            System.out.println("Le nombre " + monEntier + " est un nombre pair");
        }
    }

    /**
     * Le jeu du "c'est plus c'est moins".
     * A partir d'un nombre entre 1 et 1000 compris,
     * le joueur doit trouver le nombre avec comme indication que ce dernier est supérieur
     * ou inférieur au nombre donné. Se termine avec le bon nombre.
     */
    private static void searchNumber() {
        int nRet = 0;
        int compte = 0;
        System.out.println("Le nombre est entre 1 et 1000 comprit");
        double monEntier = inputNumber();
        //nTrouve est choisi au hasard entre [1;1000]
        double nTrouve = new Random().nextInt(1000) + 1;
        //Tant que le nombre en entrée terminal n'est pas le nombre choisi au hasard
        while (nTrouve != monEntier) {
            compte += 1;
            if (nTrouve / monEntier > 1.0) {
                System.out.println("Plus grand");
            } else {
                System.out.println("Plus petit");
            }
            monEntier = inputNumber();
        }
        System.out.println("Félicitation vous avez trouvé le nombre en " + compte + " coup(s)");
    }

    /**
     * Fonction technique permettant de vérifier si la chaine rentrée
     * par l'utilisateur est un chiffre ou nombre uniquement.
     * Ne présente donc peu d'intérêt pour le module en cours
     */
    public static int inputNumber() {
        int nRet = 0;
        boolean fRet = true;
        System.out.println("Entrez un entier :");
        Scanner clavier = new Scanner(System.in);
        while (fRet) {
            try {
                nRet = clavier.nextInt();
            } catch (Exception e) {
                System.out.println("Veuillez rentrer un nombre");
            } finally {
                fRet = false;
            }
        }
        return nRet;
    }

    /**
     * Pour une phrase séparée par des espaces (" ")
     * la fonction sépare cette dernière puis somme
     * le nombre de séparations créées.
     */
    private static int sumWords(String phrase) {


        // Compter le nombre de mots dans la phrase
        String[] mots = phrase.trim().split("\\s+");
        int nombreDeMots = mots.length;
        return nombreDeMots;
        //System.out.println("Le nombre de mots dans la phrase est : " + nombreDeMots);
    }

    /**
     * Pour une phrase donnée en paramètre la fonction
     * sauvegarde cette phrase dans le fichier nommé en paramètre.
     * Le créé si besoin.
     */
    private static void savetoTXT(String phrase, String nomFichier) {
        File fichier = new File(nomFichier);

        try {
            if (!fichier.exists()) {
                fichier.createNewFile();
            }
            FileWriter writer = new FileWriter(fichier, true);
            writer.write(phrase);
            writer.write("\n");
            writer.close();
            System.out.println("La phrase a été enregistrée dans le fichier" + nomFichier);
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'enregistrement dans le fichier.");
            e.printStackTrace();
        }
    }

    /**
     * A partir d'un fichier donné par l'utilisateur,
     * ouvre le fichier et comptes le nombre de mots présent.
     * Se ferme avec un retour d'erreur si le fichier n'existe pas
     */
    private static void ReadFileAndSumWords() throws FileNotFoundException {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Indiquez le fichier dans lequel il faut compter les mots :");
        String nomFichier = clavier.nextLine();

        FileOutputStream monFichier = null;
        File fichier = new File(nomFichier);

        try {
            Scanner scanner = new Scanner(fichier);
            int count = 0;
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                if (ligne != "") {
                    count += sumWords(ligne);
                }
            }
            System.out.println(count);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé.");
            //e.printStackTrace();
        }

    }

    /**
     * Fonction permettant de tester les get/set des classes
     * ainsi que quelques méthodes implémentées si présentes
     */
    private static void testClasses() {
        Voiture voiture = new Voiture("Peugeot 2008", 35000, 110, "Bleu");
        voiture.getDesignation();
        System.out.println("Test voiture :");
        System.out.println(voiture.getPrixHT());
        System.out.println(voiture.getPrixAvecTaxes(0.2));
        System.out.println("----------------");
        Rectangle rectangle = new Rectangle(4, 2);
        System.out.println("Test rectangle :");
        System.out.println(rectangle.getLargeur());
        System.out.println(rectangle.getLongueur());
        rectangle.display();
        System.out.println("----------------");
        Utilisateur utilisateur = new Utilisateur("Vincent", "EVIEUX", "VEVIEUX", "motdepasse", 25);
        System.out.println("Test utilisateur");
        System.out.println(utilisateur.getLogin());
        System.out.println(utilisateur.getNom());
        System.out.println(utilisateur.getPrenom());
        System.out.println(utilisateur.getAge());
        System.out.println("----------------");
        Square square = new Square(3);
        System.out.println("Test Square");
        System.out.println(square.getLargeur());
        System.out.println(square.getLongueur());
        System.out.println(square.calculAire());
        square.display();
        System.out.println("----------------");

    }

    /**
     * La fonction teste si les singletons sont correctement implémentés
     */
    private static void testSingleton() {
        SingleObject object = SingleObject.getInstance();
        SingleObject object2 = SingleObject.getInstance();
        SingleObject object3 = SingleObject.getInstance();

        System.out.println(object);
        System.out.println(object2);
        System.out.println(object3);

    }

    /**
     * Serialise un objet passé en paramètre dans le fichier donné en paramètre
     * Créé le fichier si nécessaire.
     */
    private static void testSerializableUtilisateur(Object objet, String nomFichier) {
        ObjectOutputStream oos = null;
        try {
            final FileOutputStream fichier = new FileOutputStream(nomFichier);
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(objet);
            System.out.println("Ecriture de l'object dans le fichier : " + nomFichier);
            oos.flush();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * À partir du nom de fichier donné, désérialise l'utilisateur contenu
     * et le renvoi
     */
    private static Utilisateur testDeSerializableUtilisateur(String nomFichier) {
        ObjectInputStream ois = null;
        Utilisateur utilisateur = null;
        try {
            final FileInputStream fichier = new FileInputStream(nomFichier);
            ois = new ObjectInputStream(fichier);
            utilisateur = (Utilisateur) ois.readObject();

        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        return utilisateur;
    }
}
