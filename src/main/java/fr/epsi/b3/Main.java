package fr.epsi.b3;

import fr.epsi.jdbc.TestDelete;
import fr.epsi.jdbc.TestInsertion;
import fr.epsi.jdbc.TestSelect;
import fr.epsi.jdbc.TestUpdate;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        testFournisseur();

    }

    public static void testFournisseur(){
        Fournisseur f;

        f = new Fournisseur("L’Espace Création"); //Avec le prepared statement ça fonctionne ;)

        TestInsertion.insertionFournisseur(f);

        TestSelect.printFournisseurs();

        TestUpdate.updateFournisseur(f, "issou 2");

        TestSelect.printFournisseurs();

        if (f.getId() != null){
            TestDelete.deleteFournisseur(f);
        }

        TestSelect.printFournisseurs();
    }
}