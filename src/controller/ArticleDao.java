package controller;

import java.sql.*;

import model.Article;
import model.User;

public class ArticleDao {
    //Appel de la connection
    Connection connect = GetConnection.getConnection();

    public void create(Article article) {

        try {
            PreparedStatement sql = connect.prepareStatement("INSERT INTO articles (titre, resume,contenu, created_at, auteur) VALUES"
                    + "(?,?,?,NOW(),?)");
            sql.setString(1, article.getTitre());
            sql.setString(2, article.getResume());
            sql.setString(3, article.getContenu());
            sql.setString(4, User.currentUser.getEmail());

            sql.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void readAll() {

        try {
            PreparedStatement sql = connect.prepareStatement("SELECT * FROM articles ");
            ResultSet rs = sql.executeQuery();
            int i = 0;
            while (rs.next()) {
                java.util.Date utilDate = new java.util.Date(rs.getDate("created_at").getTime());
                Article.listeArticles.add(i, new Article(rs.getString("titre"), rs.getString("resume"), rs.getString("contenu"), utilDate, rs.getString("auteur")));
            }
            System.out.println(Article.listeArticles);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}