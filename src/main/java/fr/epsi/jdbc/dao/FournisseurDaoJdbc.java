package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDaoJdbc extends DatabaseDao implements FournisseurDao{
    @Override
    public List<Fournisseur> extraire() {

        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

        String sql = "SELECT * FROM FOURNISSEUR;";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while (rs.next()){
                fournisseurs.add(new Fournisseur(rs.getInt("ID"),rs.getString("NOM")));
            }

        } catch (SQLException e) {
            // Handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }
        return fournisseurs;
    }

    @Override
    public Fournisseur getById(Integer id) {

        String sql = "SELECT * FROM FOURNISSEUR WHERE ID = " + id + ";";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            if (rs.next()){
                return new Fournisseur(rs.getInt("ID"),rs.getString("NOM"));
            }

        } catch (SQLException e) {
            // Handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void insert(Fournisseur fournisseur) {
        String sql = "INSERT INTO FOURNISSEUR (NOM) VALUES (?);";
        try (Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
             PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, fournisseur.getNom());

            stmt.executeUpdate();

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if (rs.next()){
                    fournisseur.setId(rs.getInt(1));
                }
            }
            catch (SQLException e){
                System.out.println("An error occurred: " + e.getMessage());
            }
        } catch (SQLException e) {
            // Handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

    @Override
    public int update(String ancienNom, String nouveauNom) {
        String sql = "UPDATE FOURNISSEUR SET NOM = ? Where NOM = ?;";

        try (Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
             PreparedStatement stmt = conn.prepareStatement(sql);) {

            // Set the parameters
            stmt.setString(1, nouveauNom);
            stmt.setString(2, ancienNom);

            // Execute the statement
            return stmt.executeUpdate();

        } catch (SQLException e) {
            // Handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        String sql = "DELETE FROM FOURNISSEUR Where id = ?;";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.println(fournisseur);

            stmt.setInt(1, fournisseur.getId());

            // Execute the statement
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            // Handle the exception
            System.out.println("An error occurred: " + e.getMessage());
        }

        return false;
    }


}
