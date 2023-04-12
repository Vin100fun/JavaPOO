import javax.swing.filechooser.FileView;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static String chaine = "abcdefghijklmnopqrstuvwxyz";

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
                    savetoTXT(phrase,nomFichier);
                    break;
                case 8 :
                    ReadFileAndSumWords();
                    break;
            }

            System.out.println("Appuyer sur une touche pour continuer");
            clavier.nextLine();

        }


    }

    private static void reverseChaine() {
        System.out.println("Entrez une chaine :");
        Scanner clavier = new Scanner(System.in);
        String chaine = clavier.next();
        int longueur = chaine.length();
        String chaineReverse = "";
        for (int i = longueur - 1; i >= 0; i--) {
            chaineReverse += chaine.charAt(i);
        }
        System.out.println("Chaine normale : " + chaine);
        System.out.println("Chaine inversée : " + chaineReverse);

    }

    private static void pyramideChaine() {
        System.out.println("Entrez une chaine :");
        Scanner clavier = new Scanner(System.in);
        String chaine = clavier.next();
        int espace = chaine.length() / 2;
        for (int i = 1; i < chaine.length(); i = i + 2) {
            String sRet = "";
            for (int k = 0; k < espace; k++) {
                sRet += " ";
            }
            for (int j = 0; j < i; j++) {
                sRet += chaine.charAt(j);
            }
            espace--;
            System.out.println(sRet);
        }
    }

    private static void sumNumber() {
        int number = inputNumber();
        System.out.println((number + 1) * (number / 2));
    }

    private static void isPremier() {
        boolean fPremier = true;
        int monEntier = inputNumber();
        double nRet = monEntier % 2;
        if (nRet != 0) {
            for (int i = 3; i < monEntier - 1; i++) {
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

    private static void searchNumber() {
        int nRet = 0;
        int compte = 0;
        System.out.println("Le nombre est entre 1 et 1000 comprit");
        double monEntier = inputNumber();
        double nTrouve = new Random().nextInt(1000) + 1;

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

    public static int inputNumber() {
        int nRet = 0;
        boolean fRet = true;
        System.out.println("Entrez un entier :");
        Scanner clavier = new Scanner(System.in);
        while (fRet) {
            try {
                nRet = clavier.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("Veuillez rentrer un nombre");
            } finally {
                fRet = false;
            }
        }
        return nRet;
    }

    private static int sumWords(String phrase) {


        // Compter le nombre de mots dans la phrase
        String[] mots = phrase.trim().split("\\s+");
        int nombreDeMots = mots.length;
        return nombreDeMots;
        //System.out.println("Le nombre de mots dans la phrase est : " + nombreDeMots);
    }

    private static void savetoTXT(String phrase,String nomFichier) {


        File fichier = new File(nomFichier);

        try {
            if (!fichier.exists()) {
                fichier.createNewFile();
            }
            FileWriter writer = new FileWriter(fichier,true);
            writer.write(phrase);
            writer.write("\n");
            writer.close();
            System.out.println("La phrase a été enregistrée dans le fichier" + nomFichier);
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'enregistrement dans le fichier.");
            e.printStackTrace();
        }
    }

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
}