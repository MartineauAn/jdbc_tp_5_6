package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Fournisseur;
import java.util.List;

public class TestSelect{

    public static List<Fournisseur> selectFournisseurs() {
        FournisseurDaoJdbc fdao = new FournisseurDaoJdbc();
        return fdao.extraire();
    }

    public static void printFournisseurs(){
        List<Fournisseur> fournisseurs;

        fournisseurs = selectFournisseurs();

        for (Fournisseur fournisseur : fournisseurs){
            System.out.println(fournisseur);
        }

        System.out.println();
    }
}
