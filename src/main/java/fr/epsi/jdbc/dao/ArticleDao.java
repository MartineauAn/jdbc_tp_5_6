package fr.epsi.jdbc.dao;

import fr.epsi.jdbc.entites.Article;
import fr.epsi.jdbc.entites.Fournisseur;

import java.util.List;

public interface ArticleDao {
    List<Article> extraire();
    void insert(Article article);
    int update(String ref, String nouvelleDesignation);
    boolean delete(Article article);
    int updatePrix(String designation, Double promotion);
    double moyennePrix();
    boolean deleteLike(String designation);

}
