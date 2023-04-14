package Services;

import Classes.Banque;
import Classes.CompteBancaire;
import Classes.Utilisateur;

import java.util.ArrayList;
import java.util.List;

public class BanqueService {
    public void addComptes(Banque banque,List<CompteBancaire> comptesClient) {
        for (CompteBancaire compteBancaire : comptesClient) {
            banque.addComptesBancaire(compteBancaire);
        }
    }



}
