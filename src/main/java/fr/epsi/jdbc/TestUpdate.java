package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;

public class TestUpdate {
    public static boolean updateFournisseur(Fournisseur fournisseur, String nom) {
        FournisseurDaoJdbc fdao = new FournisseurDaoJdbc();
        return fdao.update(fournisseur.getNom(), nom) > 0;
    }
}
