package Classes;

import java.io.Serializable;

public class CompteBancaire implements Serializable {
    int numeroCompte;
    Utilisateur utilisateur;
    double montant;
    double fraisBancaires;

    public CompteBancaire(int numeroCompte, Utilisateur utilisateur, double montant, double fraisBancaires) {
        this.numeroCompte = numeroCompte;
        this.utilisateur = utilisateur;
        this.montant = montant;
        this.fraisBancaires = montant*0.001;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean debit(double montant) {
        if (this.montant >= montant) {
            this.montant -= montant;
            return true;
        } else {
            return false;
        }
    }

    public void credit(double montant) {
        this.montant += montant;
    }

}
