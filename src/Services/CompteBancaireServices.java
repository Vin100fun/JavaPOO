package Services;

import Classes.CompteBancaire;

public class CompteBancaireServices {
    public void transfert(CompteBancaire compteDebiteur, CompteBancaire compteCredite, double montant) {
        if (compteDebiteur.debit(montant) ) {
            compteCredite.credit(montant);
        } else {
            System.out.println("Erreur, solde du compte débiteur insuffisant");
        }
    }
}
