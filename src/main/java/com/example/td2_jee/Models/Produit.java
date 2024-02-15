package com.example.td2_jee.Models;

public class Produit {
    private int id;
    private String nom;
    private int qte;

    public Produit(int id, String nom, int qte) {
        this.id = id;
        this.nom = nom;
        this.qte = qte;
    }

    public Produit(String nom, int qte) {
        this.nom = nom;
        this.qte = qte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", qte=" + qte +
                '}';
    }
}
