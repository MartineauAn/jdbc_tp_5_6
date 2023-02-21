package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;

public class TestInsertion {
    public static void insertionFournisseur(Fournisseur fournisseur) {

        FournisseurDaoJdbc fdao = new FournisseurDaoJdbc();
        fdao.insert(fournisseur);
    }
}
