package com.example.td2_jee.Models;

public class User {


    private String login;
    private String motDePasse;

    public User() {
    }

    public User(String login, String motDePasse) {
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }


}
