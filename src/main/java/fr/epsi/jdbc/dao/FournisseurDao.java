package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Fournisseur;

import java.util.List;

public interface FournisseurDao {
    List<Fournisseur> extraire();

    Fournisseur getById(Integer id);
    void insert(Fournisseur fournisseur);
    int update(String ancienNom, String nouveauNom);
    boolean delete(Fournisseur fournisseur);
}
