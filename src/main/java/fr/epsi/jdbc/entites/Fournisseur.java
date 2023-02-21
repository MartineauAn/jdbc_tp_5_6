package fr.epsi.jdbc.entites;

public class Fournisseur {
    private Integer id;
    private String nom;

    public Fournisseur(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Fournisseur(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                "}\n";
    }
}
