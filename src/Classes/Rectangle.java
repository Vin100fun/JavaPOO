package Classes;

public class Rectangle {
    private int largeur;
    private int longueur;


    public Rectangle(int largeur, int longueur) {
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public void display() {
        String sRet = null;
        for (int i = 0; i < longueur; i++) {
            sRet = "";
            for (int j = 0; j < largeur; j++) {
                sRet += "#";
            }
            System.out.println(sRet);
        }

    }
}
