package fr.epsi.jdbc;

import fr.epsi.jdbc.dao.ArticleDao;
import fr.epsi.jdbc.dao.ArticleDaoJdbc;
import fr.epsi.jdbc.dao.FournisseurDao;
import fr.epsi.jdbc.dao.FournisseurDaoJdbc;
import fr.epsi.jdbc.entites.Article;
import fr.epsi.jdbc.entites.Fournisseur;
import java.util.List;

public class TestJdbcArticles {
    public static void main(String[] args) {
        Fournisseur f = new Fournisseur("La Maison de la Peinture");

        FournisseurDao fournisseurDao = new FournisseurDaoJdbc();
        ArticleDao articleDao = new ArticleDaoJdbc();

        //Insertion fournisseur
        System.out.println("Insertion fournisseur -------------------------------");
        fournisseurDao.insert(f);
        System.out.println("Fournisseur inséré avec l'id : " + f.getId());
        List<Fournisseur> fournisseurs = fournisseurDao.extraire();
        System.out.println();
        System.out.println(fournisseurs);

        //Insertion articles
        System.out.println();
        System.out.println("Insertion articles ---------------------------------");
        Article a1 = new Article("#00001","Peinture blanche 1L",12.5,f);
        Article a2 = new Article("#00002","Peinture rouge mate  1L",15.5,f);
        Article a3 = new Article("#00003","Peinture noire laquée  1L",17.8,f);
        Article a4 = new Article("#00004","Peinture bleue mate 1L",15.5,f);
        articleDao.insert(a1);
        articleDao.insert(a2);
        articleDao.insert(a3);
        articleDao.insert(a4);

        List<Article> articles = articleDao.extraire();

        System.out.println();
        System.out.println(articles);

        //Diminution des prix
        System.out.println();
        System.out.println("Diminution des prix ---------------------------------");
        articleDao.updatePrix("mate",25.0);
        articles = articleDao.extraire();
        System.out.println();
        System.out.println(articles);

        //Liste de tous articles
        System.out.println();
        System.out.println("Liste de tous les articles ---------------------------------");
        articles = articleDao.extraire();
        System.out.println();
        System.out.println(articles);

        //Moyenne
        double moyenne = articleDao.moyennePrix();
        System.out.println();
        System.out.println("Moyenne ---------------------------------");
        System.out.println();
        System.out.println("Moyenne : " + moyenne + " €");

        //Supprimer toutes les peintures
        System.out.println();
        System.out.println("Suppression articles peinture ---------------------------------");
        articleDao.deleteLike("Peinture");
        articles = articleDao.extraire();
        System.out.println();
        System.out.println(articles);

        //Supprimer fournisseur
        System.out.println();
        System.out.println("Suppression founisseur ---------------------------------");
        fournisseurDao.delete(f);
        fournisseurs = fournisseurDao.extraire();
        System.out.println();
        System.out.println(fournisseurs);

    }
}
