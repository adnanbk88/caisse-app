package com.caisse.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Article extends Model {
    public int id;
    public String nom;
    public float prix;
    public int quantite;

    public static ArrayList<Article> all() throws SQLException {
        String sql = "SELECT * FROM articles";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        // Map table to articles
        ArrayList<Article> articles = new ArrayList<Article>();

        while (result.next()) {
            Article article = new Article();
            article.id = result.getInt("id");
            article.nom = result.getString("nom");
            article.prix = result.getFloat("prix");
            article.quantite = result.getInt("quantite");

            articles.add(article);
        }
        return articles;
    }
    public Boolean save() throws SQLException {
        String sql = "INSERT INTO articles (nom, prix, quantite) VALUES (?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, this.nom);
        statement.setFloat(2, this.prix);
        statement.setInt(3, this.quantite);

        int inserted = statement.executeUpdate();
        if (inserted > 0) {
            return true;
        }else {
            return false;
        }
    }
    
    public static Article find(int id) throws SQLException {
        String sql = "SELECT * FROM articles where id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, id);

        ResultSet result = statement.executeQuery();

        Article article = new Article();
        while (result.next()) {
            article.id = result.getInt("id");
            article.nom = result.getString("nom");
            article.prix = result.getFloat("prix");
            article.quantite = result.getInt("quantite");
        }
        return article; 
    }

    public Boolean delete() throws SQLException {
        String sql = "DELETE FROM articles where id =?";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setInt(1, this.id);

        int inserted = statement.executeUpdate();
        if (inserted > 0) {
            return true;
        }else {
            return false;
        }
    }
}
