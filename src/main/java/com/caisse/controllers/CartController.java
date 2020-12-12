package com.caisse.controllers;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

import com.caisse.App;
import com.caisse.models.Article;
import com.caisse.models.Order;

import de.vandermeer.asciitable.AsciiTable;

public class CartController {

    public static ArrayList<Order> orders = new ArrayList<Order>();
    
    public static void addToCart() throws SQLException {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nId d'article : ");
        Article article = Article.find(scanner.nextInt());
        if (article.id == 0) {
            System.out.println("* L'article n'existe pas  !!");
            System.out.println("* tAfficher tous les articles : art all");
        } else {
            System.out.print("quantite : ");
            int quantite = scanner.nextInt();
            if (article.quantite < quantite) {
                System.out.println("* il rest que "+ article.quantite +" unit de cet article");
            } else {
                orders.add(new Order(article, quantite));
                System.out.println("---------------------------");
            }
        }
            
    }

    public static void all() {
        AsciiTable at = new AsciiTable();
        if(orders.size() > 0){
            at.addRule();
            at.addRow(null, null, null, "Orders");
            at.addRule();
            at.addRow("article", "prix d'article", "quantite", "prix total");
            at.addRule();
    
            for (Order order : orders) {
                at.addRow(order.article.nom, order.article.prix + " $", order.quantite, order.article.prix * order.quantite + " $");
                at.addRule();
            }
            at.addRow(null, null, "prix total", totalPrice(orders)+ " $");
            at.addRule();
            String rend = at.render();
            System.out.println(rend);
        }else {
            System.out.println("pas encore de commandes !!");
        }
    }
    public static float totalPrice(ArrayList<Order> orders) {
        float count = 0;
        for (Order order : orders) {
            count += order.article.prix * order.quantite;
        }
        return count;
    }
    public static void getCash() throws SQLException {
        if (orders.size() > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Cash : ");
            float cash = scanner.nextFloat();
            if (cash >= totalPrice(orders)) {
                AsciiTable at = new AsciiTable();
                at.addRule();
                at.addRow(null, null, null, "Orders");
                at.addRule();
                at.addRow("article", "prix d'article", "quantite", "prix total");
                at.addRule();
        
                for (Order order : orders) {
                    at.addRow(order.article.nom, order.article.prix + " $", order.quantite, order.article.prix * order.quantite + " $");
                    at.addRule();
                }
                at.addRow(null, null, "prix total", totalPrice(orders)+ " $");
                at.addRule();
                at.addRow(null, null, "cash", cash+ " $");
                at.addRule();
                at.addRow(null, null, "a rendre", calcrendre(cash, totalPrice(orders))+ " $");
                at.addRule();
                String rend = at.render();
                System.out.println(rend);
                if (saveOrders(rend)) {
                    System.out.println("Commandes enregistrées !!!");
                    orders.clear(); 
                }
            }else {
                System.out.println("besoin de plus d'argent !!");
            }
            
        }else {
            System.out.println("pas encore de commandes !!");
        }
    }
    public static boolean saveOrders(String text) throws SQLException {
        String sql = "INSERT INTO orders (orders) VALUES (?)";
        PreparedStatement statement = App.conn.prepareStatement(sql);

        statement.setString(1, text);

        int inserted = statement.executeUpdate();
        if (inserted > 0) {
            return true;
        }else {
            return false;
        }
    }
    public static float calcrendre(float cash, float prix) {
        return cash - prix > 0 ? cash - prix : 0;
    }
    
}
