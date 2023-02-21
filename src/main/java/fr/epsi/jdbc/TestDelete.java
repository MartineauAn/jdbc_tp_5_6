package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;
public class TestDelete {

    public static boolean deleteFournisseur(Fournisseur fournisseur) {

        FournisseurDaoJdbc fdao = new FournisseurDaoJdbc();
        return fdao.delete(fournisseur);

    }
}
