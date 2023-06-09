package Classes;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    private String prenom;
    private String nom;
    private String login;
    private String motdepasse;
    private int age;

    public Utilisateur(String prenom, String nom, String login, String motdepasse, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.motdepasse = motdepasse;
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
