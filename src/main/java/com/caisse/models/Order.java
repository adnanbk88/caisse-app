package com.caisse.models;

public class Order extends Model{
    
    public Article article;
    public int quantite;

    public Order(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }
}
