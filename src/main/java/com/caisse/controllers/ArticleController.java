package com.caisse.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


import com.caisse.models.Article;

import de.vandermeer.asciitable.AsciiTable;

public class ArticleController {

    public static void index() throws SQLException {
        System.out.println("Toutes les Articles !!");
        ArrayList<Article> articles = Article.all();
        
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow(null, null, null, "Articles");
        at.addRule();
        at.addRow("id", "nom", "prix", "quantite");
        at.addRule();

        for (Article article : articles) {
            at.addRow(article.id, article.nom, article.prix + " $", article.quantite);
            at.addRule();
        }
        String rend = at.render();
        System.out.println(rend);
    }

    public static void create() throws SQLException {
        Article article = new Article();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom d'article : ");
        article.nom = scanner.nextLine();
        System.out.print("Prix : ");
        article.prix = scanner.nextFloat();
        System.out.print("quantite : ");
        article.quantite = scanner.nextInt();
        if (article.save()) {
            System.out.println("Article Ajouter");
        }
        
    }

    public static void show() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Id d'article: ");
        int id = scanner.nextInt();

        Article article = Article.find(id);

        if (article.id != 0) {
            AsciiTable at = new AsciiTable();
            at.addRule();
            at.addRow(null, null, null, "Articles");
            at.addRule();
            at.addRow("id", "nom", "prix", "quantite");
            at.addRule();
            at.addRow(article.id, article.nom, article.prix + " $", article.quantite);
            at.addRule();
    
            String rend = at.render();
            System.out.println(rend);
        }else {
            System.out.println("L'article n'existe pas !!");
        }

    }

    public static void delete() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Id de article: ");
        int id = scanner.nextInt();

        Article article = Article.find(id);
        if (article.delete()) {
            System.out.println("Article supprimé !!");
        }
        
    }
}
