package com.example.bo;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String Login;
    private String password;
    private int bestScore=0;

    public Utilisateur(String nom, String prenom, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        Login = login;
        this.password = password;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }
    public void setLogin(String login) {
        Login = login;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public int getBestScore() {
        return bestScore;
    }
    public String getLogin() {
        return Login;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", Login='" + Login + '\'' +
                ", password='" + password + '\'' +
                ", bestScore=" + bestScore +
                '}';
    }
}
