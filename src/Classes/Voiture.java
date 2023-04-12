package Classes;

public class Voiture {

    private String designation;
    private double prixHT;
    private int chevaux;

    public Voiture(String designation, double prixHT, int chevaux, String couleur) {
        this.designation = designation;
        this.prixHT = prixHT;
        this.chevaux = chevaux;
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    private String couleur;


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prix) {
        this.prixHT = prix;
    }

    public int getChevaux() {
        return chevaux;
    }

    public void setChevaux(int chevaux) {
        this.chevaux = chevaux;
    }

    public double getPrixAvecTaxes(double taxes) {
        return prixHT*taxes;
    }

}
