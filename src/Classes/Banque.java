package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Banque implements Serializable {
    private String nomBanque;

    public Banque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    private List<CompteBancaire> comptesBancaire = new ArrayList<>();

    public String getNomBanque() {
        return nomBanque;
    }

    public void setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }

    public List<CompteBancaire> getComptesBancaire() {
        return comptesBancaire;
    }

    public void setComptesBancaire(List<CompteBancaire> comptesBancaire) {
        this.comptesBancaire = comptesBancaire;
    }

    public void addComptesBancaire(CompteBancaire compteBancaire) {
        this.comptesBancaire.add(compteBancaire);
    }

    public void supComptesBancaire(CompteBancaire compteBancaire) {
        this.comptesBancaire.remove(compteBancaire);
    }





}