package Classes;

public class Square extends Rectangle{
    private final int longueur;
    public Square(int largeur) {
        super(largeur,largeur);
        this.longueur = this.getLargeur();

    }

    public int calculAire() {
        return longueur*longueur;
    }

}